@file:OptIn(DelicateCoroutinesApi::class)

package moe.fuqiuluo.shamrock.remote.service.listener

import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo
import com.tencent.qqnt.kernel.nativeinterface.DataSource
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMaskInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moe.fuqiuluo.qqinterface.servlet.GroupSvc
import moe.fuqiuluo.shamrock.helper.LogCenter
import java.util.ArrayList
import java.util.HashMap

internal object GroupEventListener: IKernelGroupListener {
    override fun onGetGroupBulletinListResult(
        j2: Long,
        str: String?,
        groupBulletinListResult: GroupBulletinListResult?
    ) {
        LogCenter.log("onGetGroupBulletinListResult($j2, $str, $groupBulletinListResult)")
    }

    override fun onGroupAvatarUrlChange(j2: Long, str: String?) {
        LogCenter.log("onGroupAvatarUrlChange($j2, $str)")
    }

    override fun onGroupBulletinChange(j2: Long, groupBulletin: GroupBulletin?) {
        LogCenter.log("onGroupBulletinChange($j2, $groupBulletin)")
    }

    override fun onGroupBulletinRichMediaDownloadComplete(bulletinFeedsDownloadInfo: BulletinFeedsDownloadInfo?) {
        LogCenter.log("onGroupBulletinRichMediaDownloadComplete($bulletinFeedsDownloadInfo)")
    }

    override fun onGroupBulletinRichMediaProgressUpdate(bulletinFeedsDownloadInfo: BulletinFeedsDownloadInfo?) {
        LogCenter.log("onGroupBulletinRichMediaProgressUpdate($bulletinFeedsDownloadInfo)")
    }

    override fun onGroupConfMemberChange(j2: Long, arrayList: ArrayList<String>?) {
        LogCenter.log("onGroupConfMemberChange($j2, $arrayList)")
    }

    override fun onGroupDetailInfoChange(groupDetailInfo: GroupDetailInfo?) {
        LogCenter.log("onGroupDetailInfoChange($groupDetailInfo)")
    }

    override fun onGroupListUpdate(
        groupListUpdateType: GroupListUpdateType?,
        arrayList: ArrayList<GroupSimpleInfo>?
    ) {
        LogCenter.log("onGroupListUpdate($groupListUpdateType, $arrayList)")
    }

    override fun onGroupNotifiesUnreadCountUpdated(z: Boolean, j2: Long, i2: Int) {
        LogCenter.log("onGroupNotifiesUnreadCountUpdated($z, $j2, $i2)")
    }

    override fun onGroupNotifiesUpdated(z: Boolean, arrayList: ArrayList<GroupNotifyMsg>?) {
        LogCenter.log("onGroupNotifiesUpdated($z, $arrayList)")
    }

    override fun onGroupPortraitChange(
        j2: Long,
        arrayList: ArrayList<String>?,
        arrayList2: ArrayList<String>?
    ) {
        LogCenter.log("onGroupPortraitChange($j2, $arrayList, $arrayList2)")
    }

    override fun onGroupSingleScreenNotifies(
        z: Boolean,
        j2: Long,
        arrayList: ArrayList<GroupNotifyMsg>?
    ) {
        LogCenter.log("onGroupSingleScreenNotifies($z, $j2, $arrayList)")
    }

    override fun onGroupStatisticInfoChange(j2: Long, groupStatisticInfo: GroupStatisticInfo?) {
        LogCenter.log("onGroupStatisticInfoChange($j2, $groupStatisticInfo)")
    }

    override fun onGroupsMsgMaskResult(arrayList: ArrayList<GroupMsgMaskInfo>?) {
        LogCenter.log("onGroupsMsgMaskResult($arrayList)")
    }

    override fun onJoinGroupNotify(joinGroupNotifyMsg: JoinGroupNotifyMsg?) {
        LogCenter.log("onJoinGroupNotify($joinGroupNotifyMsg)")
    }

    override fun onMemberInfoChange(
        groupCode: Long,
        dataSource: DataSource,
        hashMap: HashMap<String, MemberInfo>
    ) {
        /*GlobalScope.launch {
            hashMap.values.forEach { memberInfo ->
                GroupSvc.getTroopMemberInfoByUid(groupCode, memberInfo.uid).onSuccess {
                    LogCenter.log("onMemberInfoChange($groupCode, $dataSource, $it, $memberInfo)")
                }.onFailure {
                    LogCenter.log("onMemberInfoChange($groupCode, $dataSource, $it, $memberInfo)")
                }
            }
        }*/
    }

    override fun onMemberListChange(groupMemberListChangeInfo: GroupMemberListChangeInfo?) {
        LogCenter.log("onMemberListChange($groupMemberListChangeInfo)")
    }

    override fun onSearchMemberChange(
        str: String?,
        str2: String?,
        arrayList: ArrayList<GroupMemberInfoListId>?,
        hashMap: HashMap<String, MemberInfo>?
    ) {
        LogCenter.log("onSearchMemberChange($str, $str2, $arrayList, $hashMap)")
    }

    override fun onShutUpMemberListChanged(j2: Long, arrayList: ArrayList<MemberInfo>?) {
        LogCenter.log("onShutUpMemberListChanged($j2, $arrayList)")
    }
}