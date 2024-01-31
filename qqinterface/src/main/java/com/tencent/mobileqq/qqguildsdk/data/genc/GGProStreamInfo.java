package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProStreamInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProStreamURL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public  class GGProStreamInfo implements Serializable {
    public final GProStreamInfo mInfo;

    public GGProStreamInfo(GProStreamInfo gProStreamInfo) {
        this.mInfo = gProStreamInfo;
    }

    public int getStreamType() {
        return this.mInfo.getStreamType();
    }

    public ArrayList<Object> getStreamUrlList() {
        ArrayList<GProStreamURL> streamUrlList = this.mInfo.getStreamUrlList();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProStreamURL> it = streamUrlList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProStreamURL(it.next()));
        }
        return arrayList;
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
