package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

import msf.msgcomm.msg_comm;

public class msg_transmit {
    public static class PbMultiMsgTransmit extends MessageMicro<PbMultiMsgTransmit> {
        public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
        public final PBRepeatMessageField<msg_transmit.PbMultiMsgItem> pbItemList = PBField.initRepeatMessage(msg_transmit.PbMultiMsgItem.class);
    }

    public static class PbMultiMsgItem extends MessageMicro<PbMultiMsgItem> {
        public final PBStringField fileName = PBField.initString("");
        public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    public static class PbMultiMsgNew extends MessageMicro<PbMultiMsgNew> {
        public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
    }

}
