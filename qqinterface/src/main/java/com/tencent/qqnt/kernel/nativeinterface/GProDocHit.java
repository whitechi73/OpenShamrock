package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDocHit {
    GProRelation relation;
    long value;

    public GProDocHit() {
        this.relation = GProRelation.values()[0];
    }

    public GProRelation getRelation() {
        return this.relation;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "GProDocHit{value=" + this.value + ",relation=" + this.relation + ",}";
    }

    public GProDocHit(long j2, GProRelation gProRelation) {
        this.relation = GProRelation.values()[0];
        this.value = j2;
        this.relation = gProRelation;
    }
}
