package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProHotSearchWord;

public  class GGProHotSearchWord implements IGProHotSearchWord {
    public final GProHotSearchWord mInfo;

    public GGProHotSearchWord(GProHotSearchWord gProHotSearchWord) {
        this.mInfo = gProHotSearchWord;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotSearchWord
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotSearchWord
    public String getLink() {
        return this.mInfo.getLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotSearchWord
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotSearchWord
    public String getWord() {
        return this.mInfo.getWord();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotSearchWord
    public String toString() {
        return this.mInfo.toString();
    }
}
