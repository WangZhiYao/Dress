package me.zhiyao.wedding.data.mapper

import me.zhiyao.wedding.data.db.entity.DressWithFilterOption
import me.zhiyao.wedding.data.db.entity.FilterWithFilterOption
import me.zhiyao.wedding.data.db.model.Filter
import me.zhiyao.wedding.data.db.model.FilterOption
import me.zhiyao.wedding.data.model.DressWithFilter

/**
 *
 * @author
 * @date 2021/1/21
 */
class DressWithFilterMapper : IMapper<DressWithFilterOption, DressWithFilter> {

    override fun apply(input: DressWithFilterOption): DressWithFilter {
        val dress = input.dress
        val filterOptionWithFilterList = input.filterOptionWithFilterList

        val filterMap = HashMap<Filter, ArrayList<FilterOption>>()

        filterOptionWithFilterList.forEach {
            val filterOptionList = if (filterMap.containsKey(it.filter)) {
                filterMap[it.filter]!!
            } else {
                ArrayList()
            }
            filterOptionList.add(it.filterOption)
        }

        val filterWithFilterOptionList = ArrayList<FilterWithFilterOption>()

        if (filterMap.isNotEmpty()) {
            filterMap.entries.forEach {
                filterWithFilterOptionList.add(FilterWithFilterOption(it.key, it.value))
            }
        }

        return DressWithFilter(dress, filterWithFilterOptionList)
    }
}