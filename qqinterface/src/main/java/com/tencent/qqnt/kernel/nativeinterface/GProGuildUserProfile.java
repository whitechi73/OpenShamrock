package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildUserProfile {
    byte age;
    GProUserAllGiftInfo allGiftInfo;
    String avatarMeta;
    String avatarPendant;
    ArrayList<GProClientAccount> bindClientAccount;
    short birthDay;
    short birthMonth;
    short birthYear;
    String city;
    int cityId;
    int cityZoneId;
    ArrayList<GProClientArchive> clientArchives;
    GProClientIdentity clientIdentity;
    GProClientPresence clientPresence;
    String constellation;
    String country;
    int countryId;
    int directMsgBlackFlag;
    int faceAuthStatus;
    GProArchiveArkData firstArchiveArkData;
    int gender;
    boolean hasGuildUserInfo;
    boolean hasMoreArchive;
    int isMember;
    boolean isNlAge;
    boolean isQQFriend;
    long joinGroupProTimeStamp;
    long joinTime;
    int joinedGuildShowSwitch;
    GProUserJoinedGuildSummary joinedGuildSummary;
    ArrayList<GProMedal> medals;
    String memberName;
    String nick;
    String openId;
    String personalSignature;
    String province;
    int provinceId;
    int publishedFeedShowSwitch;
    GProUserPublishedFeedSummary publishedFeedSummary;
    int robotType;
    GProProfileRoomState roomState;
    int roomStateShowSwitch;
    long shutUpExpireTime;
    GProSignGuildInfo signGuildInfo;
    String skinPicUrl;
    long tinyId;
    long uin;
    int userType;
    int verifyFriType;
    String verifyUrl;

    public GProGuildUserProfile() {
        this.nick = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.memberName = "";
        this.clientPresence = new GProClientPresence();
        this.clientArchives = new ArrayList<>();
        this.bindClientAccount = new ArrayList<>();
        this.firstArchiveArkData = new GProArchiveArkData();
        this.avatarMeta = "";
        this.verifyUrl = "";
        this.openId = "";
        this.avatarPendant = "";
        this.medals = new ArrayList<>();
        this.joinedGuildSummary = new GProUserJoinedGuildSummary();
        this.publishedFeedSummary = new GProUserPublishedFeedSummary();
        this.clientIdentity = new GProClientIdentity();
        this.signGuildInfo = new GProSignGuildInfo();
        this.allGiftInfo = new GProUserAllGiftInfo();
    }

    public byte getAge() {
        return this.age;
    }

    public GProUserAllGiftInfo getAllGiftInfo() {
        return this.allGiftInfo;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public ArrayList<GProClientAccount> getBindClientAccount() {
        return this.bindClientAccount;
    }

    public short getBirthDay() {
        return this.birthDay;
    }

    public short getBirthMonth() {
        return this.birthMonth;
    }

    public short getBirthYear() {
        return this.birthYear;
    }

    public String getCity() {
        return this.city;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getCityZoneId() {
        return this.cityZoneId;
    }

    public ArrayList<GProClientArchive> getClientArchives() {
        return this.clientArchives;
    }

    public GProClientIdentity getClientIdentity() {
        return this.clientIdentity;
    }

    public GProClientPresence getClientPresence() {
        return this.clientPresence;
    }

    public String getConstellation() {
        return this.constellation;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public int getDirectMsgBlackFlag() {
        return this.directMsgBlackFlag;
    }

    public int getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    public GProArchiveArkData getFirstArchiveArkData() {
        return this.firstArchiveArkData;
    }

    public int getGender() {
        return this.gender;
    }

    public boolean getHasGuildUserInfo() {
        return this.hasGuildUserInfo;
    }

    public boolean getHasMoreArchive() {
        return this.hasMoreArchive;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public boolean getIsNlAge() {
        return this.isNlAge;
    }

    public boolean getIsQQFriend() {
        return this.isQQFriend;
    }

    public long getJoinGroupProTimeStamp() {
        return this.joinGroupProTimeStamp;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getJoinedGuildShowSwitch() {
        return this.joinedGuildShowSwitch;
    }

    public GProUserJoinedGuildSummary getJoinedGuildSummary() {
        return this.joinedGuildSummary;
    }

    public ArrayList<GProMedal> getMedals() {
        return this.medals;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getNick() {
        return this.nick;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getPersonalSignature() {
        return this.personalSignature;
    }

    public String getProvince() {
        return this.province;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public int getPublishedFeedShowSwitch() {
        return this.publishedFeedShowSwitch;
    }

    public GProUserPublishedFeedSummary getPublishedFeedSummary() {
        return this.publishedFeedSummary;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public GProProfileRoomState getRoomState() {
        return this.roomState;
    }

    public int getRoomStateShowSwitch() {
        return this.roomStateShowSwitch;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime;
    }

    public GProSignGuildInfo getSignGuildInfo() {
        return this.signGuildInfo;
    }

    public String getSkinPicUrl() {
        return this.skinPicUrl;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public long getUin() {
        return this.uin;
    }

    public int getUserType() {
        return this.userType;
    }

    public int getVerifyFriType() {
        return this.verifyFriType;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProGuildUserProfile{uin=" + this.uin + ",tinyId=" + this.tinyId + ",nick=" + this.nick + ",verifyFriType=" + this.verifyFriType + ",gender=" + this.gender + ",isNlAge=" + this.isNlAge + ",age=" + ((int) this.age) + ",birthYear=" + ((int) this.birthYear) + ",birthMonth=" + ((int) this.birthMonth) + ",birthDay=" + ((int) this.birthDay) + ",country=" + this.country + ",province=" + this.province + ",city=" + this.city + ",countryId=" + this.countryId + ",provinceId=" + this.provinceId + ",cityId=" + this.cityId + ",cityZoneId=" + this.cityZoneId + ",userType=" + this.userType + ",joinTime=" + this.joinTime + ",robotType=" + this.robotType + ",memberName=" + this.memberName + ",clientPresence=" + this.clientPresence + ",clientArchives=" + this.clientArchives + ",bindClientAccount=" + this.bindClientAccount + ",hasMoreArchive=" + this.hasMoreArchive + ",firstArchiveArkData=" + this.firstArchiveArkData + ",isMember=" + this.isMember + ",directMsgBlackFlag=" + this.directMsgBlackFlag + ",shutUpExpireTime=" + this.shutUpExpireTime + ",hasGuildUserInfo=" + this.hasGuildUserInfo + ",joinGroupProTimeStamp=" + this.joinGroupProTimeStamp + ",avatarMeta=" + this.avatarMeta + ",faceAuthStatus=" + this.faceAuthStatus + ",verifyUrl=" + this.verifyUrl + ",constellation=" + this.constellation + ",personalSignature=" + this.personalSignature + ",roomState=" + this.roomState + ",isQQFriend=" + this.isQQFriend + ",roomStateShowSwitch=" + this.roomStateShowSwitch + ",publishedFeedShowSwitch=" + this.publishedFeedShowSwitch + ",joinedGuildShowSwitch=" + this.joinedGuildShowSwitch + ",openId=" + this.openId + ",skinPicUrl=" + this.skinPicUrl + ",avatarPendant=" + this.avatarPendant + ",medals=" + this.medals + ",joinedGuildSummary=" + this.joinedGuildSummary + ",publishedFeedSummary=" + this.publishedFeedSummary + ",clientIdentity=" + this.clientIdentity + ",signGuildInfo=" + this.signGuildInfo + ",allGiftInfo=" + this.allGiftInfo + ",}";
    }

    public GProGuildUserProfile(long j2, long j3, String str, int i2, int i3, boolean z, byte b2, short s, short s2, short s3, String str2, String str3, String str4, int i4, int i5, int i6, int i7, int i8, long j4, int i9, String str5, GProClientPresence gProClientPresence, ArrayList<GProClientArchive> arrayList, ArrayList<GProClientAccount> arrayList2, boolean z2, GProArchiveArkData gProArchiveArkData, int i10, int i11, long j5, boolean z3, long j6, String str6, int i12, String str7, String str8, String str9, GProProfileRoomState gProProfileRoomState, boolean z4, int i13, int i14, int i15, String str10, String str11, String str12, ArrayList<GProMedal> arrayList3, GProUserJoinedGuildSummary gProUserJoinedGuildSummary, GProUserPublishedFeedSummary gProUserPublishedFeedSummary, GProClientIdentity gProClientIdentity, GProSignGuildInfo gProSignGuildInfo, GProUserAllGiftInfo gProUserAllGiftInfo) {
        this.nick = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.memberName = "";
        this.clientPresence = new GProClientPresence();
        this.clientArchives = new ArrayList<>();
        this.bindClientAccount = new ArrayList<>();
        this.firstArchiveArkData = new GProArchiveArkData();
        this.avatarMeta = "";
        this.verifyUrl = "";
        this.openId = "";
        this.avatarPendant = "";
        this.medals = new ArrayList<>();
        this.joinedGuildSummary = new GProUserJoinedGuildSummary();
        this.publishedFeedSummary = new GProUserPublishedFeedSummary();
        this.clientIdentity = new GProClientIdentity();
        this.signGuildInfo = new GProSignGuildInfo();
        this.allGiftInfo = new GProUserAllGiftInfo();
        this.uin = j2;
        this.tinyId = j3;
        this.nick = str;
        this.verifyFriType = i2;
        this.gender = i3;
        this.isNlAge = z;
        this.age = b2;
        this.birthYear = s;
        this.birthMonth = s2;
        this.birthDay = s3;
        this.country = str2;
        this.province = str3;
        this.city = str4;
        this.countryId = i4;
        this.provinceId = i5;
        this.cityId = i6;
        this.cityZoneId = i7;
        this.userType = i8;
        this.joinTime = j4;
        this.robotType = i9;
        this.memberName = str5;
        this.clientPresence = gProClientPresence;
        this.clientArchives = arrayList;
        this.bindClientAccount = arrayList2;
        this.hasMoreArchive = z2;
        this.firstArchiveArkData = gProArchiveArkData;
        this.isMember = i10;
        this.directMsgBlackFlag = i11;
        this.shutUpExpireTime = j5;
        this.hasGuildUserInfo = z3;
        this.joinGroupProTimeStamp = j6;
        this.avatarMeta = str6;
        this.faceAuthStatus = i12;
        this.verifyUrl = str7;
        this.constellation = str8;
        this.personalSignature = str9;
        this.roomState = gProProfileRoomState;
        this.isQQFriend = z4;
        this.roomStateShowSwitch = i13;
        this.publishedFeedShowSwitch = i14;
        this.joinedGuildShowSwitch = i15;
        this.openId = str10;
        this.skinPicUrl = str11;
        this.avatarPendant = str12;
        this.medals = arrayList3;
        this.joinedGuildSummary = gProUserJoinedGuildSummary;
        this.publishedFeedSummary = gProUserPublishedFeedSummary;
        this.clientIdentity = gProClientIdentity;
        this.signGuildInfo = gProSignGuildInfo;
        this.allGiftInfo = gProUserAllGiftInfo;
    }
}
