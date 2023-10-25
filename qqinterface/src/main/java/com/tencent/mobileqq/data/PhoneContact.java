package com.tencent.mobileqq.data;

public class PhoneContact {
    private static final String TAG = "PhoneContact";
    public int ability;
    public int age;
    public long bindingDate;
    public int contactID;
    public byte detalStatusFlag;
    public int eNetworkType;
    public long highLightTimeStamp;
    public int iTermType;
    public boolean isHiden;
    public boolean isNewRecommend;
    public int isRecommend;
    public String label;
    public String md5;
    public String mobileNo;
    public String name;
    public String nickName;
    public String pinyinAll;
    public String pinyinFirst;
    public String pinyinInitial;
    public String remark;
    public byte[] richBuffer;
    public long richTime;
    public int samFriend;
    public int sex;
    public int type;
    public String uin;
    public String unifiedCode;
    public boolean isUploaded = false;
    public int sortWeight = 0;
    public boolean hasSendAddReq = false;
    public long abilityBits = 0;
    public String strTermDesc = "";
    public int netTypeIconIdIphoneOrWphoneNoWifi = 0;
    public int netTypeIconId = 0;

    public int getNetWorkType() {
        return this.eNetworkType;
    }
}
