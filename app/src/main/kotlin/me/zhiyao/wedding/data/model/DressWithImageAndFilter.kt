package me.zhiyao.wedding.data.model

import me.zhiyao.wedding.data.db.entity.FilterWithFilterOptions
import me.zhiyao.wedding.data.db.model.Dress
import me.zhiyao.wedding.data.db.model.DressImage

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
data class DressWithImageAndFilter(
    val dress: Dress,
    val imageList: List<DressImage>,
    val filterList: List<FilterWithFilterOptions>
)