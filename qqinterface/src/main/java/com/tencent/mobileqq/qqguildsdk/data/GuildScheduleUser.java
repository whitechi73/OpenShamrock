package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;



public class GuildScheduleUser implements Serializable {
    private static final long serialVersionUID = 1;
    private final String avatar;
    private final String nick;
    private final int role;
    private final long tinyId;

    
    
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f227612a = "";

        /* renamed from: b  reason: collision with root package name */
        private long f227613b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f227614c = "";

        /* renamed from: d  reason: collision with root package name */
        private int f227615d = 0;

        public b e(String str) {
            this.f227614c = str;
            return this;
        }

        public GuildScheduleUser f() {
            return new GuildScheduleUser(this);
        }

        public b g(String str) {
            this.f227612a = str;
            return this;
        }

        public b h(int i2) {
            this.f227615d = i2;
            return this;
        }

        public b i(long j2) {
            this.f227613b = j2;
            return this;
        }
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public int getRole() {
        return this.role;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public GuildScheduleUser() {
        this.nick = "";
        this.tinyId = 0L;
        this.avatar = "";
        this.role = 0;
    }

    private GuildScheduleUser(b bVar) {
        this.nick = bVar.f227612a;
        this.tinyId = bVar.f227613b;
        this.avatar = bVar.f227614c;
        this.role = bVar.f227615d;
    }
}
