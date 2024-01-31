package com.tencent.qqnt.kernel.nativeinterface;



public final class ThumbConfig {
    Integer density;
    Integer longLimit;
    Integer maxSide;
    Integer minSide;

    public ThumbConfig() {
    }

    public Integer getDensity() {
        return this.density;
    }

    public Integer getLongLimit() {
        return this.longLimit;
    }

    public Integer getMaxSide() {
        return this.maxSide;
    }

    public Integer getMinSide() {
        return this.minSide;
    }

    public String toString() {
        return "ThumbConfig{maxSide=" + this.maxSide + ",minSide=" + this.minSide + ",longLimit=" + this.longLimit + ",density=" + this.density + ",}";
    }

    public ThumbConfig(Integer num, Integer num2, Integer num3, Integer num4) {
        this.maxSide = num;
        this.minSide = num2;
        this.longLimit = num3;
        this.density = num4;
    }
}
