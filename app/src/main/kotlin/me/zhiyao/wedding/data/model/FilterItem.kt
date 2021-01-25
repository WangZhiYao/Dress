package me.zhiyao.wedding.data.model

import me.zhiyao.wedding.data.db.model.Filter
import me.zhiyao.wedding.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
sealed class FilterItem {

    data class Title(val filter: Filter) : FilterItem()

    data class Option(val filterOption: FilterOption) : FilterItem()
}