package me.zhiyao.dress.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.zhiyao.dress.data.db.model.FilterOption

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
@Dao
interface FilterOptionDao : IDao<FilterOption> {

    @Query("SELECT * FROM filter_option")
    fun queryAllFilterOption(): Flow<List<FilterOption>>
}