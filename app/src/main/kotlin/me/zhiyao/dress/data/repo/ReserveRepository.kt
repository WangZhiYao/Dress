package me.zhiyao.dress.data.repo

import me.zhiyao.dress.data.db.dao.ReserveDao
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */

class ReserveRepository @Inject constructor(
    private val reserveDao: ReserveDao
)