package me.zhiyao.wedding.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import me.zhiyao.wedding.data.db.entity.DressWithFilterOption
import me.zhiyao.wedding.data.db.model.Dress

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@Dao
interface DressDao : IDao<Dress> {

    @Query("SELECT * FROM dress")
    @Transaction
    fun queryAllDress(): PagingSource<Int, DressWithFilterOption>

    @Query(
        "SELECT * FROM dress ORDER BY " +
                "CASE WHEN :param = 1 THEN origin_price END ASC, " +
                "CASE WHEN :param = 2 THEN origin_price END DESC, " +
                "CASE WHEN :param = 3 THEN rent END ASC, " +
                "CASE WHEN :param = 4 THEN rent END DESC"
    )
    @Transaction
    fun queryAllDressOrderBy(param: Int): PagingSource<Int, DressWithFilterOption>
}