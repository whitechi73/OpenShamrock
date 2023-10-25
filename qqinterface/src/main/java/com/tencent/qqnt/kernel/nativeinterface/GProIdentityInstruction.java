package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProIdentityInstruction {
    ArrayList<GProIdentity> identityList;
    String instructionText;
    String memberListPreviewImg;
    String noteText;
    String sampleIdentityDesc;
    String textChannelPreviewImg;

    public GProIdentityInstruction() {
        this.instructionText = "";
        this.noteText = "";
        this.textChannelPreviewImg = "";
        this.memberListPreviewImg = "";
        this.sampleIdentityDesc = "";
        this.identityList = new ArrayList<>();
    }

    public ArrayList<GProIdentity> getIdentityList() {
        return this.identityList;
    }

    public String getInstructionText() {
        return this.instructionText;
    }

    public String getMemberListPreviewImg() {
        return this.memberListPreviewImg;
    }

    public String getNoteText() {
        return this.noteText;
    }

    public String getSampleIdentityDesc() {
        return this.sampleIdentityDesc;
    }

    public String getTextChannelPreviewImg() {
        return this.textChannelPreviewImg;
    }

    public String toString() {
        return "GProIdentityInstruction{instructionText=" + this.instructionText + ",noteText=" + this.noteText + ",textChannelPreviewImg=" + this.textChannelPreviewImg + ",memberListPreviewImg=" + this.memberListPreviewImg + ",sampleIdentityDesc=" + this.sampleIdentityDesc + ",identityList=" + this.identityList + ",}";
    }

    public GProIdentityInstruction(String str, String str2, String str3, String str4, String str5, ArrayList<GProIdentity> arrayList) {
        this.instructionText = "";
        this.noteText = "";
        this.textChannelPreviewImg = "";
        this.memberListPreviewImg = "";
        this.sampleIdentityDesc = "";
        this.identityList = new ArrayList<>();
        this.instructionText = str;
        this.noteText = str2;
        this.textChannelPreviewImg = str3;
        this.memberListPreviewImg = str4;
        this.sampleIdentityDesc = str5;
        this.identityList = arrayList;
    }
}
