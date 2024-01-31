package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProPlusPanelBotResponse {
    int nextPage;
    ArrayList<GProPlusPanelBotFeature> plusPanelFeatures;

    public GProPlusPanelBotResponse() {
        this.plusPanelFeatures = new ArrayList<>();
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public ArrayList<GProPlusPanelBotFeature> getPlusPanelFeatures() {
        return this.plusPanelFeatures;
    }

    public String toString() {
        return "GProPlusPanelBotResponse{plusPanelFeatures=" + this.plusPanelFeatures + ",nextPage=" + this.nextPage + ",}";
    }

    public GProPlusPanelBotResponse(ArrayList<GProPlusPanelBotFeature> arrayList, int i2) {
        this.plusPanelFeatures = new ArrayList<>();
        this.plusPanelFeatures = arrayList;
        this.nextPage = i2;
    }
}
