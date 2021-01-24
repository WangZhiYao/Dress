package me.zhiyao.wedding.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import kotlinx.coroutines.flow.map
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.db.dao.DressDao
import me.zhiyao.wedding.data.mapper.DressWithFilterMapper

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */

class DressRepository(
    private val dressDao: DressDao,
    private val dressWithFilterMapper: DressWithFilterMapper
) {

    private val pagingConfig = PagingConfig(
        pageSize = 20,
        prefetchDistance = 3,
        initialLoadSize = 20,
        enablePlaceholders = false
    )

    fun getAllDress(field: String, @OrderBy orderBy: Int) = Pager(pagingConfig) {
        dressDao.queryAllDress(field, orderBy)
    }.flow.map { pagingData ->
        pagingData.map { dressWithFilterOption ->
            dressWithFilterMapper.apply(dressWithFilterOption)
        }
    }

    fun getAllDress(filterOptionIdList: List<Long>, field: String, @OrderBy orderBy: Int) =
        Pager(pagingConfig) {
            dressDao.queryAllDress(filterOptionIdList, field, orderBy)
        }.flow.map { pagingData ->
            pagingData.map { dressWithFilterOption ->
                dressWithFilterMapper.apply(dressWithFilterOption)
            }
        }
}