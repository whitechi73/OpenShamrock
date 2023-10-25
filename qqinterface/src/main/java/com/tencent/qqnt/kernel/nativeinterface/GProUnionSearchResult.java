package com.tencent.qqnt.kernel.nativeinterface;



import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProUnionSearchResult {
    byte[] feedInfoCookie;
    ArrayList<GProFeedSearchInfo> feedInfoList;
    long feedInfoTotalCount;
    byte[] guildInfoCookie;
    ArrayList<GProGuildSearchInfo> guildInfoList;
    long guildInfoTotalCount;
    byte[] guildRcdInfoCookie;
    ArrayList<GProGuildSearchInfo> guildRcdInfoList;
    byte[] liveInfoCookie;
    ArrayList<GProLiveSearchInfo> liveInfoList;
    long liveInfoTotalCount;
    byte[] scheduleInfoCookie;
    ArrayList<GProScheduleSearchInfo> scheduleInfoList;
    long scheduleInfoTotalCount;
    GProSuggestedSearch suggestedContent;
    int version;

    public GProUnionSearchResult() {
        this.guildInfoList = new ArrayList<>();
        this.guildInfoCookie = new byte[0];
        this.feedInfoList = new ArrayList<>();
        this.feedInfoCookie = new byte[0];
        this.liveInfoList = new ArrayList<>();
        this.liveInfoCookie = new byte[0];
        this.scheduleInfoList = new ArrayList<>();
        this.scheduleInfoCookie = new byte[0];
        this.guildRcdInfoList = new ArrayList<>();
        this.guildRcdInfoCookie = new byte[0];
        this.suggestedContent = new GProSuggestedSearch();
    }

    public byte[] getFeedInfoCookie() {
        return this.feedInfoCookie;
    }

    public ArrayList<GProFeedSearchInfo> getFeedInfoList() {
        return this.feedInfoList;
    }

    public long getFeedInfoTotalCount() {
        return this.feedInfoTotalCount;
    }

    public byte[] getGuildInfoCookie() {
        return this.guildInfoCookie;
    }

    public ArrayList<GProGuildSearchInfo> getGuildInfoList() {
        return this.guildInfoList;
    }

    public long getGuildInfoTotalCount() {
        return this.guildInfoTotalCount;
    }

    public byte[] getGuildRcdInfoCookie() {
        return this.guildRcdInfoCookie;
    }

    public ArrayList<GProGuildSearchInfo> getGuildRcdInfoList() {
        return this.guildRcdInfoList;
    }

    public byte[] getLiveInfoCookie() {
        return this.liveInfoCookie;
    }

    public ArrayList<GProLiveSearchInfo> getLiveInfoList() {
        return this.liveInfoList;
    }

    public long getLiveInfoTotalCount() {
        return this.liveInfoTotalCount;
    }

    public byte[] getScheduleInfoCookie() {
        return this.scheduleInfoCookie;
    }

    public ArrayList<GProScheduleSearchInfo> getScheduleInfoList() {
        return this.scheduleInfoList;
    }

    public long getScheduleInfoTotalCount() {
        return this.scheduleInfoTotalCount;
    }

    public GProSuggestedSearch getSuggestedContent() {
        return this.suggestedContent;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "GProUnionSearchResult{guildInfoTotalCount=" + this.guildInfoTotalCount + ",guildInfoList=" + this.guildInfoList + ",guildInfoCookie=" + this.guildInfoCookie + ",feedInfoTotalCount=" + this.feedInfoTotalCount + ",feedInfoList=" + this.feedInfoList + ",feedInfoCookie=" + this.feedInfoCookie + ",liveInfoTotalCount=" + this.liveInfoTotalCount + ",liveInfoList=" + this.liveInfoList + ",liveInfoCookie=" + this.liveInfoCookie + ",scheduleInfoTotalCount=" + this.scheduleInfoTotalCount + ",scheduleInfoList=" + this.scheduleInfoList + ",scheduleInfoCookie=" + this.scheduleInfoCookie + ",guildRcdInfoList=" + this.guildRcdInfoList + ",guildRcdInfoCookie=" + this.guildRcdInfoCookie + ",suggestedContent=" + this.suggestedContent + ",version = " + this.version + ",}";
    }

    public GProUnionSearchResult(long j2, ArrayList<GProGuildSearchInfo> arrayList, byte[] bArr, long j3, ArrayList<GProFeedSearchInfo> arrayList2, byte[] bArr2, long j4, ArrayList<GProLiveSearchInfo> arrayList3, byte[] bArr3, long j5, ArrayList<GProScheduleSearchInfo> arrayList4, byte[] bArr4, ArrayList<GProGuildSearchInfo> arrayList5, byte[] bArr5, GProSuggestedSearch gProSuggestedSearch, int i2) {
        this.guildInfoList = new ArrayList<>();
        this.guildInfoCookie = new byte[0];
        this.feedInfoList = new ArrayList<>();
        this.feedInfoCookie = new byte[0];
        this.liveInfoList = new ArrayList<>();
        this.liveInfoCookie = new byte[0];
        this.scheduleInfoList = new ArrayList<>();
        this.scheduleInfoCookie = new byte[0];
        this.guildRcdInfoList = new ArrayList<>();
        this.guildRcdInfoCookie = new byte[0];
        this.suggestedContent = new GProSuggestedSearch();
        this.guildInfoTotalCount = j2;
        this.guildInfoList = arrayList;
        this.guildInfoCookie = bArr;
        this.feedInfoTotalCount = j3;
        this.feedInfoList = arrayList2;
        this.feedInfoCookie = bArr2;
        this.liveInfoTotalCount = j4;
        this.liveInfoList = arrayList3;
        this.liveInfoCookie = bArr3;
        this.scheduleInfoTotalCount = j5;
        this.scheduleInfoList = arrayList4;
        this.scheduleInfoCookie = bArr4;
        this.guildRcdInfoList = arrayList5;
        this.guildRcdInfoCookie = bArr5;
        this.suggestedContent = gProSuggestedSearch;
        this.version = i2;
    }
}
