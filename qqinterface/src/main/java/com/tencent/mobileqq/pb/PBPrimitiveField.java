package com.tencent.mobileqq.pb;

public abstract class PBPrimitiveField<T> extends PBField<T> {
    public final boolean has() {
        return false;
    }

    public final void setHasFlag(boolean z) {
    }
}
