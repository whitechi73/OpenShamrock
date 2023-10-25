package com.tencent.mobileqq.data;

import android.util.SparseArray;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import SummaryCard.PhotoInfo;
import SummaryCard.TPraiseInfo;

public class Card {
    public static final long BIRTHDAY_INVALID = 0;
    public static final int CONSTELLATION_INVALID = 0;
    public static final short FEMALE = 1;
    public static final int INVALID_STATE = -1;
    public static final short MALE = 0;
    public static final int PROFESSION_DEFAULT = -1;
    private static final String TAG = "Card";
    public static final short UNKNOWN_MALE = -1;
    public long addSrcId;
    public String addSrcName;
    public long addSubSrcId;
    public byte age;
    public boolean allowCalInteractive;
    public boolean allowClick;
    public boolean allowPeopleSee;
    public long authState;
    public byte bBigClubVipOpen;
    public byte[] bCardInfo; // Oidb_0x43c$CardInfo
    public byte bHollywoodVipOpen;
    public byte bQQVipOpen;
    public byte bSuperQQOpen;
    public byte bSuperVipOpen;
    public byte bVoted;
    public boolean babyQSwitch;
    public byte[] bgType;
    public String bindPhoneInfo;
    private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> businessInfoMap;
    public long cardId;
    public int cardType;
    public int category;
    public int clothesId;
    
    public String coverUrl;
    public String declaration;
    public int defaultCardId;
    public String diyComplicatedInfo;
    public String diyDefaultText;
    public String diyText;
    public float diyTextDegree;
    public int diyTextFontId;
    public float diyTextHeight;
    public float diyTextLocX;
    public float diyTextLocY;
    public float diyTextTransparency;
    public float diyTextWidth;
    
    public boolean dressUpIsOn;
    public String encId;
    public int enlargeQzonePic;
    public short extendFriendEntryAddFriend;
    public short extendFriendEntryContact;
    public int extendFriendFlag;
    public short extendFriendQuestion;
    public int extendFriendVoiceDuration;
    public int favoriteSource;
    public long feedPreviewTime;
    public int fontId;
    public int fontType;
    
    public boolean hasRequestZPlanAvatarInfo;
    public String hobbyEntry;
    public int iBigClubVipLevel;
    public int iBigClubVipType;
    public int iHollywoodVipLevel;
    public int iHollywoodVipType;
    public int iMedalCount;
    public int iNewCount;
    public int iQQLevel;
    public int iQQVipLevel;
    public int iQQVipType;
    public int iSuperQQLevel;
    public int iSuperQQType;
    public int iSuperVipLevel;
    public int iSuperVipType;
    public int iUpgradeCount;
    public int iVoteIncrement;
    public int iXManScene1DelayTime;
    public int iXManScene2DelayTime;
    public int idx;
    public boolean isHidePrettyGroutIdentity;
    public boolean isPrettyGroupOwner;
    
    public boolean isQCircleDynamicAvatar;
    public boolean isShowCard;
    
    public boolean isShowQCircleCover;
    
    public boolean isStrongSimilarity;
    public boolean isZPlanAvatar;
    public boolean isZplanMasterShow;
    public boolean isZplanProfileCardShow;
    public long lBigClubTemplateId;
    public long lLoginDays;
    public long lQQMasterLogindays;
    public long lSignModifyTime;
    public long lSuperVipTemplateId;
    public long lUserFlag;
    public long lVisitCount;
    public long lVoteCount;
    public byte[] labelInfoBytes;
    public byte[] lastPraiseInfoList;
    
    public ArrayList<TPraiseInfo> lastPraiseInfos;
    public int mQQLevelType;
    public Map<String, String> mapQzoneEx;
    
    public int mutualCount;
    
    //public MutualMarkCard$Guide mutualGuide;
    
    public String mutualHomeUrl;
    public int nFaceID;
    public int namePlateOfKingDan;
    public boolean namePlateOfKingDanDisplatSwitch;
    public long namePlateOfKingGameId;
    public long namePlateOfKingLoginTime;
    public int popularity;
    public String presentCustourl;
    public String presentDesc;
    public int presentNum;
    public boolean presentSwitch;
    public List<String> presentUrl;
    public String privilegeJumpUrl;
    public String privilegePromptStr;
    
    public String qcircleFeedId;
    
    public String qcircleFeedPosterUin;
    
    public String qcircleVideoCoverUrl;
    
    public int qcircleVideoHeight;
    
    public String qcircleVideoUrl;
    
    public int qcircleVideoWidth;
    public String qid;
    public String qidBgUrl;
    public String qidColor;
    public String qidLogoUrl;
    
    public boolean qqCardIsOn;
    public String schoolId;
    public String schoolName;
    public boolean schoolVerifiedFlag;
    public boolean showPublishButton;
    
    public String singer;
    
    public long songDuration;
    
    public String songId;
    
    public String songName;
    
    public boolean splendidIsGray;
    
    public boolean splendidIsOn;
    
    public String splendidJumpUrl;
    
    public int splendidNValueNum;
    
    public int splendidNum;
    public String strAutoRemark;
    public String strCity;
    public String strCompany;
    public String strContactName;
    public String strCountry;
    public String strCurrentBgUrl;
    public String strEmail;
    public String strExtInfo;
    public String strHometownCity;
    public String strHometownCodes;
    public String strHometownCountry;
    public String strHometownDesc;
    public String strHometownProvince;
    public String strLocationCodes;
    public String strLocationDesc;
    public String strLoginDaysDesc;
    public String strMobile;
    public String strNick;
    public String strPersonalNote;
    public String strPromptParams;
    public String strProvince;
    public String strQzoneFeedsDesc;
    public String strQzoneHeader;
    public String strReMark;
    public String strSchool;
    public String strShowName;
    public String strSign;
    public String strSpaceName;
    public String strStatus;
    public String strVoteLimitedNotice;
    
    public String strZPlanNightUrl;
    
    public String strZPlanProperty;
    
    public String strZPlanShpUrl;
    
    public String strZplanDayUrl;
    public String strZplanUrl;
    public boolean strangerVoteOpen;
    
    //public StrongSimilarityData strongSimilarityData;
    
    public List<ProfileSummaryHobbiesEntry> summaryEntrys;
    public byte[] tempChatSig;
    public long uCurMulType;
    public int uFaceTimeStamp;
    public String uin;
    public int ulShowControl;
    public long updateTime;
    public byte[] vClosePriv;
    public byte[] vCookies;
    public byte[] vCoverInfo;
    public byte[] vLongNickTopicInfo;
    public byte[] vOpenPriv;
    public byte[] vQQFaceID;
    public byte[] vQzoneCoverInfo;
    public byte[] vQzonePhotos;
    public byte[] vRichSign;
    public byte[] vSeed;
    public String voiceUrl;
    public byte[] wzryHonorInfo;
    
    public String zplanAppearanceKey;
    
    public String zplanAvatarBackgroundUrl;
    
    public String zplanGander;
    
    public String zplanNameplateId;
    public short shGender = -1;
    public int constellation = 0;
    public long lBirthday = 0;
    public int iProfession = -1;
    
    public short switchMusicBox = -1;
    
    public short switchStickyNote = -1;
    
    public short offlineStickyNote = -1;
    
    public short switchQQCircle = -1;
    
    public short switchLifeAchievement = -1;
    
    public short switchWeiShi = -1;
    
    public short switchPrivilege = -1;
    
    public short switchMembershipAndRank = -1;
    
    public SparseArray<Integer> profileDisplaySettingStates = new SparseArray<>(0);
    public boolean hasFakeData = false;
    
    public int likeAreaId = 0;
    public int nameplateVipType = 0;
    public int grayNameplateFlag = 0;
    public int nameplateExtId = 0;
    public int gameCardId = 0;
    public int vipStarFlag = 0;
    public String vipIcons = "";
    
    public int vipDataFlag = 0;
    public boolean isSuperRedDiamond = false;
    public boolean isRedDiamond = false;
    public int redLevel = 0;
    public boolean isSuperYellowDiamond = false;
    public boolean isYellowDiamond = false;
    public int yellowLevel = 0;
    public boolean isSuperGreenDiamond = false;
    public boolean isGreenDiamond = false;
    public int greenLevel = 0;
    public int templateRet = 0;
    public long lCurrentStyleId = -1;
    public long lCurrentBgId = -1;
    public String backgroundUrl = "";
    public long backgroundColor = 0;
    public int dynamicCardFlag = 0;
    public String strZipUrl = "";
    public String strActiveUrl = "";
    public String strDrawerCardUrl = "";
    public String strWzryHeroUrl = "";
    public boolean showPresent = false;
    
    public String dressUpJumpUrl = "";
    
    //public List<UsingDressUpItemData> dressUpList = new ArrayList();
    
    public String qqCardJumpUrl = "";
    
    //public List<QQCardItemData> qqCardList = new ArrayList();
    
    //public List<SplendidItemData> splendidItems = new ArrayList();
    public short bHaveVotedCnt = 0;
    public short bAvailVoteCnt = -1;
    public boolean medalSwitchDisable = false;
    
    public final List<PhotoInfo> qzonePhotoList = new CopyOnWriteArrayList();
    
    public float qcircleCoverY = 0.0f;
    public float diyTextScale = 1.0f;
    public boolean strangerInviteMeGroupOpen = true;
    
    //public List<SimilarityData> similarityData = new ArrayList();
    
    //public List<mutualmark$State> mutualStateList = new ArrayList();
    
    //public cmd0x703$UinPhotoListInfo mPhotoListInfo = null;

    public int newSchoolStatusFlagForGuide = 1;
    public boolean troopHonorSwitch = true;
    public int lhLevel = -1;
}