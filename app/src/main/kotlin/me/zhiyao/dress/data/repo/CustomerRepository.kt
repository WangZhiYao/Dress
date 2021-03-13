package me.zhiyao.dress.data.repo

import me.zhiyao.dress.data.db.dao.CustomerDao
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */

class CustomerRepository @Inject constructor(
    private val customerDao: CustomerDao
)