package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildSearchRsp extends Serializable {
    ArrayList<String> getHighlightWords();

    IGProUnionResult getUnionResult();

    String toString();
}
