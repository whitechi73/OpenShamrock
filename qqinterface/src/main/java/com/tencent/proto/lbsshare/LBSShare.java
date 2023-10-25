package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class LBSShare {
    public static class LocationReq extends MessageMicro<LocationReq> {
       public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lng = PBField.initInt32(0);
        public final PBUInt32Field coordinate = PBField.initUInt32(0);
        public final PBStringField keyword = PBField.initString("");
        public final PBStringField category = PBField.initString("");
        public final PBUInt32Field page = PBField.initUInt32(0);
        public final PBUInt32Field count = PBField.initUInt32(0);
        public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
        public final PBStringField imei = PBField.initString("");
    }

    public static class LocationResp extends MessageMicro<LocationResp> {
        public final PBUInt32Field ec = PBField.initUInt32(0);
        public final PBRepeatMessageField<POI> poilist = PBField.initRepeatMessage(POI.class);
        public POI mylbs = new POI();
        public final PBUInt32Field next = PBField.initUInt32(0);
        public final PBUInt32Field is_foreign = PBField.initUInt32(0);
        public final PBStringField search_id = PBField.initString("");
        public final PBUInt32Field is_ark = PBField.initUInt32(0);
    }

    public static class POI extends MessageMicro<POI> {
        public final PBStringField name = PBField.initString("");
        public final PBStringField addr = PBField.initString("");
        public final PBStringField shop_url = PBField.initString("");
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lng = PBField.initInt32(0);
        public final PBUInt32Field coordinate = PBField.initUInt32(0);
        public final PBStringField id = PBField.initString("");
        public final PBStringField shop_url_quan = PBField.initString("");
        public final PBStringField dpid = PBField.initString("");
        public final PBUInt32Field shop_count = PBField.initUInt32(0);
        public final PBStringField shangquan_url = PBField.initString("");
        public final PBStringField shangquan_wording = PBField.initString("");
        public final PBStringField POI_preview_url = PBField.initString("");
    }
}
