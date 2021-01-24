package me.zhiyao.wedding.ui.main.dress.viewholder

import androidx.recyclerview.widget.RecyclerView
import me.zhiyao.wedding.data.db.entity.FilterItem
import me.zhiyao.wedding.databinding.ItemDressFilterOptionBinding

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
class FilterOptionViewHolder(private val binding: ItemDressFilterOptionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        filterOption: FilterItem.Option,
        selected: Boolean,
        onFilterOptionCheckedListener: (Boolean) -> Unit
    ) {
        binding.cbDressFilterOption.text = filterOption.filterOption.name
        binding.cbDressFilterOption.isChecked = selected
        binding.cbDressFilterOption.setOnCheckedChangeListener { _, isChecked ->
            onFilterOptionCheckedListener(isChecked)
        }
    }
}