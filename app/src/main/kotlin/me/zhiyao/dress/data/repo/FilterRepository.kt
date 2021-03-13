package me.zhiyao.dress.data.repo

import kotlinx.coroutines.flow.map
import me.zhiyao.dress.data.db.dao.FilterDao
import me.zhiyao.dress.data.db.dao.FilterOptionDao
import me.zhiyao.dress.data.mapper.FilterWithFilterOptionsMapper
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
class FilterRepository @Inject constructor(
    private val filterDao: FilterDao,
    private val filterOptionDao: FilterOptionDao,
    private val filterMapper: FilterWithFilterOptionsMapper
) {

    fun queryAllFilter() = filterDao.queryAllFilter()

    fun queryAllFilterWithFilterOptionList() = filterDao.queryAllFilterWithFilterOptionList()
        .map {
            filterMapper.apply(it)
        }
}