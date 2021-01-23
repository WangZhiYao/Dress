package me.zhiyao.wedding.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.db.entity.DressWithImagesAndFilterOption
import me.zhiyao.wedding.data.db.model.Dress

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Dao
interface DressDao : IDao<Dress> {

    @Query(
        "SELECT * FROM dress ORDER BY " +
                "CASE WHEN :field = 'createTime' AND :orderBy = 1 THEN create_time END ASC, " +
                "CASE WHEN :field = 'createTime' AND :orderBy = 2 THEN create_time END DESC, " +
                "CASE WHEN :field = 'originPrice' AND :orderBy = 1 THEN origin_price END ASC, " +
                "CASE WHEN :field = 'originPrice' AND :orderBy = 2 THEN origin_price END DESC, " +
                "CASE WHEN :field = 'rent' AND :orderBy = 1 THEN rent END ASC, " +
                "CASE WHEN :field = 'rent' AND :orderBy = 2 THEN rent END DESC"
    )
    @Transaction
    fun queryAllDressOrderBy(
        field: String,
        @OrderBy orderBy: Int
    ): PagingSource<Int, DressWithImagesAndFilterOption>
}