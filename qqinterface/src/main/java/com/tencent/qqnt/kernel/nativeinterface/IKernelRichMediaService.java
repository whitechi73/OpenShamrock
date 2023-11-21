package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public interface IKernelRichMediaService {
    void batchGetGroupFileCount(ArrayList<Long> arrayList, IBatchGroupFileCountCallback iBatchGroupFileCountCallback);

    void cancelSearcheGroupFile(int i2, int i3, String str);

    void cancelTransferTask(Contact contact, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2, IOperateTransferInfoCallback iOperateTransferInfoCallback);

    void deleteGroupFile(long groupCode, String fileUid, int bizId, IDeleteGroupFileCallback cb);

    void deleteTransferInfo(Contact contact, ArrayList<Long> arrayList, IOperateTransferInfoCallback iOperateTransferInfoCallback);

    void downloadFile(CommonFileInfo commonFileInfo, int i2, int i3, String str);

    void downloadFileForFileInfo(ArrayList<CommonFileInfo> arrayList, String str);

    void downloadFileForFileUuid(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

    void downloadFileForModelId(Contact contact, ArrayList<Long> arrayList, String str);

    void downloadRichMediaInVisit(RichDownLoadReq richDownLoadReq);

    void getGroupFileInfo(long j2, String str, IGroupFileInfoCallback iGroupFileInfoCallback);

    int getGroupFileList(long j2, GroupFileListForm groupFileListForm);

    void getGroupSpace(long j2, IGroupSpaceCallback iGroupSpaceCallback);

    int getGroupTransferList(long j2, GroupFileListForm groupFileListForm);

    String getRichMediaFileDir(int i2, int i3, boolean z);

    void getScreenOCR(String str, IWindowsOcrCallback iWindowsOcrCallback);

    void getVideoPlayUrl(Contact contact, long j2, long j3, VideoCodecFormatType videoCodecFormatType, VideoRequestWay videoRequestWay, IVideoPlayUrlCallback iVideoPlayUrlCallback);

    void getVideoPlayUrlInVisit(RichDownLoadReq richDownLoadReq, IVideoPlayUrlCallback iVideoPlayUrlCallback);

    void moveGroupFile(long j2, int i2, String str, String str2, String str3, IMoveGroupFileCallback iMoveGroupFileCallback);

    void onlyDownloadFile(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

    void onlyUploadFile(Contact contact, ArrayList<UploadGroupFileParams> fileParams);

    PicDownParams queryPicDownloadSize(PicReqParams picReqParams);

    void renameGroupFile(long j2, int i2, String str, String str2, String str3, IRenameGroupFileCallback iRenameGroupFileCallback);

    int searchGroupFile(ArrayList<String> arrayList, SearchGroupFileParams searchGroupFileParams, IOperateCallback iOperateCallback);

    void searchGroupFileByWord(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, String str, String str2, int i2, ISearchGroupFileCallback iSearchGroupFileCallback);

    void searchMoreGroupFile(int i2);

    void transGroupFile(long j2, String str, ITransGroupFileCallback iTransGroupFileCallback);

    void translateEnWordToZn(ArrayList<String> arrayList, ITranslateWordsCallback iTranslateWordsCallback);

    void updateOnlineVideoElemStatus(UploadStatusParams uploadStatusParams);
}
