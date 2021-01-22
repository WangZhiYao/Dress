package me.zhiyao.wedding.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
@Entity(
    tableName = "filter"
)
data class Filter(

    /**
     * 过滤器父类别
     */
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "filter_id")
    var id: Long = 0
}
