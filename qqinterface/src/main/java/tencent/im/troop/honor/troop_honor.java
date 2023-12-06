package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class troop_honor {
    public static class GroupUserCardHonor extends MessageMicro<GroupUserCardHonor> {
        static final FieldMap __fieldMap__;

        public final PBRepeatField<Integer> id = PBField.initRepeat((PBField) PBUInt32Field.__repeatHelper__);

        public final PBUInt32Field level = PBField.initUInt32(0);

        static {
            Integer integer = Integer.valueOf(0);
            __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "level" }, new Object[] { integer, integer }, GroupUserCardHonor.class);
        }
    }
}
