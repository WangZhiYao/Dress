package me.zhiyao.dress.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Entity(tableName = "dress")
data class Dress(

    /**
     * 名字 or 编号
     */
    val name: String?,

    /**
     * 原价
     */
    @ColumnInfo(name = "origin_price")
    val originPrice: Long,

    /**
     * 租金
     */
    var rent: Long,

    /**
     * 是否有破损
     */
    var broken: Boolean,

    /**
     * 是否能使用
     */
    var enable: Boolean,

    /**
     * 备注
     */
    var remark: String?,

    /**
     * 创建时间
     */
    @ColumnInfo(name = "create_time")
    val createTime: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dress_id")
    var id: Long = 0
}
