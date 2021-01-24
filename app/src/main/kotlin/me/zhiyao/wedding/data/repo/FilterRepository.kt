package me.zhiyao.wedding.data.repo

import kotlinx.coroutines.flow.map
import me.zhiyao.wedding.data.db.dao.FilterDao
import me.zhiyao.wedding.data.db.dao.FilterOptionDao
import me.zhiyao.wedding.data.mapper.FilterWithFilterOptionsMapper

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
class FilterRepository(
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