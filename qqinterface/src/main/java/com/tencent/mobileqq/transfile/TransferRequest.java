package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageRecord;

import java.io.OutputStream;

public class TransferRequest {
    public int chatType;
    public int delayShowProgressTimeInMs;
    public Object extraObject;
    public boolean isShareImageByServer;
    public int mBusiType;
    public boolean mCanSendMsg;
    public int mCommandId;
    public String mDisplayOutFilePath;
    //public c mDownCallBack;
    public int mDownMode;
    public byte[] mExtentionInfo;
    public Object mExtraObj;
    public long mFastForwardFileSize;
    public int mFastForwardHeight;
    public int mFastForwardWidth;
    public int mFileType;
    public long mGroupFileID;
    public String mGroupFileKeyStr;
    public boolean mIsPresend;
    public boolean mIsPttPreSend;
    public boolean mIsSecSnapChatPic;
    public boolean mIsUp;
    public String mLocalPath;
    public String mMd5;
    public long mMsgTime;
    public OutputStream mOut;
    public String mOutFilePath;
    public String mPeerUin;
    public int mPicSendSource;
    public int mPttUploadPanel;
    public boolean mReqVideoSubtitle;
    public int mRequestDisplayLength;
    public int mRequestLength;
    public int mRequestOffset;
    public TransferResult mResult;
    public long mSecMsgId;
    public String mSecondId;
    public String mSelfUin;
    public String mServerPath;
    public int mSourceVideoCodecFormat;
    public long mSubMsgId;
    public int mTargetVideoCodecFormat;
    public String mThumbMd5;
    public String mThumbPath;
    public int mUinType;
    public long mUniseq;
    public int multiMsgType;
    public int pcmForVadNum;
    public String pcmForVadPath;
    public int pcmForVadPos;
    public PhotoSendParams photoSendParams;
    public String resIdStr;
    public byte[] toSendData;
    public int upMsgBusiType;
    //public WXVadSeg vadSeg;
    public String mRichTag = "";
    public boolean isJubaoMsgType = false;
    public boolean mIsSelfSend = false;
    public boolean useOutputstream = true;
    public boolean mSupportRangeBreakDown = false;
    public int mDbRecVersion = 5;
    public boolean needSendMsg = true;
    public int mPrioty = 1;
    public MessageRecord mRec = null;
    public boolean mNeedReport = true;
    public boolean mIsOnlyGetUrl = false;
    public boolean mIsFastForward = false;
    public boolean myPresendInvalid = false;
    public boolean mPttCompressFinish = false;
    public boolean bEnableEnc = false;
    public boolean isQzonePic = false;
    private String mKey = null;
    public static class AppInfo {
        public String packName;
        public String sourceIconBig;
        public String sourceIconSmall;
        public String sourceName;
        public String sourceUrl;
        public int status;
    }

    public static class AppShare {
        public long mAppShareID;
        public String mShareUrl;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mAppShareID:" + this.mAppShareID);
            sb.append(",mShareUrl:" + this.mShareUrl);
            return sb.toString();
        }
    }

    public static class PicDownExtraInfo {
        public URLDrawableHandler mHandler;
        public int mStartDownOffset;
        public String mUrlFromMsg;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mUrlFromMsg:" + this.mUrlFromMsg);
            sb.append(",mStartDownOffset:" + this.mStartDownOffset);
            return sb.toString();
        }
    }

    public static class PicUpExtraInfo {
        public boolean mIsRaw;
        public boolean mIsShareAppPic;
        public AppShare mShareAppInfo;
        public int mUinType;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mUinType:" + this.mUinType);
            sb.append(",mIsRaw:" + this.mIsRaw);
            sb.append(",mIsShareAppPic:" + this.mIsShareAppPic);
            sb.append(",mShareAppInfo:{" + this.mShareAppInfo + "}");
            return sb.toString();
        }
    }

    public static class PttDownExtraInfo {
        public int mFromType;
        public int mLayer;

        public PttDownExtraInfo(int i2, int i3) {
            this.mFromType = i2;
            this.mLayer = i3;
        }
    }

    public static class ShareExtraInfo {
        public long appId;
        public AppInfo appInfo;
        public String audioUrl;
        public boolean enableServerSendMsg;
        public int forwardType;
        public String imageUrl;
        public int imageUrlStatus;
        public String pkgName;
        public int serviceType;
        public int shortUrlStatus;
        public String summary;
        public String targetUrl;
        public String title;
    }

    public String getKey() {
        String str = this.mKey;
        if (str == null) {
            return this.mPeerUin + "_" + this.mFileType + "_" + this.mUniseq + "_" + this.mSubMsgId;
        }
        return str;
    }

    public String getKeyForTransfer() {
        return this.mPeerUin + this.mUniseq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TransferRequest\n");
        sb.append("mUniseq=" + this.mUniseq);
        sb.append(",mMd5=" + this.mMd5);
        sb.append(",mIsIp=" + this.mIsUp);
        sb.append(",mUinType=" + this.mUinType);
        sb.append(",mFileType=" + this.mFileType);
        sb.append(",mSelfUin=" + this.mSelfUin);
        sb.append(",mPeerUin=" + this.mPeerUin);
        sb.append(",mSecondId=" + this.mSecondId);
        sb.append(",mServerPath=" + this.mServerPath);
        sb.append(",mLocalPath=" + this.mLocalPath);
        sb.append(",mBusiType=" + this.mBusiType);
        sb.append(",mGroupFileID=" + this.mGroupFileID);
        sb.append(",mExtraObj={" + this.mExtraObj + "}");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(",mPrioty=");
        sb2.append(this.mPrioty);
        sb.append(sb2.toString());
        //sb.append(",mLogicCallBack=" + this.mUpCallBack);
        sb.append(",bEnableEnc=" + this.bEnableEnc);
        sb.append(",isQzonePic=" + this.isQzonePic);
        sb.append(",pcmForVadPath=" + this.pcmForVadPath);
        return sb.toString();
    }
}
