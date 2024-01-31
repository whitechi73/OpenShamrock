package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetHotSearchWordRsp extends Serializable {
    byte[] getCookies();

    IGProForumBody getForums();

    ArrayList<IGProHotSearchWord> getWords();

    String toString();
}
