package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProRecommendRobotGameCard implements Serializable {
    GProRecommendRobotInfo robotInfo;
    ArrayList<GProRecommendRobotTextChannel> robotTextChannel;
    long serialVersionUID;

    public GProRecommendRobotGameCard() {
        this.serialVersionUID = 1L;
        this.robotInfo = new GProRecommendRobotInfo();
        this.robotTextChannel = new ArrayList<>();
    }

    public GProRecommendRobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public ArrayList<GProRecommendRobotTextChannel> getRobotTextChannel() {
        return this.robotTextChannel;
    }

    public String toString() {
        return "GProRecommendRobotGameCard{robotInfo=" + this.robotInfo + ",robotTextChannel=" + this.robotTextChannel + ",}";
    }

    public GProRecommendRobotGameCard(GProRecommendRobotInfo gProRecommendRobotInfo, ArrayList<GProRecommendRobotTextChannel> arrayList) {
        this.serialVersionUID = 1L;
        this.robotInfo = new GProRecommendRobotInfo();
        this.robotTextChannel = new ArrayList<>();
        this.robotInfo = gProRecommendRobotInfo;
        this.robotTextChannel = arrayList;
    }
}
