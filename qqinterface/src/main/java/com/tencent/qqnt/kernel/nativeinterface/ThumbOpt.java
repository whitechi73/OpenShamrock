package com.tencent.qqnt.kernel.nativeinterface;



public final class ThumbOpt {
    Integer density;
    Float longLimit;
    Integer maxSide;
    Integer minSide;

    public ThumbOpt() {
    }

    public Integer getDensity() {
        return this.density;
    }

    public Float getLongLimit() {
        return this.longLimit;
    }

    public Integer getMaxSide() {
        return this.maxSide;
    }

    public Integer getMinSide() {
        return this.minSide;
    }

    public String toString() {
        return "ThumbOpt{maxSide=" + this.maxSide + ",minSide=" + this.minSide + ",longLimit=" + this.longLimit + ",density=" + this.density + ",}";
    }

    public ThumbOpt(Integer num, Integer num2, Float f2, Integer num3) {
        this.maxSide = num;
        this.minSide = num2;
        this.longLimit = f2;
        this.density = num3;
    }
}
