package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;



public class GuildScheduleChannelInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private final long channelId;
    private final String channelName;
    private final long guildId;
    private final boolean hasJoin;
    private final boolean isPrivate;
    private final int type;



    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private long f227592a;

        /* renamed from: b  reason: collision with root package name */
        private int f227593b;

        /* renamed from: c  reason: collision with root package name */
        private long f227594c;

        /* renamed from: d  reason: collision with root package name */
        private String f227595d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f227596e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f227597f;

        public GuildScheduleChannelInfo g() {
            return new GuildScheduleChannelInfo(this);
        }

        public b h(long j2) {
            this.f227592a = j2;
            return this;
        }

        public b i(String str) {
            this.f227595d = str;
            return this;
        }

        public b j(long j2) {
            this.f227594c = j2;
            return this;
        }

        public b k(boolean z) {
            this.f227597f = z;
            return this;
        }

        public b l(boolean z) {
            this.f227596e = z;
            return this;
        }

        public b m(int i2) {
            this.f227593b = i2;
            return this;
        }
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getType() {
        return this.type;
    }

    public boolean isHasJoin() {
        return this.hasJoin;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isValidChannelInfo() {
        return (this.channelId == 0 && this.guildId == 0) ? false : true;
    }

    public GuildScheduleChannelInfo() {
        this.channelId = 0L;
        this.type = 0;
        this.guildId = 0L;
        this.channelName = "";
        this.isPrivate = false;
        this.hasJoin = false;
    }

    private GuildScheduleChannelInfo(b bVar) {
        this.channelId = bVar.f227592a;
        this.type = bVar.f227593b;
        this.guildId = bVar.f227594c;
        this.channelName = bVar.f227595d;
        this.isPrivate = bVar.f227596e;
        this.hasJoin = bVar.f227597f;
    }
}
