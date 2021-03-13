package me.zhiyao.dress.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import me.zhiyao.dress.constant.OrderBy
import me.zhiyao.dress.data.db.entity.DressWithImagesAndFilterOption
import me.zhiyao.dress.data.db.model.Dress

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Dao
interface DressDao : IDao<Dress> {

    @Query(
        "SELECT * FROM dress"
    )
    @Transaction
    fun queryAllDress(): Flow<List<Dress>>

    @Query(
        "SELECT * FROM dress ORDER BY " +
                "CASE WHEN :orderBy = 1 THEN create_time END ASC, " +
                "CASE WHEN :orderBy = 2 THEN create_time END DESC, " +
                "CASE WHEN :orderBy = 3 THEN origin_price END ASC, " +
                "CASE WHEN :orderBy = 4 THEN origin_price END DESC, " +
                "CASE WHEN :orderBy = 5 THEN rent END ASC, " +
                "CASE WHEN :orderBy = 6 THEN rent END DESC"
    )
    @Transaction
    fun queryAllDress(@OrderBy orderBy: Int): PagingSource<Int, DressWithImagesAndFilterOption>

    @Query(
        "SELECT * FROM dress WHERE dress_id IN " +
                "(SELECT dress_id from dress_filter_option_relation WHERE filter_option_id IN (:filterOptionIdList)) " +
                "ORDER BY " +
                "CASE WHEN :orderBy = 1 THEN create_time END ASC, " +
                "CASE WHEN :orderBy = 2 THEN create_time END DESC, " +
                "CASE WHEN :orderBy = 3 THEN origin_price END ASC, " +
                "CASE WHEN :orderBy = 4 THEN origin_price END DESC, " +
                "CASE WHEN :orderBy = 5 THEN rent END ASC, " +
                "CASE WHEN :orderBy = 6 THEN rent END DESC"
    )
    @Transaction
    fun queryAllDress(
        filterOptionIdList: List<Long>,
        @OrderBy orderBy: Int
    ): PagingSource<Int, DressWithImagesAndFilterOption>
}