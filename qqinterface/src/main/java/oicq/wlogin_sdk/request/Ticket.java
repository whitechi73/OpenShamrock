package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class Ticket implements Parcelable {
    public static final Parcelable.Creator<Ticket> CREATOR = new Parcelable.Creator<Ticket>() { // from class: oicq.wlogin_sdk.request.Ticket.2
        @Override // android.os.Parcelable.Creator
        public Ticket createFromParcel(Parcel parcel) {
            return new Ticket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Ticket[] newArray(int i2) {
            return new Ticket[i2];
        }
    };
    private static final int EXPIRE_FIELD = 65535;
    private static final int MAX_PSKEY_SIZE = 200;
    public long _create_time;
    public long _expire_time;
    public Map<String, Long> _pskey_expire;
    public HashMap _pskey_map;
    public Map<String, Long> _pt4token_expire;
    public Map<String, byte[]> _pt4token_map;
    public byte[] _sig;
    public byte[] _sig_key;
    public int _type;

    public Ticket() {
    }

    public Ticket(int i2, byte[] bArr, byte[] bArr2, long j2, long j3) {
    }

    public Ticket(int i2, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3) {
    }

    public Ticket(int i2, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3, byte[] bArr4) {
    }

    private Ticket(Parcel parcel) {
        this._pskey_map = new HashMap();
        this._pskey_expire = new HashMap();
        this._pt4token_map = new HashMap();
        this._pt4token_expire = new HashMap();
        readFromParcel(parcel);
    }

    public static int calPsBufLength(Map<String, byte[]> map) {
        int i2 = 2;
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            i2 = i2 + 2 + entry.getKey().length() + 2 + entry.getValue().length + 2 + 8;
        }
        return i2;
    }

    public static boolean isPskeyExpired(long j2) {
        return isTicketExpired(j2);
    }

    public static boolean isPskeyStorageExpired(long j2) {
        //long e2 = u.e();
        //util.LOGI("isPskeyStorageExpired expireTime:" + j2 + "|current: " + e2, "");
        //return e2 > j2 + 86400;
        return false;
    }

    public static boolean isPt4TokenExpired(long j2) {
        return isTicketExpired(j2);
    }

    public static boolean isSkeyExpired(long j2) {
        return isTicketExpired(j2);
    }

    public static boolean isTicketExpired(long j2) {
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return "";
    }

    public String getPSkey(String str) {
        return "";
    }

    public String getPt4Token(String str) {
        return "";
    }

    public void readFromParcel(Parcel parcel) {
        this._type = parcel.readInt();
        this._sig = parcel.createByteArray();
        this._sig_key = parcel.createByteArray();
        this._create_time = parcel.readLong();
        this._expire_time = parcel.readLong();
        this._pskey_map = parcel.readHashMap(Map.class.getClassLoader());
        this._pt4token_map = parcel.readHashMap(Map.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this._type);
        parcel.writeByteArray(this._sig);
        parcel.writeByteArray(this._sig_key);
        parcel.writeLong(this._create_time);
        parcel.writeLong(this._expire_time);
        parcel.writeMap(this._pskey_map);
        parcel.writeMap(this._pt4token_map);
    }
}
