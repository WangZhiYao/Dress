package me.zhiyao.wedding.ui.main.dress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import me.zhiyao.wedding.data.model.DressWithFilter
import me.zhiyao.wedding.databinding.ItemDressBinding
import me.zhiyao.wedding.ui.main.dress.viewholder.DressViewHolder

/**
 *
 * @author WangZhiYao
 * @date 2021/1/20
 */
class DressAdapter :
    PagingDataAdapter<DressWithFilter, DressViewHolder>(DressComparator) {

    object DressComparator : DiffUtil.ItemCallback<DressWithFilter>() {
        override fun areItemsTheSame(
            oldItem: DressWithFilter,
            newItem: DressWithFilter
        ) =
            oldItem.dress.id == newItem.dress.id

        override fun areContentsTheSame(
            oldItem: DressWithFilter,
            newItem: DressWithFilter
        ) =
            oldItem.dress.id == newItem.dress.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DressViewHolder(
            ItemDressBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DressViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}