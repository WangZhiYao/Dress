package me.zhiyao.wedding.data.repo

import me.zhiyao.wedding.data.db.dao.CustomerDao

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */

class CustomerRepository(
    private val customerDao: CustomerDao
)