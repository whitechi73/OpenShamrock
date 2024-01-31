package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProJoinCondition {
    GProAccountCondition accountCondition;

    public GProJoinCondition() {
        this.accountCondition = new GProAccountCondition();
    }

    public GProAccountCondition getAccountCondition() {
        return this.accountCondition;
    }

    public String toString() {
        return "GProJoinCondition{accountCondition=" + this.accountCondition + ",}";
    }

    public GProJoinCondition(GProAccountCondition gProAccountCondition) {
        this.accountCondition = new GProAccountCondition();
        this.accountCondition = gProAccountCondition;
    }
}
