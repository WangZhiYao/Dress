package me.zhiyao.wedding.data.mapper

import me.zhiyao.wedding.data.db.entity.DressWithImagesAndFilterOption
import me.zhiyao.wedding.data.db.entity.FilterWithFilterOptions
import me.zhiyao.wedding.data.db.model.Filter
import me.zhiyao.wedding.data.db.model.FilterOption
import me.zhiyao.wedding.data.model.DressWithImageAndFilter

/**
 *
 * @author
 * @date 2021/1/21
 */
class DressWithFilterMapper : IMapper<DressWithImagesAndFilterOption, DressWithImageAndFilter> {

    override fun apply(input: DressWithImagesAndFilterOption): DressWithImageAndFilter {
        val dress = input.dress.dress
        val imageList = input.dress.imageList
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

        val filterWithFilterOptionList = ArrayList<FilterWithFilterOptions>()

        if (filterMap.isNotEmpty()) {
            filterMap.entries.forEach {
                filterWithFilterOptionList.add(FilterWithFilterOptions(it.key, it.value))
            }
        }

        return DressWithImageAndFilter(dress, imageList, filterWithFilterOptionList)
    }
}