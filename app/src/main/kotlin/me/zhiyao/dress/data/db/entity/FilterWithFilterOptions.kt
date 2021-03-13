package me.zhiyao.dress.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation
import me.zhiyao.dress.data.db.model.Filter
import me.zhiyao.dress.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
data class FilterWithFilterOptions(
    @Embedded
    val filter: Filter,
    @Relation(
        parentColumn = "filter_id",
        entityColumn = "filter_id"
    )
    val filterOptionList: List<FilterOption>
)
