package com.tencent.libra.download;

import androidx.annotation.NonNull;

import com.tencent.libra.request.Option;

public interface ILibraDownloader {
    class PicDownLoadListener {
        Option mOption;

        public PicDownLoadListener(@NonNull Option option) {
            this.mOption = option;
        }

        public void onResult(boolean success, int code) {
        }
    }

    boolean canDownload(Option option);

    void cancel(Option option);

    void downLoad(Option option, PicDownLoadListener picDownLoadListener);

    boolean needDownloadOnWorkThread();
}
