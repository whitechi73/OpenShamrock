package friendlist;

import com.qq.jce.JceStruct;

public final class stUinInfo extends JceStruct {
    public byte cGender;
    public long dwFlag;
    public long dwuin;
    public String sEmail;
    public String sName;
    public String sPhone;
    public String sRemark;
    public stUinInfo() {
        this.dwuin = 0L;
        this.dwFlag = 0L;
        this.sName = "";
        this.cGender = (byte) 0;
        this.sPhone = "";
        this.sEmail = "";
        this.sRemark = "";
    }
    public stUinInfo(long j2, long j3, String str, byte b2, String str2, String str3, String str4) {
        this.dwuin = 0L;
        this.dwFlag = 0L;
        this.sName = "";
        this.cGender = (byte) 0;
        this.sPhone = "";
        this.sEmail = "";
        this.sRemark = "";
        this.dwuin = j2;
        this.dwFlag = j3;
        this.sName = str;
        this.cGender = b2;
        this.sPhone = str2;
        this.sEmail = str3;
        this.sRemark = str4;
    }
}
