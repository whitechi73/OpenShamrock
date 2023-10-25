package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public interface IGProClientIdentityBytes extends Serializable {
    int getClientId();

    ArrayList<Object> getIdentityList();

    String toString();
}