package me.zhiyao.wedding.ui.main.dress.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import me.zhiyao.wedding.GlideApp
import me.zhiyao.wedding.R
import me.zhiyao.wedding.data.model.DressWithImageAndFilter
import me.zhiyao.wedding.databinding.ItemDressBinding
import me.zhiyao.wedding.ui.main.dress.listener.OnDressClickListener
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

    fun bind(
        dressWithImageAndFilter: DressWithImageAndFilter,
        onDressClickListener: OnDressClickListener
    ) {

        val imageList = dressWithImageAndFilter.imageList
        if (imageList.isEmpty()) {
            binding.ivDressImage.visibility = View.GONE
            binding.tvDressImageCount.visibility = View.GONE
        } else {
            binding.ivDressImage.visibility = View.VISIBLE
            val coverImage = imageList.find { it.cover } ?: imageList[0]
            GlideApp.with(binding.ivDressImage)
                .load(coverImage.path)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivDressImage)
            if (imageList.size > 1) {
                binding.tvDressImageCount.run {
                    visibility = View.VISIBLE
                    text = context.getString(
                        R.string.dress_image_count_placeholder,
                        imageList.size - 1
                    )
                }
            }
        }

        val dress = dressWithImageAndFilter.dress
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

        binding.cvDress.setOnClickListener {
            onDressClickListener.onDressClicked(dressWithImageAndFilter)
        }

        binding.btnDressReserve.setOnClickListener {
            onDressClickListener.onReserveClicked(dressWithImageAndFilter)
        }
    }
}