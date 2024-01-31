package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2Label;

import java.io.Serializable;

/* loaded from: classes33.dex */
public class GGProRecommendV2Label implements Serializable {
    public final GProRecommendV2Label mInfo;

    public GGProRecommendV2Label(GProRecommendV2Label gProRecommendV2Label) {
        this.mInfo = gProRecommendV2Label;
    }

    public IGProRecommendV2Color getEdgingColor() {
        return new GGProRecommendV2Color(this.mInfo.getEdgingColor());
    }

    public int getLabelAttr() {
        return this.mInfo.getLabelAttr();
    }

    public int getLabelType() {
        return this.mInfo.getLabelType();
    }

    public String getName() {
        return this.mInfo.getName();
    }

    public IGProRecommendV2Color getTextColor() {
        return new GGProRecommendV2Color(this.mInfo.getTextColor());
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
