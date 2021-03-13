package me.zhiyao.dress.data.db.entity

import me.zhiyao.dress.data.db.model.Filter
import me.zhiyao.dress.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
sealed class FilterItem {

    data class Title(val filter: Filter) : FilterItem()

    data class Option(val filterOption: FilterOption) : FilterItem()
}