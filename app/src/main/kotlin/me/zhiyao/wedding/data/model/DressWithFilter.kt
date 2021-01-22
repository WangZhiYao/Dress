package me.zhiyao.wedding.data.model

import me.zhiyao.wedding.data.db.entity.FilterWithFilterOption
import me.zhiyao.wedding.data.db.model.Dress

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
data class DressWithFilter(
    val dress: Dress,
    val filterList: List<FilterWithFilterOption>
)