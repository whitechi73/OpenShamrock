package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GGProStickyFeedChannel;
import com.tencent.mobileqq.qqguildsdk.data.GGProStickyTextChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendCategory;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendItem implements IGProRecommendItem {
    public final GProRecommendItem mInfo;

    public GGProRecommendItem(GProRecommendItem gProRecommendItem) {
        this.mInfo = gProRecommendItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProStickyFeedChannel getActiveFeedChannel() {
        return new GGProStickyFeedChannel(this.mInfo.getActiveFeedChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProStickyTextChannel getActiveTextChannel() {
        return new GGProStickyTextChannel(this.mInfo.getActiveTextChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProActiveUser getActiveUser() {
        //return new GGProActiveUser(this.mInfo.getActiveUser());
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public byte[] getAdFeedModel() {
        return this.mInfo.getAdFeedModel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProAdInfo getAdInfo() {
        return new GGProAdInfo(this.mInfo.getAdInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public ArrayList<IGProRecommendCategory> getCategories() {
        ArrayList<GProRecommendCategory> categories = this.mInfo.getCategories();
        ArrayList<IGProRecommendCategory> arrayList = new ArrayList<>();
        Iterator<GProRecommendCategory> it = categories.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendCategory(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendChannelInfo getChannelInfo() {
        return new GGProRecommendChannelInfo(this.mInfo.getChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendExtra getExtra() {
        return new GGProRecommendExtra(this.mInfo.getExtra());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendMyFeed getFeed() {
        return new GGProRecommendMyFeed(this.mInfo.getFeed());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendItemForumChannel getForumChannel() {
        return new GGProRecommendItemForumChannel(this.mInfo.getForumChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendH5GameChannel getH5gameChannel() {
        return new GGProRecommendH5GameChannel(this.mInfo.getH5gameChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProItemHeadInfo getItemHeadInfo() {
        //return new GGProItemHeadInfo(this.mInfo.getItemHeadInfo());
        return null;

    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public String getItemId() {
        return this.mInfo.getItemId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public long getItemIdUint64() {
        return this.mInfo.getItemIdUint64();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public int getItemType() {
        return this.mInfo.getItemType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProPageHeadInfo getPageHeadInfo() {
        return null;
        //return new GGProPageHeadInfo(this.mInfo.getPageHeadInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProQuickJoinBlock getQuickJoinBlock() {
        return new GGProQuickJoinBlock(this.mInfo.getQuickJoinBlock());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendLiveChannel getRecommendLiveChannel() {
        return new GGProRecommendLiveChannel(this.mInfo.getRecommendLiveChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public ArrayList<String> getRecommendReasons() {
        return null;
        //return this.mInfo.getRecommendReasons();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendRobotDrawCard getRobotDrawCard() {
        return new GGProRecommendRobotDrawCard(this.mInfo.getRobotDrawCard());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendRobotGameCard getRobotGameCard() {
        return new GGProRecommendRobotGameCard(this.mInfo.getRobotGameCard());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProSearchItem getSearchItem() {
        return null;
        //return new GGProSearchItem(this.mInfo.getSearchItem());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public int getTemplateType() {
        return this.mInfo.getTemplateType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendTextChannel getTextChannel() {
        return new GGProRecommendTextChannel(this.mInfo.getTextChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProRecommendVoiceChannel getVoiceChannel() {
        return new GGProRecommendVoiceChannel(this.mInfo.getVoiceChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public IGProVoiceTemplateChannel getVoiceTemplate() {
        return new GGProVoiceTemplateChannel(this.mInfo.getVoiceTemplate());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem
    public String toString() {
        return this.mInfo.toString();
    }
}
