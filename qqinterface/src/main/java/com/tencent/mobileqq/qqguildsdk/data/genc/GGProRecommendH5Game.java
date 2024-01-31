package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendH5Game;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendMsg;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendH5Game implements IGProRecommendH5Game {
    public final GProRecommendH5Game mInfo;

    public GGProRecommendH5Game(GProRecommendH5Game gProRecommendH5Game) {
        this.mInfo = gProRecommendH5Game;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public IGProRecommendGameInfo getGame() {
        return new GGProRecommendGameInfo(this.mInfo.getGame());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public ArrayList<IGProRecommendMsg> getMembers() {
        ArrayList<GProRecommendMsg> members = this.mInfo.getMembers();
        ArrayList<IGProRecommendMsg> arrayList = new ArrayList<>();
        Iterator<GProRecommendMsg> it = members.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public long getReadyExpireTime() {
        return this.mInfo.getReadyExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public long getTeamId() {
        return this.mInfo.getTeamId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public int getTeamStatus() {
        return this.mInfo.getTeamStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5Game
    public String toString() {
        return this.mInfo.toString();
    }
}
