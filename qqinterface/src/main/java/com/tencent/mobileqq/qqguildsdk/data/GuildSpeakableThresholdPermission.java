package com.tencent.mobileqq.qqguildsdk.data;


public class GuildSpeakableThresholdPermission implements IGuildSpeakableThresholdPermission {
    private long directMsgLimitTime;
    private int directMsgLimitType;
    private long guildLimitTime;
    private int guildLimitType;
    private long joinTime;
    private String verifyUrl;

    
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f227629a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f227630b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f227631c = 0;

        /* renamed from: d  reason: collision with root package name */
        private long f227632d = 0;

        /* renamed from: e  reason: collision with root package name */
        private long f227633e = 0;

        /* renamed from: f  reason: collision with root package name */
        private String f227634f = "";

        public GuildSpeakableThresholdPermission g() {
            return new GuildSpeakableThresholdPermission(this);
        }

        public b h(long j2) {
            this.f227633e = j2;
            return this;
        }

        public b i(int i2) {
            this.f227630b = i2;
            return this;
        }

        public b j(long j2) {
            this.f227632d = j2;
            return this;
        }

        public b k(int i2) {
            this.f227629a = i2;
            return this;
        }

        public b l(long j2) {
            this.f227631c = j2;
            return this;
        }

        public b m(String str) {
            this.f227634f = str;
            return this;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getDirectMsgLimitTime() {
        return this.directMsgLimitTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public int getDirectMsgLimitType() {
        return this.directMsgLimitType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getGuildLimitTime() {
        return this.guildLimitTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public int getGuildLimitType() {
        return this.guildLimitType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public long getJoinTime() {
        return this.joinTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission
    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GuildSpeakableThresholdPermission{guildLimitType=" + this.guildLimitType + ", directMsgLimitType=" + this.directMsgLimitType + ", joinTime=" + this.joinTime + ", guildLimitTime=" + this.guildLimitTime + ", directMsgLimitTime=" + this.directMsgLimitTime + ", verifyUrl=" + this.verifyUrl + "'}";
    }

    private GuildSpeakableThresholdPermission(b bVar) {
        this.guildLimitType = bVar.f227629a;
        this.directMsgLimitType = bVar.f227630b;
        this.joinTime = bVar.f227631c;
        this.guildLimitTime = bVar.f227632d;
        this.directMsgLimitTime = bVar.f227633e;
        this.verifyUrl = bVar.f227634f;
    }
}
