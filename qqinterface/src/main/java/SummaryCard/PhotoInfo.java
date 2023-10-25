package SummaryCard;

import com.qq.jce.JceStruct;

import java.util.Map;

public final class PhotoInfo extends JceStruct {
    static Map<String, String> cache_mapEx;
    public int IsOnlySelf;
    public Map<String, String> mapEx;
    public String strPicUrl;
    public long uPhotoTimestamp;
}