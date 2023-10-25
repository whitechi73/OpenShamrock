package com.tencent.qqnt.kernel.nativeinterface;

public final class BulletinFeedsContent {
    int contentType;
    String contentValue;
    int faceIdx;
    int fileAttr;
    String fileContentSha;
    String fileMd5;
    String fileName;
    String fileOri;
    long fileSize;
    String fileTripleSha;
    String fileUrl;
    int musicId;
    String musicName;
    String musicUrlForAccept;
    String musicUrlForRefuse;
    String musicUserRank;
    String objectMessageBrief;
    String picId;
    String picMd5;
    String picPath;
    String picSize;
    String picUrl;
    int shareExpire;
    String videoId;
    String videoIntroduction;
    String videoOriginalUrl;
    String videoSource;
    String videoSwfUrl;

    public BulletinFeedsContent() {
        this.contentValue = "";
        this.picSize = "";
        this.picPath = "";
        this.picId = "";
        this.picUrl = "";
        this.picMd5 = "";
        this.musicUserRank = "";
        this.musicName = "";
        this.musicUrlForAccept = "";
        this.musicUrlForRefuse = "";
        this.fileName = "";
        this.fileUrl = "";
        this.fileOri = "";
        this.fileContentSha = "";
        this.fileTripleSha = "";
        this.fileMd5 = "";
        this.videoSwfUrl = "";
        this.videoOriginalUrl = "";
        this.videoId = "";
        this.videoIntroduction = "";
        this.videoSource = "";
        this.objectMessageBrief = "";
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getContentValue() {
        return this.contentValue;
    }

    public int getFaceIdx() {
        return this.faceIdx;
    }

    public int getFileAttr() {
        return this.fileAttr;
    }

    public String getFileContentSha() {
        return this.fileContentSha;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileOri() {
        return this.fileOri;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileTripleSha() {
        return this.fileTripleSha;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public int getMusicId() {
        return this.musicId;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicUrlForAccept() {
        return this.musicUrlForAccept;
    }

    public String getMusicUrlForRefuse() {
        return this.musicUrlForRefuse;
    }

    public String getMusicUserRank() {
        return this.musicUserRank;
    }

    public String getObjectMessageBrief() {
        return this.objectMessageBrief;
    }

    public String getPicId() {
        return this.picId;
    }

    public String getPicMd5() {
        return this.picMd5;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public String getPicSize() {
        return this.picSize;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getShareExpire() {
        return this.shareExpire;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoIntroduction() {
        return this.videoIntroduction;
    }

    public String getVideoOriginalUrl() {
        return this.videoOriginalUrl;
    }

    public String getVideoSource() {
        return this.videoSource;
    }

    public String getVideoSwfUrl() {
        return this.videoSwfUrl;
    }

    public String toString() {
        return "BulletinFeedsContent{contentType=" + this.contentType + ",contentValue=" + this.contentValue + ",picSize=" + this.picSize + ",picPath=" + this.picPath + ",picId=" + this.picId + ",picUrl=" + this.picUrl + ",picMd5=" + this.picMd5 + ",musicUserRank=" + this.musicUserRank + ",musicId=" + this.musicId + ",musicName=" + this.musicName + ",musicUrlForAccept=" + this.musicUrlForAccept + ",musicUrlForRefuse=" + this.musicUrlForRefuse + ",fileName=" + this.fileName + ",fileUrl=" + this.fileUrl + ",fileOri=" + this.fileOri + ",fileSize=" + this.fileSize + ",fileContentSha=" + this.fileContentSha + ",fileTripleSha=" + this.fileTripleSha + ",fileMd5=" + this.fileMd5 + ",fileAttr=" + this.fileAttr + ",shareExpire=" + this.shareExpire + ",videoSwfUrl=" + this.videoSwfUrl + ",videoOriginalUrl=" + this.videoOriginalUrl + ",videoId=" + this.videoId + ",videoIntroduction=" + this.videoIntroduction + ",videoSource=" + this.videoSource + ",faceIdx=" + this.faceIdx + ",objectMessageBrief=" + this.objectMessageBrief + ",}";
    }

    public BulletinFeedsContent(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, String str8, String str9, String str10, String str11, String str12, String str13, long j2, String str14, String str15, String str16, int i4, int i5, String str17, String str18, String str19, String str20, String str21, int i6, String str22) {
        this.contentValue = "";
        this.picSize = "";
        this.picPath = "";
        this.picId = "";
        this.picUrl = "";
        this.picMd5 = "";
        this.musicUserRank = "";
        this.musicName = "";
        this.musicUrlForAccept = "";
        this.musicUrlForRefuse = "";
        this.fileName = "";
        this.fileUrl = "";
        this.fileOri = "";
        this.fileContentSha = "";
        this.fileTripleSha = "";
        this.fileMd5 = "";
        this.videoSwfUrl = "";
        this.videoOriginalUrl = "";
        this.videoId = "";
        this.videoIntroduction = "";
        this.videoSource = "";
        this.objectMessageBrief = "";
        this.contentType = i2;
        this.contentValue = str;
        this.picSize = str2;
        this.picPath = str3;
        this.picId = str4;
        this.picUrl = str5;
        this.picMd5 = str6;
        this.musicUserRank = str7;
        this.musicId = i3;
        this.musicName = str8;
        this.musicUrlForAccept = str9;
        this.musicUrlForRefuse = str10;
        this.fileName = str11;
        this.fileUrl = str12;
        this.fileOri = str13;
        this.fileSize = j2;
        this.fileContentSha = str14;
        this.fileTripleSha = str15;
        this.fileMd5 = str16;
        this.fileAttr = i4;
        this.shareExpire = i5;
        this.videoSwfUrl = str17;
        this.videoOriginalUrl = str18;
        this.videoId = str19;
        this.videoIntroduction = str20;
        this.videoSource = str21;
        this.faceIdx = i6;
        this.objectMessageBrief = str22;
    }
}