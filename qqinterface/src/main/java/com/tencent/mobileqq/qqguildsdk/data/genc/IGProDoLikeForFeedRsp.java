package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProDoLikeForFeedRsp extends Serializable {
    IGProFDLStCommonExt getExtInfo();

    IGProFDLStLike getLike();

    String toString();
}
