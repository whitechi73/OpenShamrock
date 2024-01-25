package KQQ;

import com.qq.jce.JceStruct;

public final class BatchResponse extends JceStruct {
    public byte[] buffer;
    public int result;
    public int seq;
    public int type;
}