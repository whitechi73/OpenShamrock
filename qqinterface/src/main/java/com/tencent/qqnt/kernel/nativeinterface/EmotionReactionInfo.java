package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class EmotionReactionInfo {
    ArrayList<EmojiReaction> emojiReactionList;
    String id;
    long totalLikeCount;

    public EmotionReactionInfo() {
        this.id = "";
        this.emojiReactionList = new ArrayList<>();
    }

    public ArrayList<EmojiReaction> getEmojiReactionList() {
        return this.emojiReactionList;
    }

    public String getId() {
        return this.id;
    }

    public long getTotalLikeCount() {
        return this.totalLikeCount;
    }

    public String toString() {
        return "EmotionReactionInfo{id=" + this.id + ",emojiReactionList=" + this.emojiReactionList + ",totalLikeCount=" + this.totalLikeCount + ",}";
    }

    public EmotionReactionInfo(String str, ArrayList<EmojiReaction> arrayList, long j2) {
        this.id = "";
        this.emojiReactionList = new ArrayList<>();
        this.id = str;
        this.emojiReactionList = arrayList;
        this.totalLikeCount = j2;
    }
}
