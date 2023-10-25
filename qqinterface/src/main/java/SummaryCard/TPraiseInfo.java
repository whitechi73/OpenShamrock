package SummaryCard;

import com.qq.jce.JceStruct;

public final class TPraiseInfo extends JceStruct {
    public int iIsPayed;
    public long uCustomId;

    public TPraiseInfo() {
        this.uCustomId = 0L;
        this.iIsPayed = 0;
    }
}