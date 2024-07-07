package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupMemberListResult {
    public boolean finish;
    public boolean hasRobot;
    public ArrayList<GroupMemberInfoListId> ids = new ArrayList<>();
    public HashMap<String, MemberInfo> infos = new HashMap<>();

    public boolean getFinish() {
        return this.finish;
    }

    public boolean getHasRobot() {
        return this.hasRobot;
    }

    public ArrayList<GroupMemberInfoListId> getIds() {
        return this.ids;
    }

    public HashMap<String, MemberInfo> getInfos() {
        return this.infos;
    }

    public String toString() {
        return "GroupMemberListResult{ids=" + this.ids + ",infos=" + this.infos + ",finish=" + this.finish + ",hasRobot=" + this.hasRobot + ",}";
    }

}
