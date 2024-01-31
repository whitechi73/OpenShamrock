package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProPAReportExecuteReq implements Serializable {
    long execTime;
    String instrTraceId;
    ArrayList<String> ruleNameList;
    long serialVersionUID;

    public GProPAReportExecuteReq() {
        this.serialVersionUID = 1L;
        this.ruleNameList = new ArrayList<>();
        this.instrTraceId = "";
    }

    public long getExecTime() {
        return this.execTime;
    }

    public String getInstrTraceId() {
        return this.instrTraceId;
    }

    public ArrayList<String> getRuleNameList() {
        return this.ruleNameList;
    }

    public void setExecTime(long j2) {
        this.execTime = j2;
    }

    public void setInstrTraceId(String str) {
        this.instrTraceId = str;
    }

    public void setRuleNameList(ArrayList<String> arrayList) {
        this.ruleNameList = arrayList;
    }

    public String toString() {
        return "GProPAReportExecuteReq{ruleNameList=" + this.ruleNameList + ",instrTraceId=" + this.instrTraceId + ",execTime=" + this.execTime + ",}";
    }

    public GProPAReportExecuteReq(ArrayList<String> arrayList, String str, long j2) {
        this.serialVersionUID = 1L;
        this.ruleNameList = new ArrayList<>();
        this.instrTraceId = "";
        this.ruleNameList = arrayList;
        this.instrTraceId = str;
        this.execTime = j2;
    }
}
