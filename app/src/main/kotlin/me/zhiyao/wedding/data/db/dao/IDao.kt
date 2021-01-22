package me.zhiyao.wedding.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
interface IDao<T> {

    @Insert
    suspend fun insert(arg: T): Long

    @Insert
    suspend fun insertBatch(arg: List<T>)

    @Update
    suspend fun update(arg: T)

    @Delete
    suspend fun delete(arg: T)

    @Delete
    suspend fun deleteBatch(arg: List<T>)
}