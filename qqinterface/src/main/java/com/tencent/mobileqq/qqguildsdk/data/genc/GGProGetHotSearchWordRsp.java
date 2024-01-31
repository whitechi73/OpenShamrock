package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetHotSearchWordRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProHotSearchWord;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetHotSearchWordRsp implements IGProGetHotSearchWordRsp {
    public final GProGetHotSearchWordRsp mInfo;

    public GGProGetHotSearchWordRsp(GProGetHotSearchWordRsp gProGetHotSearchWordRsp) {
        this.mInfo = gProGetHotSearchWordRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotSearchWordRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotSearchWordRsp
    public IGProForumBody getForums() {
        return new GGProForumBody(this.mInfo.getForums());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotSearchWordRsp
    public ArrayList<IGProHotSearchWord> getWords() {
        ArrayList<GProHotSearchWord> words = this.mInfo.getWords();
        ArrayList<IGProHotSearchWord> arrayList = new ArrayList<>();
        Iterator<GProHotSearchWord> it = words.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProHotSearchWord(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotSearchWordRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
