package qq.service.contact

import com.tencent.common.app.AppInterface
import com.tencent.mobileqq.data.Card
import com.tencent.mobileqq.profilecard.api.IProfileDataService
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import moe.fuqiuluo.shamrock.internals.NTServiceFetcher
import qq.service.QQInterfaces
import kotlin.coroutines.resume

object ContactHelper: QQInterfaces() {
    private val refreshCardLock by lazy { Mutex() }

    suspend fun getProfileCard(uin: Long): Result<Card> {
        return getProfileCardFromCache(uin).onFailure {
            return refreshAndGetProfileCard(uin)
        }
    }

    fun getProfileCardFromCache(uin: Long): Result<Card> {
        val profileDataService = app
            .getRuntimeService(IProfileDataService::class.java, "all")
        val card = profileDataService.getProfileCard(uin.toString(), true)
        return if (card == null || card.strNick.isNullOrEmpty()) {
            Result.failure(Exception("unable to fetch profile card"))
        } else {
            Result.success(card)
        }
    }

    suspend fun refreshAndGetProfileCard(uin: Long): Result<Card> {
        require(app is AppInterface)
        val dataService = app
            .getRuntimeService(IProfileDataService::class.java, "all")
        val card = refreshCardLock.withLock {
            suspendCancellableCoroutine {
                app.addObserver(object: ProfileCardObserver() {
                    override fun onGetProfileCard(success: Boolean, obj: Any) {
                        app.removeObserver(this)
                        if (!success || obj !is Card) {
                            it.resume(null)
                        } else {
                            dataService.saveProfileCard(obj)
                            it.resume(obj)
                        }
                    }
                })
                app.getRuntimeService(IProfileProtocolService::class.java, "all")
                    .requestProfileCard(app.currentUin, uin.toString(), 12, 0L, 0.toByte(), 0L, 0L, null, "", 0L, 10004, null, 0.toByte())
            }
        }
        return if (card == null || card.strNick.isNullOrEmpty()) {
            Result.failure(Exception("unable to fetch profile card"))
        } else {
            Result.success(card)
        }
    }

    suspend fun getUinByUidAsync(uid: String): String {
        if (uid.isBlank() || uid == "0") {
            return "0"
        }

        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession

        return suspendCancellableCoroutine { continuation ->
            sessionService.uixConvertService.getUin(hashSetOf(uid)) {
                continuation.resume(it)
            }
        }[uid]?.toString() ?: "0"
    }

    suspend fun getUidByUinAsync(peerId: Long): String {
        val kernelService = NTServiceFetcher.kernelService
        val sessionService = kernelService.wrapperSession
        return suspendCancellableCoroutine { continuation ->
            sessionService.uixConvertService.getUid(hashSetOf(peerId)) {
                continuation.resume(it)
            }
        }[peerId]!!
    }
}