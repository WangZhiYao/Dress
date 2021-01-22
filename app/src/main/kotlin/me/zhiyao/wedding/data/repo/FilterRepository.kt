package me.zhiyao.wedding.data.repo

import me.zhiyao.wedding.data.db.dao.FilterDao
import me.zhiyao.wedding.data.db.dao.FilterOptionDao

/**
 *
 * @author WangZhiYao
 * @date 2021/1/19
 */
class FilterRepository(
    private val filterDao: FilterDao,
    private val filterOptionDao: FilterOptionDao
) {

    fun queryAllFilter() = filterDao.queryAllFilter()

}