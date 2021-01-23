package me.zhiyao.wedding.constant

import androidx.annotation.IntDef

/**
 *
 * @author WangZhiYao
 * @date 2021/1/22
 */
@IntDef(OrderBy.ASC, OrderBy.DESC)
@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.SOURCE)
annotation class OrderBy {

    companion object {

        const val ASC = 1

        const val DESC = 2
    }
}