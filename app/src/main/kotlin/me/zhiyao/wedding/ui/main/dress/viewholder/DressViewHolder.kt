package me.zhiyao.wedding.ui.main.dress.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import me.zhiyao.wedding.data.model.DressWithFilter
import me.zhiyao.wedding.databinding.ItemDressBinding
import java.text.NumberFormat
import java.util.*

/**
 *
 * @author WangZhiYao
 * @date 2021/1/20
 */
class DressViewHolder(
    private val binding: ItemDressBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dressWithFilter: DressWithFilter) {
        val dress = dressWithFilter.dress
        binding.tvDressName.text =
            if (dress.name.isNullOrBlank()) "No.${dress.id}" else dress.name

        if (dress.remark.isNullOrBlank()) {
            binding.tvDressRemark.visibility = View.GONE
        } else {
            binding.tvDressRemark.visibility = View.VISIBLE
            binding.tvDressRemark.text = dress.remark
        }

        val nf = NumberFormat.getCurrencyInstance(Locale.CHINA)
        binding.tvDressOriginPrice.text = nf.format(dress.originPrice / 100)
        binding.tvDressRent.text = nf.format(dress.rent / 100)
    }
}