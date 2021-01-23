package me.zhiyao.wedding.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation
import me.zhiyao.wedding.data.db.model.Dress
import me.zhiyao.wedding.data.db.model.DressImage

/**
 *
 * @author WangZhiYao
 * @date 2021/1/23
 */
data class DressWithImages(
    @Embedded
    val dress: Dress,
    @Relation(
        parentColumn = "dress_id",
        entityColumn = "dress_id"
    )
    val imageList: List<DressImage>
)