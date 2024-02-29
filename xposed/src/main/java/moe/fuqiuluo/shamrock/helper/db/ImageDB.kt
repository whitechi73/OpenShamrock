package moe.fuqiuluo.shamrock.helper.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import mqq.app.MobileQQ


@Entity(tableName = "image_mapping")
data class ImageMapping (
    @PrimaryKey
    val fileName: String,
    val chatType: Int,
    val size: Long,

    val md5: String,
    val sha: String,
    val fileId: String,
    val storeId: Int
)

@Dao
interface ImageMappingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mapping: ImageMapping)

    @Query("SELECT * FROM image_mapping WHERE fileName = :fileName")
    fun queryByFileName(fileName: String): ImageMapping?
}

@Database(entities = [ImageMapping::class], version = 1)
internal abstract class ImageDB: RoomDatabase() {
    abstract fun imageMappingDao(): ImageMappingDao

    companion object {
        private const val DB_NAME = "image_mapping_v2.db"

        @Volatile
        private var instance: ImageDB? = null

        fun getInstance(): ImageDB {
            if (instance == null) {
                synchronized(ImageDB::class) {
                    if (instance == null) {
                        ImageDB
                        instance = Room.databaseBuilder(MobileQQ.getContext(), ImageDB::class.java, DB_NAME).build()
                    }
                }
            }
            return instance!!
        }
    }
}