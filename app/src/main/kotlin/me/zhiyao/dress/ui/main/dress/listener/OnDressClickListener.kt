package me.zhiyao.dress.ui.main.dress.listener

import me.zhiyao.dress.data.model.DressItem

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
interface OnDressClickListener {

    fun onDressClicked(dress: DressItem)

    fun onReserveClicked(dress: DressItem)
}