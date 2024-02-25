package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MsgRecord {
    AnonymousExtInfo anonymousExtInfo;
    int atType;
    int avatarFlag;
    String avatarMeta;
    String avatarPendant;
    int categoryManage;
    String channelId;
    String channelName;
    int chatType;
    GProClientIdentity clientIdentityInfo;
    long clientSeq;
    long cntSeq;
    long commentCnt;
    int directMsgFlag;
    ArrayList<DirectMsgMember> directMsgMembers;
    boolean editable;
    ArrayList<MsgElement> elements;
    ArrayList<MsgEmojiLikes> emojiLikesList;
    byte[] extInfoForUI;
    String feedId;
    Integer fileGroupSize;
    FoldingInfo foldingInfo;
    FreqLimitInfo freqLimitInfo;
    long fromAppid;
    FromRoleInfo fromChannelRoleInfo;
    FromRoleInfo fromGuildRoleInfo;
    long fromUid;
    byte[] generalFlags;
    long guildCode;
    String guildId;
    String guildName;
    boolean isImportMsg;
    boolean isOnlineMsg;
    FromRoleInfo levelRoleInfo;
    HashMap<Integer, MsgAttributeInfo> msgAttrs;
    byte[] msgEventInfo;
    long msgId;
    byte[] msgMeta;
    long msgRandom;
    long msgSeq;
    long msgTime;
    int msgType;
    MultiTransInfo multiTransInfo;
    int nameType;
    String peerName;
    String peerUid;
    long peerUin;
    GProMedal personalMedal;
    long recallTime;
    ArrayList<MsgRecord> records;
    long roleId;
    int roleType;
    String sendMemberName;
    String sendNickName;
    String sendRemarkName;
    int sendStatus;
    int sendType;
    String senderUid;
    long senderUin;
    int subMsgType;
    long timeStamp;

    public MsgRecord() {
        this.senderUid = "";
        this.peerUid = "";
        this.channelId = "";
        this.guildId = "";
        this.msgMeta = new byte[0];
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.guildName = "";
        this.channelName = "";
        this.elements = new ArrayList<>();
        this.records = new ArrayList<>();
        this.emojiLikesList = new ArrayList<>();
        this.directMsgMembers = new ArrayList<>();
        this.peerName = "";
        this.avatarMeta = "";
        this.avatarPendant = "";
        this.feedId = "";
        this.fromChannelRoleInfo = new FromRoleInfo();
        this.fromGuildRoleInfo = new FromRoleInfo();
        this.levelRoleInfo = new FromRoleInfo();
        this.generalFlags = new byte[0];
        this.msgAttrs = new HashMap<>();
    }

    public AnonymousExtInfo getAnonymousExtInfo() {
        return this.anonymousExtInfo;
    }

    public int getAtType() {
        return this.atType;
    }

    public int getAvatarFlag() {
        return this.avatarFlag;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public int getCategoryManage() {
        return this.categoryManage;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public GProClientIdentity getClientIdentityInfo() {
        return this.clientIdentityInfo;
    }

    public long getClientSeq() {
        return this.clientSeq;
    }

    public long getCntSeq() {
        return this.cntSeq;
    }

    public long getCommentCnt() {
        return this.commentCnt;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public ArrayList<DirectMsgMember> getDirectMsgMembers() {
        return this.directMsgMembers;
    }

    public boolean getEditable() {
        return this.editable;
    }

    public ArrayList<MsgElement> getElements() {
        return this.elements;
    }

    public ArrayList<MsgEmojiLikes> getEmojiLikesList() {
        return this.emojiLikesList;
    }

    public byte[] getExtInfoForUI() {
        return this.extInfoForUI;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public Integer getFileGroupSize() {
        return this.fileGroupSize;
    }

    public FoldingInfo getFoldingInfo() {
        return this.foldingInfo;
    }

    public FreqLimitInfo getFreqLimitInfo() {
        return this.freqLimitInfo;
    }

    public long getFromAppid() {
        return this.fromAppid;
    }

    public FromRoleInfo getFromChannelRoleInfo() {
        return this.fromChannelRoleInfo;
    }

    public FromRoleInfo getFromGuildRoleInfo() {
        return this.fromGuildRoleInfo;
    }

    public long getFromUid() {
        return this.fromUid;
    }

    public byte[] getGeneralFlags() {
        return this.generalFlags;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public boolean getIsImportMsg() {
        return this.isImportMsg;
    }

    public boolean getIsOnlineMsg() {
        return this.isOnlineMsg;
    }

    public FromRoleInfo getLevelRoleInfo() {
        return this.levelRoleInfo;
    }

    public HashMap<Integer, MsgAttributeInfo> getMsgAttrs() {
        return this.msgAttrs;
    }

    public byte[] getMsgEventInfo() {
        return this.msgEventInfo;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public byte[] getMsgMeta() {
        return this.msgMeta;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public MultiTransInfo getMultiTransInfo() {
        return this.multiTransInfo;
    }

    public int getNameType() {
        return this.nameType;
    }

    public String getPeerName() {
        return this.peerName;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public long getPeerUin() {
        return this.peerUin;
    }

    public GProMedal getPersonalMedal() {
        return this.personalMedal;
    }

    public long getRecallTime() {
        return this.recallTime;
    }

    public ArrayList<MsgRecord> getRecords() {
        return this.records;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String getSendMemberName() {
        return this.sendMemberName;
    }

    public String getSendNickName() {
        return this.sendNickName;
    }

    public String getSendRemarkName() {
        return this.sendRemarkName;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public int getSubMsgType() {
        return this.subMsgType;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "MsgRecord{msgId=" + this.msgId + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",cntSeq=" + this.cntSeq + ",chatType=" + this.chatType + ",msgType=" + this.msgType + ",subMsgType=" + this.subMsgType + ",sendType=" + this.sendType + ",senderUid=" + this.senderUid + ",peerUid=" + this.peerUid + ",channelId=" + this.channelId + ",guildId=" + this.guildId + ",guildCode=" + this.guildCode + ",fromUid=" + this.fromUid + ",fromAppid=" + this.fromAppid + ",msgTime=" + this.msgTime + ",msgMeta=" + this.msgMeta + ",sendStatus=" + this.sendStatus + ",sendRemarkName=" + this.sendRemarkName + ",sendMemberName=" + this.sendMemberName + ",sendNickName=" + this.sendNickName + ",guildName=" + this.guildName + ",channelName=" + this.channelName + ",elements=" + this.elements + ",records=" + this.records + ",emojiLikesList=" + this.emojiLikesList + ",commentCnt=" + this.commentCnt + ",directMsgFlag=" + this.directMsgFlag + ",directMsgMembers=" + this.directMsgMembers + ",peerName=" + this.peerName + ",freqLimitInfo=" + this.freqLimitInfo + ",editable=" + this.editable + ",avatarMeta=" + this.avatarMeta + ",avatarPendant=" + this.avatarPendant + ",feedId=" + this.feedId + ",roleId=" + this.roleId + ",timeStamp=" + this.timeStamp + ",clientIdentityInfo=" + this.clientIdentityInfo + ",isImportMsg=" + this.isImportMsg + ",atType=" + this.atType + ",roleType=" + this.roleType + ",fromChannelRoleInfo=" + this.fromChannelRoleInfo + ",fromGuildRoleInfo=" + this.fromGuildRoleInfo + ",levelRoleInfo=" + this.levelRoleInfo + ",recallTime=" + this.recallTime + ",isOnlineMsg=" + this.isOnlineMsg + ",generalFlags=" + this.generalFlags + ",clientSeq=" + this.clientSeq + ",fileGroupSize=" + this.fileGroupSize + ",foldingInfo=" + this.foldingInfo + ",multiTransInfo=" + this.multiTransInfo + ",senderUin=" + this.senderUin + ",peerUin=" + this.peerUin + ",msgAttrs=" + this.msgAttrs + ",anonymousExtInfo=" + this.anonymousExtInfo + ",nameType=" + this.nameType + ",avatarFlag=" + this.avatarFlag + ",extInfoForUI=" + this.extInfoForUI + ",personalMedal=" + this.personalMedal + ",categoryManage=" + this.categoryManage + ",msgEventInfo=" + this.msgEventInfo + ",}";
    }

    public MsgRecord(long j2, long j3, long j4, long j5, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, long j6, long j7, long j8, long j9, byte[] bArr, int i6, String str5, String str6, String str7, String str8, String str9, ArrayList<MsgElement> arrayList, ArrayList<MsgRecord> arrayList2, ArrayList<MsgEmojiLikes> arrayList3, long j10, int i7, ArrayList<DirectMsgMember> arrayList4, String str10, FreqLimitInfo freqLimitInfo, boolean z, String str11, String str12, String str13, long j11, long j12, GProClientIdentity gProClientIdentity, boolean z2, int i8, int i9, FromRoleInfo fromRoleInfo, FromRoleInfo fromRoleInfo2, FromRoleInfo fromRoleInfo3, long j13, boolean z3, byte[] bArr2, long j14, Integer num, FoldingInfo foldingInfo, MultiTransInfo multiTransInfo, long j15, long j16, HashMap<Integer, MsgAttributeInfo> hashMap, AnonymousExtInfo anonymousExtInfo, int i10, int i11, byte[] bArr3, GProMedal gProMedal, int i12, byte[] bArr4) {
        this.senderUid = "";
        this.peerUid = "";
        this.channelId = "";
        this.guildId = "";
        this.msgMeta = new byte[0];
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.guildName = "";
        this.channelName = "";
        this.elements = new ArrayList<>();
        this.records = new ArrayList<>();
        this.emojiLikesList = new ArrayList<>();
        this.directMsgMembers = new ArrayList<>();
        this.peerName = "";
        this.avatarMeta = "";
        this.avatarPendant = "";
        this.feedId = "";
        this.fromChannelRoleInfo = new FromRoleInfo();
        this.fromGuildRoleInfo = new FromRoleInfo();
        this.levelRoleInfo = new FromRoleInfo();
        this.generalFlags = new byte[0];
        this.msgAttrs = new HashMap<>();
        this.msgId = j2;
        this.msgRandom = j3;
        this.msgSeq = j4;
        this.cntSeq = j5;
        this.chatType = i2;
        this.msgType = i3;
        this.subMsgType = i4;
        this.sendType = i5;
        this.senderUid = str;
        this.peerUid = str2;
        this.channelId = str3;
        this.guildId = str4;
        this.guildCode = j6;
        this.fromUid = j7;
        this.fromAppid = j8;
        this.msgTime = j9;
        this.msgMeta = bArr;
        this.sendStatus = i6;
        this.sendRemarkName = str5;
        this.sendMemberName = str6;
        this.sendNickName = str7;
        this.guildName = str8;
        this.channelName = str9;
        this.elements = arrayList;
        this.records = arrayList2;
        this.emojiLikesList = arrayList3;
        this.commentCnt = j10;
        this.directMsgFlag = i7;
        this.directMsgMembers = arrayList4;
        this.peerName = str10;
        this.freqLimitInfo = freqLimitInfo;
        this.editable = z;
        this.avatarMeta = str11;
        this.avatarPendant = str12;
        this.feedId = str13;
        this.roleId = j11;
        this.timeStamp = j12;
        this.clientIdentityInfo = gProClientIdentity;
        this.isImportMsg = z2;
        this.atType = i8;
        this.roleType = i9;
        this.fromChannelRoleInfo = fromRoleInfo;
        this.fromGuildRoleInfo = fromRoleInfo2;
        this.levelRoleInfo = fromRoleInfo3;
        this.recallTime = j13;
        this.isOnlineMsg = z3;
        this.generalFlags = bArr2;
        this.clientSeq = j14;
        this.fileGroupSize = num;
        this.foldingInfo = foldingInfo;
        this.multiTransInfo = multiTransInfo;
        this.senderUin = j15;
        this.peerUin = j16;
        this.msgAttrs = hashMap;
        this.anonymousExtInfo = anonymousExtInfo;
        this.nameType = i10;
        this.avatarFlag = i11;
        this.extInfoForUI = bArr3;
        this.personalMedal = gProMedal;
        this.categoryManage = i12;
        this.msgEventInfo = bArr4;
    }
}