package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.mp.mobileqq_mp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface RichProto {
    public static class RichProtoReq {
        public RichProtoProc.RichProtoCallback callback;
        public int commandId;
        public byte[] extention;
        public String protoKey;
        public ProtoReqManagerImpl.ProtoReq protoReq;
        public IProtoReqManager protoReqMgr;
        public List<ReqCommon> reqs = new ArrayList();
        RichProtoResp resp = new RichProtoResp();

        public static class C2CPicDownReq extends ReqCommon {
            public int fileType;
            public boolean isContact;
            public int msgTime;
            public int protocolType;
            public String storageSource;
            public String uuid;
        }

        public static class C2CPttDownReq extends ReqCommon {
            public int autoToText;
            public int busiType;
            public int downType;
            public boolean isSelfSend;
            public String storageSource;
            public String uuid;
            public int voiceType;

            public String toString() {
                return " uuid:" + this.uuid + " storageSource:" + this.storageSource + " isSelfSend:" + this.isSelfSend + " voiceType:" + this.voiceType + " busiType:" + this.busiType + " downType:" + this.downType;
            }
        }

        public static class GroupPicDownReq extends ReqCommon {
            public int fileType;
            public long groupFileID;
            public byte[] md5;
            public int msgTime;
            public int protocolType;

            public String toString() {
                return "GroupPicDownReq{groupFileID=" + this.groupFileID + ", md5=" + Arrays.toString(this.md5) + ", fileType=" + this.fileType + ", msgTime=" + this.msgTime + ", protocolType=" + this.protocolType + '}';
            }
        }

        public static class GroupPttDownReq extends ReqCommon {
            public int downType;
            public long groupFileID;
            public String groupFileKey;
            public byte[] md5;
            public int voiceType;

            public String toString() {
                return " groupFileID:" + this.groupFileID + " groupFileKey:" + this.groupFileKey + " md5:" + this.md5 + " voiceType:" + this.voiceType + " downType:" + this.downType;
            }
        }

        public static class GuildPicDownReq extends ReqCommon {
            public int fileType;
            public long groupFileID;
            public byte[] index;
            public byte[] md5;
            public int msgTime;
            public int protocolType;

            public String toString() {
                return "GuildPicDownReq{groupFileID=" + this.groupFileID + ", md5=" + Arrays.toString(this.md5) + ", index=" + Arrays.toString(this.index) + ", fileType=" + this.fileType + ", msgTime=" + this.msgTime + ", protocolType=" + this.protocolType + '}';
            }
        }

        public static class LongStructMessageDownReq extends ReqCommon {
            public String strFileid;

            public String toString() {
                return this.strFileid;
            }
        }

        public static class MultiMsgDownReq extends ReqCommon {
            public byte[] msgResId;
            public int multiMsgType;

            public String toString() {
                return " msgResId:" + this.msgResId;
            }
        }

        public static class MultiMsgUpReq extends ReqCommon {
            public byte[] md5;
            public int multiMsgType;
            public long size;

            public String toString() {
                return " size:" + this.size + " storeType:";
            }
        }

        public static class NearbyPeoplePicUpReq extends ReqCommon {
            public String uin;

            public String toString() {
                return this.uin;
            }
        }

        public static class PicUpReq extends ReqCommon {
            public int busiType;
            public String fileName;
            public long fileSize;
            public int height;
            public boolean isContact;
            public boolean isRaw;
            public boolean isSnapChat;
            public byte[] md5;
            public int picType;
            public String transferUrl;
            public int typeHotPic;
            public int width;

            public String toString() {
                return " name:" + this.fileName + " width:" + this.width + " height:" + this.height + " size:" + this.fileSize + " isRaw:" + this.isRaw + " isContant:" + this.isContact + " md5:" + "HexUtil.bytes2HexStr(this.md5)" + " picType:" + this.picType + " busiType:" + this.busiType + "typeHotPic:" + this.typeHotPic + "transferUrl:" + this.transferUrl;
            }
        }

        public static class PttUpReq extends ReqCommon {
            public int audioPanelType;
            public int autoToText;
            public String fileName;
            public int fileSize;
            public boolean forceViaOffline = false;
            public byte[] md5;
            public int voiceLength;
            public int voiceType;

            public String toString() {
                return " name:" + this.fileName + " size:" + this.fileSize + " voiceLength:" + this.voiceLength + " autoToText:" + this.autoToText + " type:" + this.voiceType + " audioPanel:" + this.audioPanelType;
            }
        }

        public static class ReqCommon {
            public String peerUin;
            public String secondUin;
            public String selfUin;
            public int uinType;
        }

        public static class ShortVideoDownReq extends ReqCommon {
            public int agentType;
            public int busiType;
            public int chatType;
            public int clientType;
            public int downType;
            public String fileId;
            public int fileType;
            public byte[] md5;
            public int sceneType;
            public int seq;
            public int sourceVideoCodecFormat;
            public int subBusiType;
            public int targetVideoCodecFormat;
            public String troopUin;

            public String toString() {
                return " chatType:" + this.chatType + " clientType:" + this.clientType + " seq:" + this.seq + " fileId:" + this.fileId + " troopUin:" + this.troopUin + " agentType:" + this.agentType + " md5:" + "HexUtil.bytes2HexStr(this.md5)" + " busiType:" + this.busiType + " fileType:" + this.fileType + " downType:" + this.downType + " sceneType:" + this.sceneType + " subBusiType:" + this.subBusiType + " targetVideoCodecFormat:" + this.targetVideoCodecFormat + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat;
            }
        }

        public static class ShortVideoForwardReq extends ReqCommon {
            public int agentType;
            public int bitrateInKilo;
            public int clientType;
            public String fileName;
            public int fileResLength;
            public int fileResWidth;
            public long fileSize;
            public int fileTime;
            public int format;
            public int fromBusiType;
            public int fromChatType;
            public String fromUin;
            public byte[] md5;
            public int seq;
            public int sourceVideoCodecFormat = -1;
            public byte[] thumbFileMd5;
            public long thumbFileSize;
            public int toBusiType;
            public int toChatType;
            public String troopUin;
            public String uuid;

            public String toString() {
                return " fromChatType:" + this.fromChatType + " toChatType:" + this.toChatType + " fromBusiType:" + this.fromBusiType + " toBusiType:" + this.toBusiType + " md5:" + "HexUtil.bytes2HexStr(this.md5)" + " format:" + this.format + " str_file_name:" + this.fileName + " uint64_file_size:" + this.fileSize + " fileTime:" + this.fileTime + " uuid:" + this.uuid + " fromUin:" + this.fromUin + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat + " bitrate:" + this.bitrateInKilo;
            }
        }

        public static class ShortVideoUpReq extends ReqCommon {
            public int agentType;
            public int bitrateInKilo;
            public int busiType;
            public int chatType;
            public int clientType;
            public String fileName;
            public int fileResLength;
            public int fileResWidth;
            public long fileSize;
            public int fileTime;
            public int format;
            public byte[] md5;
            public int seq;
            public int sourceVideoCodecFormat;
            public int subBusiType;
            public byte[] thumbFileMd5;
            public long thumbFileSize;
            public String troopUin;
            public int userCnt;

            public String toString() {
                return " chatType:" + this.chatType + " md5:" + this.md5 + " format:" + this.format + " str_file_name:" + this.fileName + " uint64_file_size:" + this.fileSize + " fileTime:" + this.fileTime + " busiType:" + this.busiType + " subBusiType:" + this.subBusiType + " userCnt:" + this.userCnt + " sourceVideoCodecFormat:" + this.sourceVideoCodecFormat + " bitrate:" + this.bitrateInKilo;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.reqs.size(); i2++) {
                sb.append("index:");
                sb.append(i2);
                sb.append(" ");
                sb.append(this.reqs.get(i2).toString());
            }
            return sb.toString();
        }
    }

    public static class RichProtoResp {
        public List<RespCommon> resps = new ArrayList();

        public static class BDHCommonUpResp extends RespCommon {
            public int blockSize;
            public long groupFileID;
            public boolean isExist;
            public String mUkey;
            public int transferedSize;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public boolean networkChange = false;
            public boolean isUseBdh = false;
            public long startOffset = 0;
            public String downDomain = "";
            public String thumbDownUrl = "";
            public String bigDownUrl = "";
            public String orgiDownUrl = "";
            public String resid = "";

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " fileID:" + this.groupFileID + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange + " downDomain:" + this.downDomain + " thumbDownUrl" + this.thumbDownUrl + " bigDownUrl:" + this.bigDownUrl + " orgiDownUrl:" + this.orgiDownUrl;
            }
        }

        public static class C2CPicUpResp extends RespCommon {
            public int blockSize;
            public String mOriginalDownPara;
            public String mResid;
            public String mUkey;
            public String mUuid;
            public boolean isExist = false;
            public boolean networkChange = false;
            public long startOffset = 0;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " mResid:" + this.mResid + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange + " startOffset:" + this.startOffset;
            }
        }

        public static class C2CPttDownResp extends RespCommon {
            public String domainV4V6;
            public String downloadUrl;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public ArrayList<ServerAddr> mIpv6List = new ArrayList<>();
        }

        public static class C2CPttUpResp extends RespCommon {
            public int blockSize;
            public ArrayList<ServerAddr> ipList = new ArrayList<>();
            public boolean isExist;
            public String mUkey;
            public String uuid;
        }

        public static class GroupPicUpResp extends RespCommon {
            public int blockSize;
            public long groupFileID;
            public boolean isExist;
            public String mUkey;
            public int transferedSize;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public boolean networkChange = false;
            public boolean isUseBdh = false;
            public long startOffset = 0;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " fileID:" + this.groupFileID + " isExist:" + this.isExist + " blockSize:" + this.blockSize + " netChg:" + this.networkChange;
            }
        }

        public static class GroupPttDownResp extends RespCommon {
            public String domainV4V6;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public ArrayList<ServerAddr> mIpv6List = new ArrayList<>();
            public boolean mIsHttps;
            public String urlPath;
        }

        public static class GroupPttUpResp extends RespCommon {
            public int blockSize;
            public long groupFileID;
            public byte[] groupFileKey;
            public ArrayList<ServerAddr> ipList = new ArrayList<>();
            public boolean isExist;
            public String mUkey;
            public int transferedSize;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " fileID:" + this.groupFileID;
            }
        }

        public static class GuildPicUpResp extends RespCommon {
            public int blockSize;
            public long groupFileID;
            public boolean isExist;
            public byte[] mDownLoadIndex;
            public String mUkey;
            public int transferedSize;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public boolean networkChange = false;
            public boolean isUseBdh = false;
            public long startOffset = 0;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("GuildPicUpResp{");
                sb.append(super.toString());
                sb.append("isExist");
                sb.append(this.isExist);
                sb.append(", mIpList=");
                sb.append(this.mIpList);
                sb.append(", groupFileID=");
                sb.append(this.groupFileID);
                sb.append(", mUkey='");
                sb.append(this.mUkey);
                sb.append(", blockSize=");
                sb.append(this.blockSize);
                sb.append(", transferedSize=");
                sb.append(this.transferedSize);
                sb.append(", networkChange=");
                sb.append(this.networkChange);
                sb.append(", isUseBdh=");
                sb.append(this.isUseBdh);
                sb.append(", startOffset=");
                sb.append(this.startOffset);
                sb.append(", mDownLoadIndex=");
                try {
                    if (this.mDownLoadIndex == null) {
                        sb.append("null");
                    } else {
                        sb.append(new String(this.mDownLoadIndex, "utf8"));
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                return sb.toString();
            }
        }

        public static class LongStructMessageDownResp extends RespCommon {
            public mobileqq_mp.RetInfo retInfo;
            public String strFileMd5;
            public String strUrl;
        }

        public static class MultiMsgDownResp extends RespCommon {
            public int mChannelType;
            public byte[] msgkey;
            public byte[] resId;
            public String urlParam;
            public ArrayList<ServerAddr> ipList = new ArrayList<>();
            public ArrayList<ServerAddr> mIpv6List = new ArrayList<>();

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " urlParam:" + this.urlParam + " msgUkey:" + this.msgkey + " ipList:" + this.ipList + " mIpv6List:" + this.mIpv6List + " resId:" + this.resId;
            }
        }

        /* loaded from: classes18.dex */
        public static class MultiMsgUpResp extends RespCommon {
            public int blockSize;
            public ArrayList<ServerAddr> ipList = new ArrayList<>();
            public byte[] msgKey;
            public byte[] msgSig;
            public byte[] resId;
            public int transferedSize;
            public byte[] ukey;
        }

        public static class NearbyPeoplePicUpResp extends RespCommon {
            public byte[] sessionKey;
        }

        public static class PicDownResp extends RespCommon {
            public String domain;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public ArrayList<ServerAddr> mIpv6List = new ArrayList<>();
            public int protocolType;
            public String urlPath;
        }

        public static class RespCommon {
            public int errCode;
            public String errStr;
            public int failCount;
            public RichProtoReq originReq;
            public String reason;
            public int successCount;
            public int result = -1;
            public boolean isSendByQuickHttp = false;
            public boolean isAllowRetry = true;

            public String toString() {
                return "result:" + this.result + " errCode:" + this.errCode + " errStr:" + this.errStr + " reason:" + this.reason + " succCnt:" + this.successCount + " failCnt" + this.failCount + " isSendByQuickHttp" + this.isSendByQuickHttp + " isAllowRetry" + this.isAllowRetry;
            }
        }

        public static class ShortVideoDownResp extends RespCommon {
            public String mDomain;
            public int mHostType;
            public ArrayList<ServerAddr> mIpList = new ArrayList<>();
            public ArrayList<ServerAddr> mIpv6List = new ArrayList<>();
            public boolean mIsHttps;
            public boolean mIsQuicEncryption;
            public boolean mIsSupportQuic;
            public int mQuicFec;
            public String mUkey;
            public String mUrl;
            public int mVideoCodecFormat;
            public byte[] md5;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " mUkey:" + this.mUkey + " mIpList:" + this.mIpList.toString() + " mIpv6List:" + this.mIpv6List.toString() + " md5:" + "HexUtil.bytes2HexStr(this.md5)" + " mIsSupportQuic:" + this.mIsSupportQuic + " mIsQuicEncryption:" + this.mIsQuicEncryption + " mQuicFec:" + this.mQuicFec + " mVideoCodecFormat:" + this.mVideoCodecFormat;
            }
        }

        public static class ShortVideoForwardResp extends RespCommon {
            public String fileId;
            public boolean isExist;
            public long startOffset = 0;
            public int videoAttr = 0;
            public int videoKandianType = 0;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " isExist:" + this.isExist + " fileId:" + this.fileId + " startOffset:" + this.startOffset + " videoAttr:" + this.videoAttr + " videoKandianType:" + this.videoKandianType;
            }
        }

        public static class ShortVideoUpResp extends RespCommon {
            public String fileId;
            public boolean isExist;
            public long startOffset = 0;
            public int videoAttr = 0;
            public int videoKandianType = 0;

            @Override // com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
            public String toString() {
                return super.toString() + " isExist:" + this.isExist + " fileId:" + this.fileId + " startOffset:" + this.startOffset + " videoAttr:" + this.videoAttr + " videoKandianType:" + this.videoKandianType;
            }
        }
    }
}
