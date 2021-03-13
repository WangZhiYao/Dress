package me.zhiyao.dress.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
@Entity(tableName = "rental_record")
data class RentalRecord(

    /**
     * 客户Id
     */
    @ColumnInfo(name = "customer_id")
    val customerId: Long,

    /**
     * 婚纱Id
     */
    @ColumnInfo(name = "dress_id")
    val dressId: Long,

    /**
     * 开始租赁时间
     */
    @ColumnInfo(name = "start_time")
    var startTime: Long,

    /**
     * 结束租赁时间
     */
    @ColumnInfo(name = "end_time")
    var endTime: Long,

    /**
     * 创建时间
     */
    @ColumnInfo(name = "create_time")
    val createTime: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rental_record_id")
    var id: Long = 0
}
