package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendH5GameChannel extends Serializable {
    IGProRecommendCoverInfo getCover();

    IGProRecommendH5Game getData();

    String toString();
}
