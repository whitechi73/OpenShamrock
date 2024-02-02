package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IGProFetchTopFeedsCallback {
    void onResult(int code, String msg, ArrayList<GProTopFeed> feeds);
}
