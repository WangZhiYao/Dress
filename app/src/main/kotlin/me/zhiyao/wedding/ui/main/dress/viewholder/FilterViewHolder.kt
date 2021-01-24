package me.zhiyao.wedding.ui.main.dress.viewholder

import androidx.recyclerview.widget.RecyclerView
import me.zhiyao.wedding.data.db.entity.FilterItem
import me.zhiyao.wedding.databinding.ItemDressFilterBinding

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
class FilterViewHolder(private val binding: ItemDressFilterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(filter: FilterItem.Title) {
        binding.tvDressFilter.text = filter.filter.name
    }
}