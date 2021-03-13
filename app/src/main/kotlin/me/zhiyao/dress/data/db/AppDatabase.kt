package me.zhiyao.dress.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.zhiyao.dress.data.db.dao.*
import me.zhiyao.dress.data.db.model.*
import me.zhiyao.dress.data.db.model.relation.DressFilterOptionRelation

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Database(
    entities = [
        Dress::class,
        DressImage::class,
        Customer::class,
        Reserve::class,
        RentalRecord::class,
        Filter::class,
        FilterOption::class,
        DressFilterOptionRelation::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dressDao(): DressDao

    abstract fun dressImageDao(): DressImageDao

    abstract fun customerDao(): CustomerDao

    abstract fun reserveDao(): ReserveDao

    abstract fun rentalRecordDao(): RentalRecordDao

    abstract fun filterDao(): FilterDao

    abstract fun filterOptionDao(): FilterOptionDao

    abstract fun dressFilterOptionDao(): DressFilterOptionRelationDao

}