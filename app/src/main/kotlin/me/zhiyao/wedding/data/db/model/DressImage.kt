package me.zhiyao.wedding.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
@Entity(tableName = "image")
data class DressImage(

    /**
     * 礼服Id
     */
    @ColumnInfo(name = "dress_id")
    val dressId: Long,

    /**
     * 图片路径
     */
    val path: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "image_id")
    var id: Long = 0
}