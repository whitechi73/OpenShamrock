package com.tencent.mobileqq.data;

import java.util.HashMap;
import java.util.Map;

public class MessageForPic extends MessageRecord {
    public String SpeedInfo;
    public String actMsgContentValue;
    public String action;
    public String bigMsgUrl;
    public String bigThumbMsgUrl;
    public int busiType;
    public int fileSizeFlag;
    public long groupFileID;
    public long height;
    public int imageType;
    public boolean isInMixedMsg;
    public boolean isMixed;
    public boolean isRead;
    public boolean isShareAppActionMsg;
    public String localUUID;
    public int mCurrlength;
    public int mDownloadLength;
    public long mPresendTransferedSize;
    public int mShowLength;
    public String md5;
    //@RecordForTest
   // public msg_ctrl$MsgCtrl msgCtrl;
    public int msgVia;
    public int ntChatType;
    public String ntPeerUid;
    public String path;
   //public PicMessageExtraData picExtraData;
    public int picExtraFlag;
    public Object picExtraObject;
    public int previewed;
    public String rawMsgUrl;
   /// public ReportInfo reportInfo;
    //public MsgRecordParams rootMsgRecordParams;
    public String serverStoreSource;
    public long shareAppID;
    public long size;
    public long subTypeId;
    public int thumbHeight;
    public String thumbMsgUrl;
    public int thumbWidth;
    //public ThumbWidthHeightDP thumbWidthHeightDP;
    public int type;
    public String uuid;
    public long width;
    public boolean isDownStatusReady = false;
    public int subMsgId = 0;
    public int isReport = 0;
    public int subVersion = 5;
    public int preDownState = -1;
    public int preDownNetworkType = -1;
    public long DSKey = 0;
    public int mNotPredownloadReason = 0;
    public int subThumbWidth = -1;
    public int subThumbHeight = -1;
    public int aiofileType = -1;
    public int subMsgType = -1;
    public boolean bEnableEnc = false;
    public int thumbSize = -1;
    public boolean isBlessPic = false;
    public boolean sync2Story = false;
    public boolean isQzonePic = false;
    public boolean isStoryPhoto = false;
    public long replyRealSourceMsgId = -1;

    public String toLogString() {
        return "path:" + this.path + ",uuid:" + this.uuid + ",md5:" + this.md5 + ",size:" + this.size + ",groupFileID:" + this.groupFileID;
    }
}
