package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendItem implements Serializable {
    GProStickyFeedChannel activeFeedChannel;
    GProStickyTextChannel activeTextChannel;
    byte[] adFeedModel;
    GProAdInfo adInfo;
    ArrayList<GProRecommendCategory> categories;
    GProRecommendChannelInfo channelInfo;
    GProRecommendExtra extra;
    GProRecommendMyFeed feed;
    GProRecommendItemForumChannel forumChannel;
    GProRecommendH5GameChannel h5gameChannel;
    String itemId;
    long itemIdUint64;
    int itemType;
    GProQuickJoinBlock quickJoinBlock;
    GProRecommendLiveChannel recommendLiveChannel;
    GProRecommendRobotDrawCard robotDrawCard;
    GProRecommendRobotGameCard robotGameCard;
    long serialVersionUID;
    int templateType;
    GProRecommendTextChannel textChannel;
    GProRecommendVoiceChannel voiceChannel;
    GProVoiceTemplateChannel voiceTemplate;
    GProRecommendWorldChannel worldChannel;

    public GProRecommendItem() {
        this.serialVersionUID = 1L;
        this.itemId = "";
        this.channelInfo = new GProRecommendChannelInfo();
        this.recommendLiveChannel = new GProRecommendLiveChannel();
        this.voiceChannel = new GProRecommendVoiceChannel();
        this.feed = new GProRecommendMyFeed();
        this.worldChannel = new GProRecommendWorldChannel();
        this.categories = new ArrayList<>();
        this.h5gameChannel = new GProRecommendH5GameChannel();
        this.adInfo = new GProAdInfo();
        this.forumChannel = new GProRecommendItemForumChannel();
        this.extra = new GProRecommendExtra();
        this.voiceTemplate = new GProVoiceTemplateChannel();
        this.quickJoinBlock = new GProQuickJoinBlock();
        this.textChannel = new GProRecommendTextChannel();
        this.robotDrawCard = new GProRecommendRobotDrawCard();
        this.robotGameCard = new GProRecommendRobotGameCard();
        this.adFeedModel = new byte[0];
        this.activeTextChannel = new GProStickyTextChannel();
        this.activeFeedChannel = new GProStickyFeedChannel();
    }

    public GProStickyFeedChannel getActiveFeedChannel() {
        return this.activeFeedChannel;
    }

    public GProStickyTextChannel getActiveTextChannel() {
        return this.activeTextChannel;
    }

    public byte[] getAdFeedModel() {
        return this.adFeedModel;
    }

    public GProAdInfo getAdInfo() {
        return this.adInfo;
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public GProRecommendChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public GProRecommendExtra getExtra() {
        return this.extra;
    }

    public GProRecommendMyFeed getFeed() {
        return this.feed;
    }

    public GProRecommendItemForumChannel getForumChannel() {
        return this.forumChannel;
    }

    public GProRecommendH5GameChannel getH5gameChannel() {
        return this.h5gameChannel;
    }

    public String getItemId() {
        return this.itemId;
    }

    public long getItemIdUint64() {
        return this.itemIdUint64;
    }

    public int getItemType() {
        return this.itemType;
    }

    public GProQuickJoinBlock getQuickJoinBlock() {
        return this.quickJoinBlock;
    }

    public GProRecommendLiveChannel getRecommendLiveChannel() {
        return this.recommendLiveChannel;
    }

    public GProRecommendRobotDrawCard getRobotDrawCard() {
        return this.robotDrawCard;
    }

    public GProRecommendRobotGameCard getRobotGameCard() {
        return this.robotGameCard;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public GProRecommendTextChannel getTextChannel() {
        return this.textChannel;
    }

    public GProRecommendVoiceChannel getVoiceChannel() {
        return this.voiceChannel;
    }

    public GProVoiceTemplateChannel getVoiceTemplate() {
        return this.voiceTemplate;
    }

    public GProRecommendWorldChannel getWorldChannel() {
        return this.worldChannel;
    }

    public String toString() {
        return "GProRecommendItem{itemId=" + this.itemId + ",itemType=" + this.itemType + ",channelInfo=" + this.channelInfo + ",recommendLiveChannel=" + this.recommendLiveChannel + ",voiceChannel=" + this.voiceChannel + ",feed=" + this.feed + ",worldChannel=" + this.worldChannel + ",itemIdUint64=" + this.itemIdUint64 + ",categories=" + this.categories + ",h5gameChannel=" + this.h5gameChannel + ",adInfo=" + this.adInfo + ",forumChannel=" + this.forumChannel + ",extra=" + this.extra + ",voiceTemplate=" + this.voiceTemplate + ",quickJoinBlock=" + this.quickJoinBlock + ",textChannel=" + this.textChannel + ",robotDrawCard=" + this.robotDrawCard + ",robotGameCard=" + this.robotGameCard + ",adFeedModel=" + this.adFeedModel + ",templateType=" + this.templateType + ",activeTextChannel=" + this.activeTextChannel + ",activeFeedChannel=" + this.activeFeedChannel + ",}";
    }

    public GProRecommendItem(String str, int i2, GProRecommendChannelInfo gProRecommendChannelInfo, GProRecommendLiveChannel gProRecommendLiveChannel, GProRecommendVoiceChannel gProRecommendVoiceChannel, GProRecommendMyFeed gProRecommendMyFeed, GProRecommendWorldChannel gProRecommendWorldChannel, long j2, ArrayList<GProRecommendCategory> arrayList, GProRecommendH5GameChannel gProRecommendH5GameChannel, GProAdInfo gProAdInfo, GProRecommendItemForumChannel gProRecommendItemForumChannel, GProRecommendExtra gProRecommendExtra, GProVoiceTemplateChannel gProVoiceTemplateChannel, GProQuickJoinBlock gProQuickJoinBlock, GProRecommendTextChannel gProRecommendTextChannel, GProRecommendRobotDrawCard gProRecommendRobotDrawCard, GProRecommendRobotGameCard gProRecommendRobotGameCard, byte[] bArr, int i3, GProStickyTextChannel gProStickyTextChannel, GProStickyFeedChannel gProStickyFeedChannel) {
        this.serialVersionUID = 1L;
        this.itemId = "";
        this.channelInfo = new GProRecommendChannelInfo();
        this.recommendLiveChannel = new GProRecommendLiveChannel();
        this.voiceChannel = new GProRecommendVoiceChannel();
        this.feed = new GProRecommendMyFeed();
        this.worldChannel = new GProRecommendWorldChannel();
        this.categories = new ArrayList<>();
        this.h5gameChannel = new GProRecommendH5GameChannel();
        this.adInfo = new GProAdInfo();
        this.forumChannel = new GProRecommendItemForumChannel();
        this.extra = new GProRecommendExtra();
        this.voiceTemplate = new GProVoiceTemplateChannel();
        this.quickJoinBlock = new GProQuickJoinBlock();
        this.textChannel = new GProRecommendTextChannel();
        this.robotDrawCard = new GProRecommendRobotDrawCard();
        this.robotGameCard = new GProRecommendRobotGameCard();
        this.adFeedModel = new byte[0];
        this.activeTextChannel = new GProStickyTextChannel();
        this.activeFeedChannel = new GProStickyFeedChannel();
        this.itemId = str;
        this.itemType = i2;
        this.channelInfo = gProRecommendChannelInfo;
        this.recommendLiveChannel = gProRecommendLiveChannel;
        this.voiceChannel = gProRecommendVoiceChannel;
        this.feed = gProRecommendMyFeed;
        this.worldChannel = gProRecommendWorldChannel;
        this.itemIdUint64 = j2;
        this.categories = arrayList;
        this.h5gameChannel = gProRecommendH5GameChannel;
        this.adInfo = gProAdInfo;
        this.forumChannel = gProRecommendItemForumChannel;
        this.extra = gProRecommendExtra;
        this.voiceTemplate = gProVoiceTemplateChannel;
        this.quickJoinBlock = gProQuickJoinBlock;
        this.textChannel = gProRecommendTextChannel;
        this.robotDrawCard = gProRecommendRobotDrawCard;
        this.robotGameCard = gProRecommendRobotGameCard;
        this.adFeedModel = bArr;
        this.templateType = i3;
        this.activeTextChannel = gProStickyTextChannel;
        this.activeFeedChannel = gProStickyFeedChannel;
    }
}
