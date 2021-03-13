package me.zhiyao.dress.data.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import me.zhiyao.dress.data.db.model.FilterOption
import me.zhiyao.dress.data.db.model.relation.DressFilterOptionRelation

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
data class DressWithImagesAndFilterOption(
    @Embedded
    val dress: DressWithImages,
    @Relation(
        parentColumn = "dress_id",
        entityColumn = "filter_option_id",
        entity = FilterOption::class,
        associateBy = Junction(DressFilterOptionRelation::class)
    )
    val filterOptionWithFilterList: List<FilterOptionWithFilter>
)