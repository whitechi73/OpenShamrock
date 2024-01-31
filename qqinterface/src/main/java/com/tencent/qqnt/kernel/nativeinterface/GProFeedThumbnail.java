package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProFeedThumbnail implements Serializable {
    boolean isVideoCover;
    long serialVersionUID;
    String url;

    public GProFeedThumbnail() {
        this.serialVersionUID = 1L;
        this.url = "";
    }

    public boolean getIsVideoCover() {
        return this.isVideoCover;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProFeedThumbnail{url=" + this.url + ",isVideoCover=" + this.isVideoCover + ",}";
    }

    public GProFeedThumbnail(String str, boolean z) {
        this.serialVersionUID = 1L;
        this.url = "";
        this.url = str;
        this.isVideoCover = z;
    }
}
