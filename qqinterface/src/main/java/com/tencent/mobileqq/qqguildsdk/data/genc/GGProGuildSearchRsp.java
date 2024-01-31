package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildSearchRsp;

import java.util.ArrayList;

public  class GGProGuildSearchRsp implements IGProGuildSearchRsp {
    public final GProGuildSearchRsp mInfo;

    public GGProGuildSearchRsp(GProGuildSearchRsp gProGuildSearchRsp) {
        this.mInfo = gProGuildSearchRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchRsp
    public ArrayList<String> getHighlightWords() {
        return this.mInfo.getHighlightWords();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchRsp
    public IGProUnionResult getUnionResult() {
        return new GGProUnionResult(this.mInfo.getUnionResult());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
