package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProLocation {
    String city;
    int cityId;
    String cityZone;
    int cityZoneId;
    String country;
    int countryId;
    String province;
    int provinceId;

    public GProLocation() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.cityZone = "";
    }

    public String getCity() {
        return this.city;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getCityZone() {
        return this.cityZone;
    }

    public int getCityZoneId() {
        return this.cityZoneId;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getProvince() {
        return this.province;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public String toString() {
        return "GProLocation{countryId=" + this.countryId + ",provinceId=" + this.provinceId + ",cityId=" + this.cityId + ",cityZoneId=" + this.cityZoneId + ",country=" + this.country + ",province=" + this.province + ",city=" + this.city + ",cityZone=" + this.cityZone + ",}";
    }

    public GProLocation(int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4) {
        this.country = "";
        this.province = "";
        this.city = "";
        this.cityZone = "";
        this.countryId = i2;
        this.provinceId = i3;
        this.cityId = i4;
        this.cityZoneId = i5;
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.cityZone = str4;
    }
}
