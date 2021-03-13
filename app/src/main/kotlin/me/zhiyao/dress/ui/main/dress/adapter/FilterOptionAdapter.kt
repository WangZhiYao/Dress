package me.zhiyao.dress.ui.main.dress.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.zhiyao.dress.data.db.entity.FilterItem
import me.zhiyao.dress.databinding.ItemDressFilterBinding
import me.zhiyao.dress.databinding.ItemDressFilterEmptyBinding
import me.zhiyao.dress.databinding.ItemDressFilterOptionBinding
import me.zhiyao.dress.ext.viewBinding
import me.zhiyao.dress.ui.main.dress.viewholder.FilterEmptyViewHolder
import me.zhiyao.dress.ui.main.dress.viewholder.FilterOptionViewHolder
import me.zhiyao.dress.ui.main.dress.viewholder.FilterViewHolder

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
class FilterOptionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_FILTER = 1
        private const val VIEW_TYPE_FILTER_OPTION = 2
        private const val VIEW_TYPE_FILTER_EMPTY = 3
    }

    var filterItemList: List<FilterItem>? = null
        set(value) {
            field = value
            selectedFilterOptionIdList.clear()
            notifyDataSetChanged()
        }

    val selectedFilterOptionIdList = ArrayList<Long>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_FILTER -> return FilterViewHolder(
                parent.viewBinding(ItemDressFilterBinding::inflate)
            )
            VIEW_TYPE_FILTER_OPTION -> return FilterOptionViewHolder(
                parent.viewBinding(ItemDressFilterOptionBinding::inflate)
            )
            VIEW_TYPE_FILTER_EMPTY -> return FilterEmptyViewHolder(
                parent.viewBinding(ItemDressFilterEmptyBinding::inflate)
            )
        }

        return FilterEmptyViewHolder(parent.viewBinding(ItemDressFilterEmptyBinding::inflate))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_FILTER -> {
                (holder as FilterViewHolder).bind(filterItemList!![position] as FilterItem.Title)
            }
            VIEW_TYPE_FILTER_OPTION -> {
                val filterOption = filterItemList!![position] as FilterItem.Option
                (holder as FilterOptionViewHolder).bind(
                    filterOption,
                    selectedFilterOptionIdList.contains(filterOption.filterOption.id)
                ) { isChecked ->
                    if (isChecked) {
                        selectedFilterOptionIdList.add(filterOption.filterOption.id)
                    } else {
                        selectedFilterOptionIdList.remove(filterOption.filterOption.id)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        var count = 0

        if (filterItemList.isNullOrEmpty()) {
            count = 1
        } else {
            filterItemList?.run {
                count += size
            }
        }

        return count
    }

    override fun getItemViewType(position: Int): Int {
        if (!filterItemList.isNullOrEmpty()) {
            filterItemList?.let {
                return when (it[position]) {
                    is FilterItem.Title -> VIEW_TYPE_FILTER
                    is FilterItem.Option -> VIEW_TYPE_FILTER_OPTION
                }
            }
        }

        return VIEW_TYPE_FILTER_EMPTY
    }
}