package com.tencent.qqnt.kernel.nativeinterface;



public final class SearchStranger implements IKernelModel {
    Integer ageMax;
    Integer ageMin;
    Boolean checkNick;
    String countryCode;
    Integer gender;
    String keyWords;

    public SearchStranger() {
    }

    public Integer getAgeMax() {
        return this.ageMax;
    }

    public Integer getAgeMin() {
        return this.ageMin;
    }

    public Boolean getCheckNick() {
        return this.checkNick;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Integer getGender() {
        return this.gender;
    }

    public String getKeyWords() {
        return this.keyWords;
    }

    public void setAgeMax(Integer num) {
        this.ageMax = num;
    }

    public void setAgeMin(Integer num) {
        this.ageMin = num;
    }

    public void setCheckNick(Boolean bool) {
        this.checkNick = bool;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setGender(Integer num) {
        this.gender = num;
    }

    public void setKeyWords(String str) {
        this.keyWords = str;
    }

    public String toString() {
        return "SearchStranger{countryCode=" + this.countryCode + ",keyWords=" + this.keyWords + ",gender=" + this.gender + ",ageMin=" + this.ageMin + ",ageMax=" + this.ageMax + ",checkNick=" + this.checkNick + ",}";
    }

    public SearchStranger(String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool) {
        this.countryCode = str;
        this.keyWords = str2;
        this.gender = num;
        this.ageMin = num2;
        this.ageMax = num3;
        this.checkNick = bool;
    }
}
