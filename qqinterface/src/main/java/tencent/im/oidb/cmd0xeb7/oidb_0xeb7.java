package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public class oidb_0xeb7 {
    public static class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "signInStatusReq", "signInWriteReq" }, new Object[] { null, null }, ReqBody.class);

        public StSignInStatusReq signInStatusReq = new StSignInStatusReq();

        public StSignInWriteReq signInWriteReq = new StSignInWriteReq();
    }


    public static class RspBody extends MessageMicro<RspBody>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "signInStatusRsp", "signInWriteRsp" }, new Object[] { null, null }, RspBody.class);
        public StSignInStatusRsp signInStatusRsp = new StSignInStatusRsp();
        public StSignInWriteRsp signInWriteRsp = new StSignInWriteRsp();
    }


    public static class StSignInWriteRsp
            extends MessageMicro<StSignInWriteRsp>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret", "doneInfo", "groupScore" }, new Object[] { null, null, null }, StSignInWriteRsp.class);
        public SignInStatusDoneInfo doneInfo = new SignInStatusDoneInfo();
        public SignInStatusGroupScore groupScore = new SignInStatusGroupScore();
        public Ret ret = new Ret();
    }

    public static class StSignInStatusRsp
            extends MessageMicro<StSignInStatusRsp>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "ret", "base", "yesterday", "notInfo", "doneInfo", "groupScore", "mantleUrl", "backgroundUrl" }, new Object[] { null, null, null, null, null, null, "", "" }, StSignInStatusRsp.class);
        public final PBStringField backgroundUrl = PBField.initString("");
        public SignInStatusBase base = new SignInStatusBase();
        public SignInStatusDoneInfo doneInfo = new SignInStatusDoneInfo();
        public SignInStatusGroupScore groupScore = new SignInStatusGroupScore();
        public final PBStringField mantleUrl = PBField.initString("");
        public SignInStatusNotInfo notInfo = new SignInStatusNotInfo();
        public Ret ret = new Ret();
        public SignInStatusYesterdayFirst yesterday = new SignInStatusYesterdayFirst();
    }

    public static class SignInStatusYesterdayFirst
            extends MessageMicro<SignInStatusYesterdayFirst>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "yesterdayFirstUid", "yesterdayWord", "yesterdayNick" }, new Object[] { "", "", "" }, SignInStatusYesterdayFirst.class);
        public final PBStringField yesterdayFirstUid = PBField.initString("");
        public final PBStringField yesterdayNick = PBField.initString("");
        public final PBStringField yesterdayWord = PBField.initString("");
    }

    public static class SignInStatusNotInfo
            extends MessageMicro<SignInStatusNotInfo>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "buttonWord", "signDescWordLeft", "signDescWordRight" }, new Object[] { "", "", "" }, SignInStatusNotInfo.class);
        public final PBStringField buttonWord = PBField.initString("");
        public final PBStringField signDescWordLeft = PBField.initString("");
        public final PBStringField signDescWordRight = PBField.initString("");
    }

    public static class SignInStatusGroupScore
            extends MessageMicro<SignInStatusGroupScore>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "groupScoreWord", "scoreUrl" }, new Object[] { "", "" }, SignInStatusGroupScore.class);
        public final PBStringField groupScoreWord = PBField.initString("");
        public final PBStringField scoreUrl = PBField.initString("");
    }

    public static class SignInStatusDoneInfo
            extends MessageMicro<SignInStatusDoneInfo>
    {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "leftTitleWrod", "rightDescWord", "belowPortraitWords", "recordUrl" }, new Object[] { "", "", "", "" }, SignInStatusDoneInfo.class);
        public final PBRepeatField<String> belowPortraitWords = PBField.initRepeat(PBField.initString(""));
        public final PBStringField leftTitleWrod = PBField.initString("");
        public final PBStringField recordUrl = PBField.initString("");
        public final PBStringField rightDescWord = PBField.initString("");
    }

    public static class StSignInRecordDaySigned extends MessageMicro<StSignInRecordDaySigned> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 26, 34 }, new String[] { "daySignedRatio", "dayTotalSignedUid", "daySignedPage", "daySignedUrl" }, new Object[] { Float.valueOf(0.0F), Integer.valueOf(0), null, "" }, StSignInRecordDaySigned.class);

        public StDaySignedPage daySignedPage = new StDaySignedPage();

        public final PBFloatField daySignedRatio = PBField.initFloat(0.0F);

        public final PBStringField daySignedUrl = PBField.initString("");

        public final PBInt32Field dayTotalSignedUid = PBField.initInt32(0);
    }


    public static class SignInStatusBase extends MessageMicro<SignInStatusBase> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "status", "currentTimeStamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SignInStatusBase.class);

        public final PBInt64Field currentTimeStamp = PBField.initInt64(0L);

        public final PBEnumField status = PBField.initEnum(0);
    }


    public static class StSignInRecordRsp extends MessageMicro<StSignInRecordRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "ret", "base", "userRecord", "daySigned", "kingRecord", "level" }, new Object[] { null, null, null, null, null, null }, StSignInRecordRsp.class);

        public SignInStatusBase base = new SignInStatusBase();

        public StSignInRecordDaySigned daySigned = new StSignInRecordDaySigned();

        public StSignInRecordKing kingRecord = new StSignInRecordKing();

        public StViewGroupLevel level = new StViewGroupLevel();

        public Ret ret = new Ret();

        public StSignInRecordUser userRecord = new StSignInRecordUser();
    }

    public static class Ret extends MessageMicro<Ret> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "code", "msg" }, new Object[] { Integer.valueOf(0), "" }, Ret.class);

        public final PBEnumField code = PBField.initEnum(0);

        public final PBStringField msg = PBField.initString("");
    }


    public static class StSignInRecordUser extends MessageMicro<StSignInRecordUser> {
        static final MessageMicro.FieldMap __fieldMap__;

        public final PBInt64Field continueSignedDays = PBField.initInt64(0L);

        public final PBInt64Field earliestSignedTimeStamp = PBField.initInt64(0L);

        public final PBStringField groupName = PBField.initString("");

        public final PBRepeatField<String> historySignedDays = PBField.initRepeat(PBField.initString(""));

        public final PBInt32Field totalSignedDays = PBField.initInt32(0);

        static {
            Long long_ = Long.valueOf(0L);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32, 42, 50 }, new String[] { "totalSignedDays", "earliestSignedTimeStamp", "continueSignedDays", "historySignedDays", "groupName" }, new Object[] { Integer.valueOf(0), long_, long_, "", "" }, StSignInRecordUser.class);
        }
    }

    public static class StDaySignedInfo extends MessageMicro<StDaySignedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "uid", "uidGroupNick", "signedTimeStamp", "signInRank" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0) }, StDaySignedInfo.class);

        public final PBInt32Field signInRank = PBField.initInt32(0);

        public final PBInt64Field signedTimeStamp = PBField.initInt64(0L);

        public final PBStringField uid = PBField.initString("");

        public final PBStringField uidGroupNick = PBField.initString("");
    }

    public static class StDaySignedPage extends MessageMicro<StDaySignedPage> {
        static final MessageMicro.FieldMap __fieldMap__;

        public final PBRepeatMessageField<StDaySignedInfo> infos = PBField.initRepeatMessage(StDaySignedInfo.class);

        public final PBInt32Field offset = PBField.initInt32(0);

        public final PBInt32Field total = PBField.initInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "infos", "offset", "total" }, new Object[] { null, integer, integer }, StDaySignedPage.class);
        }
    }

    public static class StKingSignedInfo extends MessageMicro<StKingSignedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "uid", "groupNick", "signedTimeStamp", "signedCount" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0) }, StKingSignedInfo.class);

        public final PBStringField groupNick = PBField.initString("");

        public final PBInt32Field signedCount = PBField.initInt32(0);

        public final PBInt64Field signedTimeStamp = PBField.initInt64(0L);

        public final PBStringField uid = PBField.initString("");
    }
    
    public static class StSignInStatusReq extends MessageMicro<StSignInStatusReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "uid", "groupId", "scene", "clientVersion" }, new Object[] { "", "", Integer.valueOf(0), "" }, StSignInStatusReq.class);

        public final PBStringField clientVersion = PBField.initString("");

        public final PBStringField groupId = PBField.initString("");

        public final PBEnumField scene = PBField.initEnum(0);

        public final PBStringField uid = PBField.initString("");
    }


    public static class StSignInWriteReq extends MessageMicro<StSignInWriteReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uid", "groupId", "clientVersion" }, new Object[] { "", "", "" }, StSignInWriteReq.class);

        public final PBStringField clientVersion = PBField.initString("");

        public final PBStringField groupId = PBField.initString("");

        public final PBStringField uid = PBField.initString("");
    }

    public static class StViewGroupLevel extends MessageMicro<StViewGroupLevel> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title", "url" }, new Object[] { "", "" }, StViewGroupLevel.class);

        public final PBStringField title = PBField.initString("");

        public final PBStringField url = PBField.initString("");
    }


    public static class StSignInRecordKing extends MessageMicro<StSignInRecordKing> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "yesterdayFirst", "topSignedTotal", "topSignedContinue", "kingUrl" }, new Object[] { null, null, null, "" }, StSignInRecordKing.class);

        public final PBStringField kingUrl = PBField.initString("");

        public final PBRepeatMessageField<StKingSignedInfo> topSignedContinue = PBField.initRepeatMessage(StKingSignedInfo.class);

        public final PBRepeatMessageField<StKingSignedInfo> topSignedTotal = PBField.initRepeatMessage(StKingSignedInfo.class);

        public StKingSignedInfo yesterdayFirst = new StKingSignedInfo();
    }


}





