package moe.fuqiuluo.shamrock.helper.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import mqq.app.MobileQQ

@Entity(tableName = "message_mapping")
data class MessageMapping (
    @PrimaryKey
    val msgHashId: Int,
    val qqMsgId: Long,
    val chatType: Int, // 主要区分群聊还是私聊
    val subChatType: Int, // 细化各种事件消息
    val peerId: String,
    val time: Long,
    val msgSeq: Int
)

@Dao
interface MessageMappingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mapping: MessageMapping)

    @Query("UPDATE message_mapping SET msgSeq = :msgSeq WHERE msgHashId = :hash")
    fun updateMsgSeqByMsgHash(hash: Int, msgSeq: Int)

    @Query("DELETE FROM message_mapping WHERE msgHashId = :hash")
    fun deleteByMsgHash(hash: Int)

    @Query("SELECT * FROM message_mapping WHERE msgHashId = :msgHashId")
    fun queryByMsgHashId(msgHashId: Int): MessageMapping?

    @Query("SELECT * FROM message_mapping WHERE qqMsgId = :qqMsgId AND chatType = :chatType")
    fun queryByQqMsgId(chatType: Int, qqMsgId: Long): MessageMapping?

    @Query("SELECT * FROM message_mapping WHERE chatType = :chatType")
    fun queryByChatType(chatType: Int): List<MessageMapping>

    @Query("SELECT * FROM message_mapping WHERE subChatType = :subChatType AND chatType = :chatType")
    fun queryBySubChatType(chatType: Int, subChatType: Int): List<MessageMapping>

    @Query("SELECT * FROM message_mapping WHERE peerId = :peerId AND chatType = :chatType")
    fun queryByPeerId(chatType: Int, peerId: String): List<MessageMapping>

    @Query("SELECT * FROM message_mapping WHERE msgSeq = :msgSeq AND chatType = :chatType")
    fun queryByMsgSeq(chatType: Int, msgSeq: Int): MessageMapping?

    @Query("SELECT * FROM message_mapping WHERE msgSeq = :msgSeq AND chatType = :chatType AND peerId = :peerId")
    fun queryByMsgSeq(chatType: Int, peerId: String, msgSeq: Int): MessageMapping?
}

@Database(entities = [MessageMapping::class], version = 1)
internal abstract class MessageDB: RoomDatabase() {
    abstract fun messageMappingDao(): MessageMappingDao

    companion object {
        private const val DB_NAME = "message_mapping.db"

        @Volatile
        private var instance: MessageDB? = null

        fun getInstance(): MessageDB {
            if (instance == null) {
                synchronized(MessageDB::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(MobileQQ.getContext(), MessageDB::class.java, DB_NAME).build()
                    }
                }
            }
            return instance!!
        }
    }
}