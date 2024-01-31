package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendH5GameChannel {
    GProRecommendCoverInfo cover;
    GProRecommendH5Game data;

    public GProRecommendH5GameChannel() {
        this.data = new GProRecommendH5Game();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProRecommendH5Game getData() {
        return this.data;
    }

    public String toString() {
        return "GProRecommendH5GameChannel{data=" + this.data + ",cover=" + this.cover + ",}";
    }

    public GProRecommendH5GameChannel(GProRecommendH5Game gProRecommendH5Game, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.data = new GProRecommendH5Game();
        this.cover = new GProRecommendCoverInfo();
        this.data = gProRecommendH5Game;
        this.cover = gProRecommendCoverInfo;
    }
}
