#include <jni.h>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <random>
#include <android/log.h>
#include <sys/time.h>

#include "SKP_Silk_SDK_API.h"
#include "SKP_Silk_SigProc_FIX.h"

/* Define codec specific settings */
#define MAX_BYTES_PER_FRAME_ENC     250 // Equals peak bitrate of 100 kbps
#define MAX_INPUT_FRAMES        5
#define FRAME_LENGTH_MS         20
#define MAX_API_FS_KHZ          48


/* Define codec specific settings should be moved to h file */
#define MAX_BYTES_PER_FRAME_DEC     1024
#define MAX_INPUT_FRAMES        5
#define MAX_FRAME_LENGTH        480
#define FRAME_LENGTH_MS         20
#define MAX_API_FS_KHZ          48
#define MAX_LBRR_DELAY          2

#ifdef _SYSTEM_IS_BIG_ENDIAN
/* Function to convert a little endian int16 to a */
/* big endian int16 or vica verca                 */
void swap_endian(
    SKP_int16       vec[],
    SKP_int         len
)
{
    SKP_int i;
    SKP_int16 tmp;
    SKP_uint8 *p1, *p2;

    for( i = 0; i < len; i++ ){
        tmp = vec[ i ];
        p1 = (SKP_uint8 *)&vec[ i ]; p2 = (SKP_uint8 *)&tmp;
        p1[ 0 ] = p2[ 1 ]; p1[ 1 ] = p2[ 0 ];
    }
}
#endif

#if (defined(_WIN32) || defined(_WINCE))
#include <windows.h>	/* timer */
#else    // Linux or Mac
#include <sys/time.h>
#endif

#ifdef _WIN32

unsigned long GetHighResolutionTime() /* O: time in usec*/
{
    /* Returns a time counter in microsec	*/
    /* the resolution is platform dependent */
    /* but is typically 1.62 us resolution  */
    LARGE_INTEGER lpPerformanceCount;
    LARGE_INTEGER lpFrequency;
    QueryPerformanceCounter(&lpPerformanceCount);
    QueryPerformanceFrequency(&lpFrequency);
    return (unsigned long)((1000000*(lpPerformanceCount.QuadPart)) / lpFrequency.QuadPart);
}
#else    // Linux or Mac
unsigned long GetHighResolutionTime() /* O: time in usec*/
{
    struct timeval tv;
    gettimeofday(&tv, 0);
    return((tv.tv_sec*1000000)+(tv.tv_usec));
}
#endif // _WIN32

/* Seed for the random number generator, which is used for simulating packet loss */
static SKP_int32 rand_seed = 1;

int silk_encode(int rate, char type, const char* inputFile, const char* outPutFile);

extern "C"
JNIEXPORT jint JNICALL
Java_moe_fuqiuluo_shamrock_utils_AudioUtils_pcmToSilk(JNIEnv *env, jobject thiz,
                                             jint rate,
                                             jbyte type,
                                             jstring pcm_file,
                                             jstring silk_file) {
    auto pcm = env->GetStringUTFChars(pcm_file, nullptr);
    auto silk = env->GetStringUTFChars(silk_file, nullptr);
    return silk_encode(rate, type, pcm, silk);
}

int silk_encode(int rate, char type, const char* inputFile, const char* outPutFile) {
    double    filetime;
    size_t    counter;
    SKP_int32 k, totPackets, totActPackets, ret;
    SKP_int16 nBytes;
    double    sumBytes, sumActBytes, nrg;
    SKP_uint8 payload[ MAX_BYTES_PER_FRAME_ENC * MAX_INPUT_FRAMES ];
    SKP_int16 in[ FRAME_LENGTH_MS * MAX_API_FS_KHZ * MAX_INPUT_FRAMES ];
    char      speechInFileName[ 150 ], bitOutFileName[ 150 ];
    FILE      *bitOutFile, *speechInFile;
    SKP_int32 encSizeBytes;
    void      *psEnc;

#ifdef _SYSTEM_IS_BIG_ENDIAN
    SKP_int16 nBytes_LE;
#endif

    /* default settings */
    SKP_int32 API_fs_Hz = rate;
    SKP_int32 max_internal_fs_Hz;
    SKP_int32 targetRate_bps = 25000;
    SKP_int32 smplsSinceLastPacket, packetSize_ms = 20;
    SKP_int32 frameSizeReadFromFile_ms = 20;
    SKP_int32 packetLoss_perc = 0;
#if LOW_COMPLEXITY_ONLY
    SKP_int32 complexity_mode = 0;
#else
    SKP_int32 complexity_mode = 2;
#endif

    SKP_int32 DTX_enabled = 0, INBandFEC_enabled = 0;
    SKP_SILK_SDK_EncControlStruct encControl; // Struct for input to encoder
    SKP_SILK_SDK_EncControlStruct encStatus;  // Struct for status of encoder

    /* get arguments */
    strcpy( speechInFileName, inputFile );
    strcpy( bitOutFileName,   outPutFile );

    /* If no max internal is specified, set to minimum of API fs and 24 kHz */
    max_internal_fs_Hz = rate;

    /* Open files */
    speechInFile = fopen( speechInFileName, "rb" );
    if( speechInFile == nullptr ) {
        return -1;
    }
    bitOutFile = fopen( bitOutFileName, "wb" );
    if( bitOutFile == nullptr ) {
        return -2;
    }

    /* Add Silk header to stream */
    {
        char Tencent_break[1];
        Tencent_break[0] = type;
        fwrite( Tencent_break, sizeof( char ), 1, bitOutFile );

        static const char Silk_header[] = "#!SILK_V3";
        fwrite( Silk_header, sizeof( char ), strlen( Silk_header ), bitOutFile );
    }

    /* Create Encoder */
    ret = SKP_Silk_SDK_Get_Encoder_Size( &encSizeBytes );
    if( ret ) {
        __android_log_print(ANDROID_LOG_ERROR, "silk.cpp", "Error: SKP_Silk_create_encoder returned %d", ret );
        return  -3;
    }

    psEnc = malloc( encSizeBytes );

    /* Reset Encoder */
    ret = SKP_Silk_SDK_InitEncoder( psEnc, &encStatus );
    if( ret ) {
        __android_log_print(ANDROID_LOG_ERROR, "silk.cpp", "Error: SKP_Silk_reset_encoder returned %d", ret );
        return -4;
    }

    /* Set Encoder parameters */
    encControl.API_sampleRate        = API_fs_Hz;
    encControl.maxInternalSampleRate = max_internal_fs_Hz;
    encControl.packetSize            = ( packetSize_ms * API_fs_Hz ) / 1000;
    encControl.packetLossPercentage  = packetLoss_perc;
    encControl.useInBandFEC          = INBandFEC_enabled;
    encControl.useDTX                = DTX_enabled;
    encControl.complexity            = complexity_mode;
    encControl.bitRate               = targetRate_bps;

    totPackets           = 0;
    totActPackets        = 0;
    smplsSinceLastPacket = 0;
    sumBytes             = 0.0;
    sumActBytes          = 0.0;
    smplsSinceLastPacket = 0;

    while( true ) {
        /* Read input from file */
        counter = fread( in, sizeof( SKP_int16 ), ( frameSizeReadFromFile_ms * API_fs_Hz ) / 1000, speechInFile );
#ifdef _SYSTEM_IS_BIG_ENDIAN
        swap_endian( in, counter );
#endif
        if( ( SKP_int )counter < ( ( frameSizeReadFromFile_ms * API_fs_Hz ) / 1000 ) ) {
            break;
        }


        /* max payload size */
        nBytes = MAX_BYTES_PER_FRAME_ENC * MAX_INPUT_FRAMES;

        /* Silk Encoder */
        ret = SKP_Silk_SDK_Encode( psEnc, &encControl, in, (SKP_int16)counter, payload, &nBytes );
        if( ret ) {
            __android_log_print(ANDROID_LOG_ERROR, "silk.cpp",  "SKP_Silk_Encode returned %d", ret );
        }

        /* Get packet size */
        packetSize_ms = ( SKP_int )( ( 1000 * ( SKP_int32 )encControl.packetSize ) / encControl.API_sampleRate );
        smplsSinceLastPacket += ( SKP_int )counter;
        if( ( ( 1000 * smplsSinceLastPacket ) / API_fs_Hz ) == packetSize_ms ) {
            /* Sends a dummy zero size packet in case of DTX period  */
            /* to make it work with the decoder test program.        */
            /* In practice should be handled by RTP sequence numbers */
            totPackets++;
            sumBytes  += nBytes;
            nrg = 0.0;
            for( k = 0; k < ( SKP_int )counter; k++ ) {
                nrg += in[ k ] * (double)in[ k ];
            }
            if( ( nrg / ( SKP_int )counter ) > 1e3 ) {
                sumActBytes += nBytes;
                totActPackets++;
            }
            /* Write payload size */
#ifdef _SYSTEM_IS_BIG_ENDIAN
            nBytes_LE = nBytes;
            swap_endian( &nBytes_LE, 1 );
            fwrite( &nBytes_LE, sizeof( SKP_int16 ), 1, bitOutFile );
#else
            fwrite( &nBytes, sizeof( SKP_int16 ), 1, bitOutFile );
#endif
            /* Write payload */
            fwrite( payload, sizeof( SKP_uint8 ), nBytes, bitOutFile );
            smplsSinceLastPacket = 0;
            //fprintf(stderr, "\rPackets encoded:                %d", totPackets);
        }

    }

    /* Write dummy because it can not end with 0 bytes */
    nBytes = -1;

    /* Write payload size */
    fwrite( &nBytes, sizeof( SKP_int16 ), 1, bitOutFile );

    /* Free Encoder */
    free( psEnc );

    fclose( speechInFile );
    fclose( bitOutFile );

    filetime  = totPackets * 1e-3 * packetSize_ms;
    return (int) filetime;
}

extern "C"
JNIEXPORT jint JNICALL
Java_moe_fuqiuluo_shamrock_utils_AudioUtils_silkToPcm(JNIEnv *env, jobject thiz, jint rate, jbyte type,
                                             jstring pcm_file, jstring silk_file) {
    auto pcm = env->GetStringUTFChars(pcm_file, nullptr);
    auto silk = env->GetStringUTFChars(silk_file, nullptr);

    unsigned long tottime, starttime;
    size_t    counter;
    SKP_int32 totPackets, i, k, ret, tot_len;
    SKP_int16 len;
    SKP_int16 nBytes;
    SKP_uint8 payload[    MAX_BYTES_PER_FRAME_DEC * MAX_INPUT_FRAMES * ( MAX_LBRR_DELAY + 1 ) ];
    SKP_uint8 *payloadEnd, *payloadToDec = nullptr;
    SKP_uint8 FECpayload[ MAX_BYTES_PER_FRAME_DEC * MAX_INPUT_FRAMES ], *payloadPtr;
    SKP_int16 nBytesFEC;
    SKP_int16 nBytesPerPacket[ MAX_LBRR_DELAY + 1 ], totBytes;
    SKP_int16 out[ ( ( FRAME_LENGTH_MS * MAX_API_FS_KHZ ) << 1 ) * MAX_INPUT_FRAMES ], *outPtr;
    char      speechOutFileName[ 150 ], bitInFileName[ 150 ];
    FILE      *bitInFile, *speechOutFile;
    SKP_int32 API_Fs_Hz = rate;
    SKP_int32 decSizeBytes;
    void      *psDec;
    SKP_float loss_prob;
    SKP_int32 frames, lost;
    SKP_SILK_SDK_DecControlStruct DecControl;

    /* default settings */
    loss_prob = 0.0f;

    strcpy( bitInFileName, silk);
    strcpy( speechOutFileName, pcm);

    /* Open files */
    bitInFile = fopen( bitInFileName, "rb" );
    if( bitInFile == nullptr ) {
        __android_log_print(ANDROID_LOG_ERROR, "silk.cpp",  "Error: could not open input file %s", bitInFileName );
        return -1;
    }

    /* Check Silk header */
    {
        char header_buf[ 50 ];
        fread(header_buf, sizeof(char), 1, bitInFile);
        header_buf[ strlen( "" ) ] = '\0'; /* Terminate with a null character */
        if( strcmp( header_buf, "" ) != 0 ) {
            counter = fread( header_buf, sizeof( char ), strlen( "!SILK_V3" ), bitInFile );
            header_buf[ strlen( "!SILK_V3" ) ] = '\0'; /* Terminate with a null character */
            if( strcmp( header_buf, "!SILK_V3" ) != 0 ) {
                /* Non-equal strings */
                __android_log_print(ANDROID_LOG_ERROR, "silk.cpp",  "Error: Wrong Header %s", header_buf );
                return -2;
            }
        } else {
            counter = fread( header_buf, sizeof( char ), strlen( "#!SILK_V3" ), bitInFile );
            header_buf[ strlen( "#!SILK_V3" ) ] = '\0'; /* Terminate with a null character */
            if( strcmp( header_buf, "#!SILK_V3" ) != 0 ) {
                /* Non-equal strings */
                __android_log_print(ANDROID_LOG_ERROR, "silk.cpp",  "Error: Wrong Header %s", header_buf );
                return -3;
            }
        }
    }

    speechOutFile = fopen( speechOutFileName, "wb" );
    if( speechOutFile == nullptr ) {
        __android_log_print(ANDROID_LOG_ERROR, "silk.cpp",  "Error: could not open output file %s", speechOutFileName );
        return -4;
    }

    /* Set the samplingrate that is requested for the output */
    if( API_Fs_Hz == 0 ) {
        DecControl.API_sampleRate = 24000;
    } else {
        DecControl.API_sampleRate = API_Fs_Hz;
    }

    /* Initialize to one frame per packet, for proper concealment before first packet arrives */
    DecControl.framesPerPacket = 1;

    /* Create decoder */
    ret = SKP_Silk_SDK_Get_Decoder_Size( &decSizeBytes );
    if( ret ) {
        __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp",  "SKP_Silk_SDK_Get_Decoder_Size returned %d", ret );
    }
    psDec = malloc( decSizeBytes );

    /* Reset decoder */
    ret = SKP_Silk_SDK_InitDecoder( psDec );
    if( ret ) {
        __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp",  "SKP_Silk_InitDecoder returned %d", ret );
    }

    totPackets = 0;
    tottime    = 0;
    payloadEnd = payload;

    /* Simulate the jitter buffer holding MAX_FEC_DELAY packets */
    for( i = 0; i < MAX_LBRR_DELAY; i++ ) {
        /* Read payload size */
        counter = fread( &nBytes, sizeof( SKP_int16 ), 1, bitInFile );
#ifdef _SYSTEM_IS_BIG_ENDIAN
        swap_endian( &nBytes, 1 );
#endif
        /* Read payload */
        counter = fread( payloadEnd, sizeof( SKP_uint8 ), nBytes, bitInFile );

        if( ( SKP_int16 )counter < nBytes ) {
            break;
        }
        nBytesPerPacket[ i ] = nBytes;
        payloadEnd          += nBytes;
        totPackets++;
    }

    while( 1 ) {
        /* Read payload size */
        counter = fread( &nBytes, sizeof( SKP_int16 ), 1, bitInFile );
#ifdef _SYSTEM_IS_BIG_ENDIAN
        swap_endian( &nBytes, 1 );
#endif
        if( nBytes < 0 || counter < 1 ) {
            break;
        }

        /* Read payload */
        counter = fread( payloadEnd, sizeof( SKP_uint8 ), nBytes, bitInFile );
        if( ( SKP_int16 )counter < nBytes ) {
            break;
        }

        /* Simulate losses */
        rand_seed = SKP_RAND( rand_seed );
        if( ( ( ( float )( ( rand_seed >> 16 ) + ( 1 << 15 ) ) ) / 65535.0f >= ( loss_prob / 100.0f ) ) && ( counter > 0 ) ) {
            nBytesPerPacket[ MAX_LBRR_DELAY ] = nBytes;
            payloadEnd                       += nBytes;
        } else {
            nBytesPerPacket[ MAX_LBRR_DELAY ] = 0;
        }

        if( nBytesPerPacket[ 0 ] == 0 ) {
            /* Indicate lost packet */
            lost = 1;

            /* Packet loss. Search after FEC in next packets. Should be done in the jitter buffer */
            payloadPtr = payload;
            for( i = 0; i < MAX_LBRR_DELAY; i++ ) {
                if( nBytesPerPacket[ i + 1 ] > 0 ) {
                    starttime = GetHighResolutionTime();
                    SKP_Silk_SDK_search_for_LBRR( payloadPtr, nBytesPerPacket[ i + 1 ], ( i + 1 ), FECpayload, &nBytesFEC );
                    tottime += GetHighResolutionTime() - starttime;
                    if( nBytesFEC > 0 ) {
                        payloadToDec = FECpayload;
                        nBytes = nBytesFEC;
                        lost = 0;
                        break;
                    }
                }
                payloadPtr += nBytesPerPacket[ i + 1 ];
            }
        } else {
            lost = 0;
            nBytes = nBytesPerPacket[ 0 ];
            payloadToDec = payload;
        }

        /* Silk decoder */
        outPtr = out;
        tot_len = 0;
        starttime = GetHighResolutionTime();

        if( lost == 0 ) {
            /* No Loss: Decode all frames in the packet */
            frames = 0;
            do {
                /* Decode 20 ms */
                ret = SKP_Silk_SDK_Decode( psDec, &DecControl, 0, payloadToDec, nBytes, outPtr, &len );
                if( ret ) {
                    __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp",  "SKP_Silk_SDK_Decode returned %d", ret );
                }

                frames++;
                outPtr  += len;
                tot_len += len;
                if( frames > MAX_INPUT_FRAMES ) {
                    /* Hack for corrupt stream that could generate too many frames */
                    outPtr  = out;
                    tot_len = 0;
                    frames  = 0;
                }
                /* Until last 20 ms frame of packet has been decoded */
            } while( DecControl.moreInternalDecoderFrames );
        } else {
            /* Loss: Decode enough frames to cover one packet duration */
            for( i = 0; i < DecControl.framesPerPacket; i++ ) {
                /* Generate 20 ms */
                ret = SKP_Silk_SDK_Decode( psDec, &DecControl, 1, payloadToDec, nBytes, outPtr, &len );
                if( ret ) {
                    __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp",  "SKP_Silk_Decode returned %d", ret );
                }
                outPtr  += len;
                tot_len += len;
            }
        }

        tottime += GetHighResolutionTime() - starttime;
        totPackets++;

        /* Write output to file */
#ifdef _SYSTEM_IS_BIG_ENDIAN
        swap_endian( out, tot_len );
#endif
        fwrite( out, sizeof( SKP_int16 ), tot_len, speechOutFile );

        /* Update buffer */
        totBytes = 0;
        for( i = 0; i < MAX_LBRR_DELAY; i++ ) {
            totBytes += nBytesPerPacket[ i + 1 ];
        }
        /* Check if the received totBytes is valid */
        if (totBytes < 0 || totBytes > sizeof(payload))
        {
            __android_log_print(ANDROID_LOG_ERROR, "silk.cpp", "Packets decoded:             %d", totPackets );
            return -1;
        }
        SKP_memmove( payload, &payload[ nBytesPerPacket[ 0 ] ], totBytes * sizeof( SKP_uint8 ) );
        payloadEnd -= nBytesPerPacket[ 0 ];
        SKP_memmove( nBytesPerPacket, &nBytesPerPacket[ 1 ], MAX_LBRR_DELAY * sizeof( SKP_int16 ) );
    }

    /* Empty the recieve buffer */
    for( k = 0; k < MAX_LBRR_DELAY; k++ ) {
        if( nBytesPerPacket[ 0 ] == 0 ) {
            /* Indicate lost packet */
            lost = 1;

            /* Packet loss. Search after FEC in next packets. Should be done in the jitter buffer */
            payloadPtr = payload;
            for( i = 0; i < MAX_LBRR_DELAY; i++ ) {
                if( nBytesPerPacket[ i + 1 ] > 0 ) {
                    starttime = GetHighResolutionTime();
                    SKP_Silk_SDK_search_for_LBRR( payloadPtr, nBytesPerPacket[ i + 1 ], ( i + 1 ), FECpayload, &nBytesFEC );
                    tottime += GetHighResolutionTime() - starttime;
                    if( nBytesFEC > 0 ) {
                        payloadToDec = FECpayload;
                        nBytes = nBytesFEC;
                        lost = 0;
                        break;
                    }
                }
                payloadPtr += nBytesPerPacket[ i + 1 ];
            }
        } else {
            lost = 0;
            nBytes = nBytesPerPacket[ 0 ];
            payloadToDec = payload;
        }

        /* Silk decoder */
        outPtr  = out;
        tot_len = 0;
        starttime = GetHighResolutionTime();

        if( lost == 0 ) {
            /* No loss: Decode all frames in the packet */
            frames = 0;
            do {
                /* Decode 20 ms */
                ret = SKP_Silk_SDK_Decode( psDec, &DecControl, 0, payloadToDec, nBytes, outPtr, &len );
                if( ret ) {
                    __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp", "SKP_Silk_SDK_Decode returned %d", ret );
                }

                frames++;
                outPtr  += len;
                tot_len += len;
                if( frames > MAX_INPUT_FRAMES ) {
                    /* Hack for corrupt stream that could generate too many frames */
                    outPtr  = out;
                    tot_len = 0;
                    frames  = 0;
                }
                /* Until last 20 ms frame of packet has been decoded */
            } while( DecControl.moreInternalDecoderFrames );
        } else {
            /* Loss: Decode enough frames to cover one packet duration */

            /* Generate 20 ms */
            for( i = 0; i < DecControl.framesPerPacket; i++ ) {
                ret = SKP_Silk_SDK_Decode( psDec, &DecControl, 1, payloadToDec, nBytes, outPtr, &len );
                if( ret ) {
                    __android_log_print(ANDROID_LOG_DEBUG, "silk.cpp",  "SKP_Silk_Decode returned %d", ret );
                }
                outPtr  += len;
                tot_len += len;
            }
        }

        tottime += GetHighResolutionTime() - starttime;
        totPackets++;

        /* Write output to file */
#ifdef _SYSTEM_IS_BIG_ENDIAN
        swap_endian( out, tot_len );
#endif
        fwrite( out, sizeof( SKP_int16 ), tot_len, speechOutFile );

        /* Update Buffer */
        totBytes = 0;
        for( i = 0; i < MAX_LBRR_DELAY; i++ ) {
            totBytes += nBytesPerPacket[ i + 1 ];
        }

        /* Check if the received totBytes is valid */
        if (totBytes < 0 || totBytes > sizeof(payload))
        {

            fprintf( stderr, "\rPackets decoded:              %d", totPackets );
            return -1;
        }

        SKP_memmove( payload, &payload[ nBytesPerPacket[ 0 ] ], totBytes * sizeof( SKP_uint8 ) );
        payloadEnd -= nBytesPerPacket[ 0 ];
        SKP_memmove( nBytesPerPacket, &nBytesPerPacket[ 1 ], MAX_LBRR_DELAY * sizeof( SKP_int16 ) );

    }


    /* Free decoder */
    free( psDec );

    /* Close files */
    fclose( speechOutFile );
    fclose( bitInFile );

    return 0;
}