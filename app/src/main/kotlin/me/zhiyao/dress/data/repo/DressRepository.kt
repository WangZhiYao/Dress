package me.zhiyao.dress.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import kotlinx.coroutines.flow.map
import me.zhiyao.dress.constant.OrderBy
import me.zhiyao.dress.data.db.dao.DressDao
import me.zhiyao.dress.data.mapper.DressWithFilterMapper
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
class DressRepository @Inject constructor(
    private val dressDao: DressDao,
    private val dressWithFilterMapper: DressWithFilterMapper
) {

    private val pagingConfig = PagingConfig(
        pageSize = 20,
        prefetchDistance = 3,
        initialLoadSize = 20,
        enablePlaceholders = false
    )

    fun getAllDress(@OrderBy orderBy: Int) = Pager(pagingConfig) {
        dressDao.queryAllDress(orderBy)
    }.flow.map { pagingData ->
        pagingData.map { dressWithFilterOption ->
            dressWithFilterMapper.apply(dressWithFilterOption)
        }
    }

    fun getAllDress(filterOptionIdList: List<Long>, @OrderBy orderBy: Int) =
        Pager(pagingConfig) {
            dressDao.queryAllDress(filterOptionIdList, orderBy)
        }.flow.map { pagingData ->
            pagingData.map { dressWithFilterOption ->
                dressWithFilterMapper.apply(dressWithFilterOption)
            }
        }
}