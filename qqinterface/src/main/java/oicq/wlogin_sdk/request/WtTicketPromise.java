package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

public interface WtTicketPromise {
    void Done(Ticket ticket);

    void Failed(ErrMsg errMsg);

    void Timeout(ErrMsg errMsg);
}