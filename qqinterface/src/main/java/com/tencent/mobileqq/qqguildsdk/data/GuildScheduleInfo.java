package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;



public class GuildScheduleInfo implements Serializable, Cloneable {
    public static final int STATUS_EXPIRED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_READY = 2;
    public static final int STATUS_STARTED = 3;
    private static final long serialVersionUID = 1;
    int acceptedNums;
    final ArrayList<GuildScheduleUser> acceptedUser;
    final GuildScheduleChannelInfo channelInfo;
    final String content;
    final long createTimeMs;
    final GuildScheduleUser creator;
    private long dateMs;
    final long endTimeMs;
    int inviteStatus;
    final boolean isNotified;
    final String mChannelName;
    final String mCoverUrl;
    final String mGuildName;
    final String mIconUrl;
    final int mTitleFontColor;
    final int rejectedNums;
    final int reminderTimeType;
    final long scheduleId;
    final long startTimeMs;
    final String title;



    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private long f227598a;

        /* renamed from: b  reason: collision with root package name */
        private long f227599b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f227600c = "";

        /* renamed from: d  reason: collision with root package name */
        private long f227601d = 0;

        /* renamed from: e  reason: collision with root package name */
        private long f227602e = 0;

        /* renamed from: f  reason: collision with root package name */
        private String f227603f = "";

        /* renamed from: g  reason: collision with root package name */
        private int f227604g = 0;

        /* renamed from: h  reason: collision with root package name */
        private GuildScheduleChannelInfo f227605h = new GuildScheduleChannelInfo();

        /* renamed from: i  reason: collision with root package name */
        private int f227606i = 0;

        /* renamed from: j  reason: collision with root package name */
        private long f227607j = 0;

        /* renamed from: k  reason: collision with root package name */
        private GuildScheduleUser f227608k = new GuildScheduleUser();

        /* renamed from: l  reason: collision with root package name */
        private int f227609l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f227610m = 0;

        /* renamed from: n  reason: collision with root package name */
        private ArrayList<GuildScheduleUser> f227611n = new ArrayList<>();
        private boolean o = false;
        private String p = "";
        private String q = "";
        private String r = "";
        private int s = 0;
        private String t = "";

        public b A(GuildScheduleUser guildScheduleUser) {
            this.f227608k = guildScheduleUser;
            return this;
        }

        public b B(long j2) {
            this.f227598a = j2;
            return this;
        }

        public b C(long j2) {
            this.f227602e = j2;
            return this;
        }

        public b D(int i2) {
            this.f227606i = i2;
            return this;
        }

        public b E(boolean z) {
            this.o = z;
            return this;
        }

        public b F(int i2) {
            this.f227610m = i2;
            return this;
        }

        public b G(int i2) {
            this.f227604g = i2;
            return this;
        }

        public b H(long j2) {
            this.f227599b = j2;
            return this;
        }

        public void I(String str) {
            this.t = str;
        }

        public void J(String str) {
            this.q = str;
        }

        public void K(String str) {
            this.p = str;
        }

        public void L(String str) {
            this.r = str;
        }

        public void M(int i2) {
            this.s = i2;
        }

        public b N(long j2) {
            this.f227601d = j2;
            return this;
        }

        public b O(String str) {
            this.f227600c = str;
            return this;
        }

        public b a(int i2) {
            this.f227609l = i2;
            return this;
        }

        public b b(ArrayList<GuildScheduleUser> arrayList) {
            this.f227611n = arrayList;
            return this;
        }

        public GuildScheduleInfo w() {
            return new GuildScheduleInfo(this);
        }

        public b x(GuildScheduleChannelInfo guildScheduleChannelInfo) {
            this.f227605h = guildScheduleChannelInfo;
            return this;
        }

        public b y(String str) {
            this.f227603f = str;
            return this;
        }

        public b z(long j2) {
            this.f227607j = j2;
            return this;
        }
    }

    @NonNull
    public Object clone() {
        return null;
    }

    public int getAcceptedNums() {
        return Math.max(this.acceptedNums, 0);
    }

    public ArrayList<GuildScheduleUser> getAcceptedUser() {
        return this.acceptedUser;
    }

    public GuildScheduleChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public GuildScheduleUser getCreator() {
        return this.creator;
    }

    public long getDateMs() {
        return this.dateMs;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public String getGuildName() {
        return this.mGuildName;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public int getRejectedNums() {
        return Math.max(this.rejectedNums, 0);
    }

    public int getReminderTimeType() {
        return this.reminderTimeType;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public int getStatus() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis >= this.endTimeMs) {
            return 4;
        }
        if (timeInMillis >= this.startTimeMs) {
            return 3;
        }
        return this.startTimeMs - timeInMillis < reminderTimeMs() ? 2 : 1;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleFontColor() {
        return this.mTitleFontColor;
    }

    public void increaseAcceptNums() {
        this.acceptedNums++;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void reduceAcceptedNums() {
        this.acceptedNums--;
    }

    public long reminderTimeMs() {
        int i2 = this.reminderTimeType;
        int i3 = 5;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    i3 = 15;
                } else if (i2 == 4) {
                    i3 = 30;
                } else if (i2 == 5) {
                    i3 = 60;
                }
            }
            return i3 * 60000;
        }
        i3 = 0;
        return i3 * 60000;
    }

    public void setDateMs(long j2) {
        this.dateMs = j2;
    }

    public String toString() {
        return "GuildScheduleInfo{dateMs=" + this.dateMs + ", scheduleId=" + this.scheduleId + ", title='" + this.title + "', startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + '}';
    }

    public void updateInviteStatus(int i2) {
        this.inviteStatus = i2;
    }

    public GuildScheduleInfo() {
        this.scheduleId = 0L;
        this.title = "";
        this.startTimeMs = 0L;
        this.endTimeMs = 0L;
        this.content = "";
        this.reminderTimeType = 0;
        this.channelInfo = new GuildScheduleChannelInfo();
        this.inviteStatus = 0;
        this.createTimeMs = 0L;
        this.creator = new GuildScheduleUser();
        this.acceptedNums = 0;
        this.rejectedNums = 0;
        this.acceptedUser = new ArrayList<>();
        this.isNotified = false;
        this.mGuildName = "";
        this.mCoverUrl = "";
        this.mIconUrl = "";
        this.mTitleFontColor = 0;
        this.mChannelName = "";
    }

    private GuildScheduleInfo(b bVar) {
        this.scheduleId = bVar.f227599b;
        this.title = bVar.f227600c;
        this.dateMs = bVar.f227598a;
        this.startTimeMs = bVar.f227601d;
        this.endTimeMs = bVar.f227602e;
        this.content = bVar.f227603f;
        this.reminderTimeType = bVar.f227604g;
        this.channelInfo = bVar.f227605h;
        this.inviteStatus = bVar.f227606i;
        this.createTimeMs = bVar.f227607j;
        this.creator = bVar.f227608k;
        this.acceptedNums = bVar.f227609l;
        this.rejectedNums = bVar.f227610m;
        this.acceptedUser = bVar.f227611n;
        this.isNotified = bVar.o;
        this.mGuildName = bVar.p;
        this.mCoverUrl = bVar.q;
        this.mIconUrl = bVar.r;
        this.mTitleFontColor = bVar.s;
        this.mChannelName = bVar.t;
    }
}
