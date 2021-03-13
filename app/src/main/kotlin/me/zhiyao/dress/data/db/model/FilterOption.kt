package me.zhiyao.dress.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
@Entity(
    tableName = "filter_option",
    foreignKeys = [
        ForeignKey(
            entity = Filter::class,
            parentColumns = ["filter_id"],
            childColumns = ["filter_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FilterOption(

    /**
     * 过滤器父类别Id
     */
    @ColumnInfo(name = "filter_id", index = true)
    val filterId: Long,

    /**
     * 过滤器子类别
     */
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "filter_option_id")
    var id: Long = 0
}
