package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSearchPermissionFilter {
    boolean activity;
    boolean edit;
    boolean live;
    boolean speak;
    boolean speakRule;
    boolean visible;

    public GProSearchPermissionFilter() {
    }

    public boolean getActivity() {
        return this.activity;
    }

    public boolean getEdit() {
        return this.edit;
    }

    public boolean getLive() {
        return this.live;
    }

    public boolean getSpeak() {
        return this.speak;
    }

    public boolean getSpeakRule() {
        return this.speakRule;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public String toString() {
        return "GProSearchPermissionFilter{speak=" + this.speak + ",visible=" + this.visible + ",live=" + this.live + ",speakRule=" + this.speakRule + ",activity=" + this.activity + ",edit=" + this.edit + ",}";
    }

    public GProSearchPermissionFilter(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.speak = z;
        this.visible = z2;
        this.live = z3;
        this.speakRule = z4;
        this.activity = z5;
        this.edit = z6;
    }
}
