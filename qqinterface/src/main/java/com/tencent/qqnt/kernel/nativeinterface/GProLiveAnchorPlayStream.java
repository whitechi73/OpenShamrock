package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes2.dex */
public final class GProLiveAnchorPlayStream {
    Integer bitrate;
    Integer codecType;
    Integer definition;
    String definitionName;
    Integer type;
    String url;

    public GProLiveAnchorPlayStream() {
    }

    public Integer getBitrate() {
        return this.bitrate;
    }

    public Integer getCodecType() {
        return this.codecType;
    }

    public Integer getDefinition() {
        return this.definition;
    }

    public String getDefinitionName() {
        return this.definitionName;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProLiveAnchorPlayStream{type=" + this.type + ",url = " + this.url + ",bitrate=" + this.bitrate + ",definition=" + this.definition + ",codecType=" + this.codecType + ",definitionName=" + this.definitionName + ",}";
    }

    public GProLiveAnchorPlayStream(Integer num, String str, Integer num2, Integer num3, Integer num4, String str2) {
        this.type = num;
        this.url = str;
        this.bitrate = num2;
        this.definition = num3;
        this.codecType = num4;
        this.definitionName = str2;
    }
}
