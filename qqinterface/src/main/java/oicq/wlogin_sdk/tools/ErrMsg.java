package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;

public class ErrMsg implements Cloneable, Parcelable {
    public static final Parcelable.Creator<ErrMsg> CREATOR = new Parcelable.Creator<ErrMsg>() { // from class: oicq.wlogin_sdk.tools.ErrMsg.1
        @Override // android.os.Parcelable.Creator
        public ErrMsg createFromParcel(Parcel parcel) {
            return new ErrMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ErrMsg[] newArray(int i2) {
            return new ErrMsg[i2];
        }
    };
    private String message;
    private String otherinfo;
    private String title;
    private int type;
    private int version;

    public ErrMsg() {
        this.version = 0;
        this.type = 0;
        //this.title = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_0);
        //this.message = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_1);
        this.otherinfo = "";
    }

    public ErrMsg(int i2, int i3, String str, String str2, String str3) {
        this.version = i2;
        this.type = i3;
        this.title = str;
        this.message = str2;
        this.otherinfo = str3;
    }

    private ErrMsg(Parcel parcel) {
        readFromParcel(parcel);
    }

    public Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOtherinfo() {
        return this.otherinfo;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void readFromParcel(Parcel parcel) {
        this.version = parcel.readInt();
        this.type = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.otherinfo = parcel.readString();
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOtherinfo(String str) {
        this.otherinfo = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int i2 = this.version;
        sb.append(i2 < 0 ? Integer.valueOf(i2) : Integer.toString(i2));
        sb.append(")(");
        int i3 = this.type;
        sb.append(i3 < 0 ? Integer.valueOf(i3) : Integer.toString(i3));
        sb.append(")[");
        String sb2 = sb.toString();
        return sb2 + this.title + "]" + this.message + "[" + this.otherinfo + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.version);
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.otherinfo);
    }
}
