package mqq.manager;

import android.content.Context;

import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;

public interface TicketManager extends Manager {
    String getA2(String uin);

    byte[] getDA2(String uin);

    Ticket getLocalTicket(String uin, int id);

    String getOpenSdkKey(String uin, int i2);

    String getPskey(String uin, String domain);

    Ticket getPskey(String str, long j2, String[] strArr, WtTicketPromise wtTicketPromise);

    String getPt4Token(String uin, String domain);

    String getSkey(String uin); // 假的Skey

    String getRealSkey(String uin);

    //Ticket getPskey(String uin, long j2, String[] strArr, WtTicketPromise wtTicketPromise);

    //Ticket getPskeyForOpen(String uin, long j2, String[] strArr, byte[] bArr, WtTicketPromise wtTicketPromise);

    //void getPskeyIgnoreCache(String uin, long j2, String[] strArr, WtTicketPromise wtTicketPromise);

    //Ticket getSkey(String str, long j2, WtTicketPromise wtTicketPromise);

    byte[] getSt(String uin, int appid);

    byte[] getStkey(String uin, int appid);

    String getStweb(String uin);

    String getSuperkey(String str);

    //Ticket getTicket(String str, long j2, int i2, WtTicketPromise wtTicketPromise, Bundle bundle);

    String getVkey(String str);

    //void registTicketManagerListener(TicketManagerListener ticketManagerListener);

    void reloadCache(Context context);

    int sendRPCData(long j2, String str, String str2, byte[] bArr, int i2);

    //void setAlterTicket(HashMap<String, String> hashMap);

    //void setPskeyManager(IPskeyManager iPskeyManager);

    //void unregistTicketManagerListener(TicketManagerListener ticketManagerListener);
}
