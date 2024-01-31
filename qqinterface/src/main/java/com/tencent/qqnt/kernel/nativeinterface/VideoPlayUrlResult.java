package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public final class VideoPlayUrlResult {
    ArrayList<VideoPlayUrlInfo> domainUrl;
    ArrayList<VideoPlayUrlInfo> v4IpUrl;
    ArrayList<VideoPlayUrlInfo> v6IpUrl;
    VideoCodecFormatType videoCodecFormat;

    public VideoPlayUrlResult() {
        this.v4IpUrl = new ArrayList<>();
        this.v6IpUrl = new ArrayList<>();
        this.domainUrl = new ArrayList<>();
        this.videoCodecFormat = VideoCodecFormatType.values()[0];
    }

    public ArrayList<VideoPlayUrlInfo> getDomainUrl() {
        return this.domainUrl;
    }

    public ArrayList<VideoPlayUrlInfo> getV4IpUrl() {
        return this.v4IpUrl;
    }

    public ArrayList<VideoPlayUrlInfo> getV6IpUrl() {
        return this.v6IpUrl;
    }

    public VideoCodecFormatType getVideoCodecFormat() {
        return this.videoCodecFormat;
    }

    public String toString() {
        return "VideoPlayUrlResult{v4IpUrl=" + this.v4IpUrl + ",v6IpUrl=" + this.v6IpUrl + ",domainUrl=" + this.domainUrl + ",videoCodecFormat=" + this.videoCodecFormat + ",}";
    }

    public VideoPlayUrlResult(ArrayList<VideoPlayUrlInfo> arrayList, ArrayList<VideoPlayUrlInfo> arrayList2, ArrayList<VideoPlayUrlInfo> arrayList3, VideoCodecFormatType videoCodecFormatType) {
        this.v4IpUrl = new ArrayList<>();
        this.v6IpUrl = new ArrayList<>();
        this.domainUrl = new ArrayList<>();
        this.videoCodecFormat = VideoCodecFormatType.values()[0];
        this.v4IpUrl = arrayList;
        this.v6IpUrl = arrayList2;
        this.domainUrl = arrayList3;
        this.videoCodecFormat = videoCodecFormatType;
    }
}
