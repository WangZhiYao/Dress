package me.zhiyao.dress.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import me.zhiyao.dress.data.db.entity.FilterWithFilterOptions
import me.zhiyao.dress.data.db.model.Filter

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
@Dao
interface FilterDao : IDao<Filter> {

    @Query("SELECT * FROM filter")
    fun queryAllFilter(): Flow<List<Filter>>

    @Query("SELECT * FROM filter")
    @Transaction
    fun queryAllFilterWithFilterOptionList(): Flow<List<FilterWithFilterOptions>>
}