package me.zhiyao.dress.ui.main.dress.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.zhiyao.dress.data.model.DressItem
import me.zhiyao.dress.databinding.ItemDressBinding
import me.zhiyao.dress.ext.viewBinding
import me.zhiyao.dress.ui.main.dress.listener.OnDressClickListener
import me.zhiyao.dress.ui.main.dress.viewholder.DressViewHolder

/**
 *
 * @author WangZhiYao
 * @date 2021/1/20
 */
class DressAdapter(private val onDressClickListener: OnDressClickListener) :
    PagingDataAdapter<DressItem, DressViewHolder>(DressComparator) {

    object DressComparator : DiffUtil.ItemCallback<DressItem>() {
        override fun areItemsTheSame(
            oldItem: DressItem,
            newItem: DressItem
        ) =
            oldItem.dress.id == newItem.dress.id

        override fun areContentsTheSame(
            oldItem: DressItem,
            newItem: DressItem
        ) =
            oldItem.dress.id == newItem.dress.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DressViewHolder(parent.viewBinding(ItemDressBinding::inflate))

    override fun onBindViewHolder(holder: DressViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, object : OnDressClickListener {
                override fun onDressClicked(dress: DressItem) {
                    onDressClickListener.onDressClicked(dress)
                }

                override fun onReserveClicked(dress: DressItem) {
                    onDressClickListener.onReserveClicked(dress)
                }
            })
        }
    }
}