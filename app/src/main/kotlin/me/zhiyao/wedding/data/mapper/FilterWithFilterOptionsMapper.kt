package me.zhiyao.wedding.data.mapper

import me.zhiyao.wedding.data.db.entity.FilterItem
import me.zhiyao.wedding.data.db.entity.FilterWithFilterOptions

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
class FilterWithFilterOptionsMapper : IMapper<List<FilterWithFilterOptions>, List<FilterItem>> {

    override fun apply(input: List<FilterWithFilterOptions>): List<FilterItem> {
        val filterItemList = ArrayList<FilterItem>()
        input.forEach { filterWithFilterOptions ->
            filterItemList.add(FilterItem.Title(filterWithFilterOptions.filter))
            filterWithFilterOptions.filterOptionList.forEach { filterOption ->
                filterItemList.add(FilterItem.Option(filterOption))
            }
        }

        return filterItemList
    }
}