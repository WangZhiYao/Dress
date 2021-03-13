package me.zhiyao.dress.data.db.model.relation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import me.zhiyao.dress.data.db.model.Dress
import me.zhiyao.dress.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
@Entity(
    tableName = "dress_filter_option_relation",
    primaryKeys = [
        "dress_id",
        "filter_option_id"
    ],
    foreignKeys = [
        ForeignKey(
            entity = Dress::class,
            parentColumns = ["dress_id"],
            childColumns = ["dress_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FilterOption::class,
            parentColumns = ["filter_option_id"],
            childColumns = ["filter_option_id"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class DressFilterOptionRelation(
    @ColumnInfo(name = "dress_id", index = true)
    val dressId: Long,
    @ColumnInfo(name = "filter_option_id", index = true)
    val filterOptionId: Long
)