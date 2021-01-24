package me.zhiyao.wedding.ui.main.dress.listener

import me.zhiyao.wedding.data.model.DressWithImageAndFilter

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
interface OnDressClickListener {

    fun onDressClicked(dress: DressWithImageAndFilter)

    fun onReserveClicked(dress: DressWithImageAndFilter)
}