package com.tencent.qqnt.kernel.nativeinterface;


public  final class SceneDetailInfo {
    BasicPointInfo basicPoint;
    BubblePointInfo bubblePoint;
    NumericPointInfo numericPoint;
    PointType pointType;
    GuildGroupSceneType sceneType;

    public SceneDetailInfo() {
        this.sceneType = GuildGroupSceneType.values()[0];
        this.pointType = PointType.values()[0];
        this.basicPoint = new BasicPointInfo();
        this.numericPoint = new NumericPointInfo();
        this.bubblePoint = new BubblePointInfo();
    }

    public BasicPointInfo getBasicPoint() {
        return this.basicPoint;
    }

    public BubblePointInfo getBubblePoint() {
        return this.bubblePoint;
    }

    public NumericPointInfo getNumericPoint() {
        return this.numericPoint;
    }

    public PointType getPointType() {
        return this.pointType;
    }

    public GuildGroupSceneType getSceneType() {
        return this.sceneType;
    }

    public String toString() {
        return "SceneDetailInfo{sceneType=" + this.sceneType + ",pointType=" + this.pointType + ",basicPoint=" + this.basicPoint + ",numericPoint=" + this.numericPoint + ",bubblePoint=" + this.bubblePoint + ",}";
    }

    public SceneDetailInfo(GuildGroupSceneType guildGroupSceneType, PointType pointType, BasicPointInfo basicPointInfo, NumericPointInfo numericPointInfo, BubblePointInfo bubblePointInfo) {
        this.sceneType = GuildGroupSceneType.values()[0];
        this.pointType = PointType.values()[0];
        this.basicPoint = new BasicPointInfo();
        this.numericPoint = new NumericPointInfo();
        this.bubblePoint = new BubblePointInfo();
        this.sceneType = guildGroupSceneType;
        this.pointType = pointType;
        this.basicPoint = basicPointInfo;
        this.numericPoint = numericPointInfo;
        this.bubblePoint = bubblePointInfo;
    }
}
