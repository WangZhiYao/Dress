package me.zhiyao.wedding.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation
import me.zhiyao.wedding.data.db.model.Filter
import me.zhiyao.wedding.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/20
 */
data class FilterOptionWithFilter(
    @Embedded
    val filterOption: FilterOption,
    @Relation(
        parentColumn = "filter_id",
        entityColumn = "filter_id"
    )
    val filter: Filter
)