package com.tencent.mobileqq.transfile.protohandler;

import java.util.HashMap;

public class RichProtoProc {
    public static final String ART_FILTER_UP = "art_filter_up";
    public static final String BDH_COMMON_UP = "bdh_common_up";
    public static final String C2C_PIC_DW = "c2c_pic_dw";
    public static final String C2C_PIC_UP = "c2c_pic_up";
    public static final String C2C_PTT_DW = "c2c_ptt_dw";
    public static final String C2C_PTT_UP = "c2c_ptt_up";
    public static final String FRIEND_AVATAR_UP = "friend_avatar_up";
    public static final String GLD_PIC_DW = "gld_pic_dw";
    public static final String GLD_PIC_UP = "gld_pic_up";
    public static final String GRP_PIC_DW = "grp_pic_dw";
    public static final String GRP_PIC_UP = "grp_pic_up";
    public static final String GRP_PTT_DW = "grp_ptt_dw";
    public static final String GRP_PTT_UP = "grp_ptt_up";
    public static final String MULTI_MSG_DW = "multi_msg_dw";
    public static final String MULTI_MSG_UP = "multi_msg_up";
    public static final String NEARBY_PEOPLE_PIC_UP = "nearby_people_pic_up";
    public static final String PA_LONG_MESSAGE = "pa_long_message";
    public static final String SHARE_PIC_TO_WX = "share_pic_to_wx";
    public static final String SHORT_VIDEO_DW = "short_video_dw";
    public static final String SHORT_VIDEO_FW = "short_video_fw";
    public static final String SHORT_VIDEO_UP = "short_video_up";
    public static final String SNAP_PIC_UP = "snap_pic_up";
    public static HashMap<String, Class<? extends RichProtoHandler>> handlerMaps;

    public interface RichProtoCallback {
        void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp);
    }

    public interface RichProtoHandler {
        void sendRichProtoReq(RichProto.RichProtoReq richProtoReq);
    }

    public static RichProtoHandler getHandler(RichProto.RichProtoReq richProtoReq) {
        if (richProtoReq == null || richProtoReq.protoReqMgr == null || richProtoReq.callback == null || richProtoReq.reqs.size() == 0) {
            return null;
        }
        Class<? extends RichProtoHandler> cls = handlerMaps.get(richProtoReq.protoKey);
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void procRichProtoReq(RichProto.RichProtoReq richProtoReq) {
        RichProtoHandler handler = getHandler(richProtoReq);
        if (handler != null) {
            handler.sendRichProtoReq(richProtoReq);
        }
    }
}
