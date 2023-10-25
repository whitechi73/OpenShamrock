package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendGuildInfo {
    String cover;

    /* renamed from: face  reason: collision with root package name */
    String f305540face;
    String faceAnimationOnIdle;
    String faceAnimationOnUpdate;
    long fontColorId;
    String guildCode;
    long guildId;
    String introduction;
    int locationType;
    String name;
    ArrayList<GProNavigationInfo> navigationInfoList;
    GProPlayFaceAnimationPolicy playFaceAnimationPolicy;
    long seq;
    String subTitle;
    ArrayList<GProTextMedalInfo> textMedalInfoList;

    public GProRecommendGuildInfo() {
        this.name = "";
        this.f305540face = "";
        this.cover = "";
        this.subTitle = "";
        this.introduction = "";
        this.guildCode = "";
        this.faceAnimationOnUpdate = "";
        this.faceAnimationOnIdle = "";
        this.playFaceAnimationPolicy = new GProPlayFaceAnimationPolicy();
        this.navigationInfoList = new ArrayList<>();
        this.textMedalInfoList = new ArrayList<>();
    }

    public String getCover() {
        return this.cover;
    }

    public String getFace() {
        return this.f305540face;
    }

    public String getFaceAnimationOnIdle() {
        return this.faceAnimationOnIdle;
    }

    public String getFaceAnimationOnUpdate() {
        return this.faceAnimationOnUpdate;
    }

    public long getFontColorId() {
        return this.fontColorId;
    }

    public String getGuildCode() {
        return this.guildCode;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<GProNavigationInfo> getNavigationInfoList() {
        return this.navigationInfoList;
    }

    public GProPlayFaceAnimationPolicy getPlayFaceAnimationPolicy() {
        return this.playFaceAnimationPolicy;
    }

    public long getSeq() {
        return this.seq;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public ArrayList<GProTextMedalInfo> getTextMedalInfoList() {
        return this.textMedalInfoList;
    }

    public String toString() {
        return "GProRecommendGuildInfo{guildId=" + this.guildId + ",name=" + this.name + ",face=" + this.f305540face + ",cover=" + this.cover + ",fontColorId=" + this.fontColorId + ",subTitle=" + this.subTitle + ",introduction=" + this.introduction + ",guildCode=" + this.guildCode + ",seq=" + this.seq + ",faceAnimationOnUpdate=" + this.faceAnimationOnUpdate + ",faceAnimationOnIdle=" + this.faceAnimationOnIdle + ",playFaceAnimationPolicy=" + this.playFaceAnimationPolicy + ",navigationInfoList=" + this.navigationInfoList + ",locationType=" + this.locationType + ",textMedalInfoList=" + this.textMedalInfoList + ",}";
    }

    public GProRecommendGuildInfo(long j2, String str, String str2, String str3, long j3, String str4, String str5, String str6, long j4, String str7, String str8, GProPlayFaceAnimationPolicy gProPlayFaceAnimationPolicy, ArrayList<GProNavigationInfo> arrayList, int i2, ArrayList<GProTextMedalInfo> arrayList2) {
        this.name = "";
        this.f305540face = "";
        this.cover = "";
        this.subTitle = "";
        this.introduction = "";
        this.guildCode = "";
        this.faceAnimationOnUpdate = "";
        this.faceAnimationOnIdle = "";
        this.playFaceAnimationPolicy = new GProPlayFaceAnimationPolicy();
        this.navigationInfoList = new ArrayList<>();
        this.textMedalInfoList = new ArrayList<>();
        this.guildId = j2;
        this.name = str;
        this.f305540face = str2;
        this.cover = str3;
        this.fontColorId = j3;
        this.subTitle = str4;
        this.introduction = str5;
        this.guildCode = str6;
        this.seq = j4;
        this.faceAnimationOnUpdate = str7;
        this.faceAnimationOnIdle = str8;
        this.playFaceAnimationPolicy = gProPlayFaceAnimationPolicy;
        this.navigationInfoList = arrayList;
        this.locationType = i2;
        this.textMedalInfoList = arrayList2;
    }
}
