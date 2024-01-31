package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMsgTimeRange;

import java.io.Serializable;
import java.util.ArrayList;


public  class GuildSearchCond implements Serializable {
    private ArrayList<Long> channelIds;
    private ArrayList<Long> fromTinyIds;
    private ArrayList<IGProMsgTimeRange> timeRanges;
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Long> f227616a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Long> f227617b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<IGProMsgTimeRange> f227618c;

        public GuildSearchCond d() {
            return new GuildSearchCond(this);
        }

        public b e(ArrayList<Long> arrayList) {
            this.f227616a = arrayList;
            return this;
        }

        public b f(ArrayList<Long> arrayList) {
            this.f227617b = arrayList;
            return this;
        }

        public b g(ArrayList<IGProMsgTimeRange> arrayList) {
            this.f227618c = arrayList;
            return this;
        }

        private b() {
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public ArrayList<Long> getFromTinyIds() {
        return this.fromTinyIds;
    }

    public ArrayList<IGProMsgTimeRange> getTimeRanges() {
        return this.timeRanges;
    }

    public String toString() {
        return "GuildSearchCond{channelIds=" + this.channelIds + ", fromTinyIds=" + this.fromTinyIds + ", timeRanges=" + this.timeRanges + '}';
    }

    public GuildSearchCond() {
        this.channelIds = new ArrayList<>();
        this.fromTinyIds = new ArrayList<>();
        this.timeRanges = new ArrayList<>();
    }

    private GuildSearchCond(b bVar) {
        this.channelIds = bVar.f227616a;
        this.fromTinyIds = bVar.f227617b;
        this.timeRanges = bVar.f227618c;
    }
}
