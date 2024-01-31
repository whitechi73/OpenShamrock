package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public  class GuildSearchType implements Serializable {
    private int feedType;
    private int msgType;
    private int type;
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f227619a;

        /* renamed from: b  reason: collision with root package name */
        private int f227620b;

        /* renamed from: c  reason: collision with root package name */
        private int f227621c;

        public GuildSearchType d() {
            return new GuildSearchType(this);
        }

        public b e(int i2) {
            this.f227621c = i2;
            return this;
        }

        public b f(int i2) {
            this.f227619a = i2;
            return this;
        }

        private b() {
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GuildSearchType{type=" + this.type + ", msgType=" + this.msgType + ", feedType=" + this.feedType + '}';
    }

    public GuildSearchType() {
        this.type = 0;
        this.msgType = 0;
        this.feedType = 1;
    }

    private GuildSearchType(b bVar) {
        this.type = bVar.f227619a;
        this.msgType = bVar.f227620b;
        this.feedType = bVar.f227621c;
    }
}
