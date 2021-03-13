package me.zhiyao.dress.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.zhiyao.dress.constant.Gender

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Entity(tableName = "customer")
data class Customer(
    /**
     * 姓名
     */
    val name: String,

    /**
     * 联系方式
     */
    var contact: String,

    /**
     * 性别
     */
    val gender: Gender?,

    /**
     * 结婚日期
     */
    @ColumnInfo(name = "wedding_day")
    val weddingDay: Long?,

    /**
     * 备注
     */
    var remark: String,

    @ColumnInfo(name = "create_time")
    val createTime: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id")
    var id: Long = 0
}
