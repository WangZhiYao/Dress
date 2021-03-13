package me.zhiyao.dress.constant

import androidx.annotation.IntDef

/**
 *
 * @author WangZhiYao
 * @date 2021/1/22
 */
@IntDef(
    OrderBy.CREATE_TIME_ASC,
    OrderBy.CREATE_TIME_DESC,
    OrderBy.ORIGIN_PRICE_ASC,
    OrderBy.ORIGIN_PRICE_DESC,
    OrderBy.RENT_ASC,
    OrderBy.RENT_DESC
)
@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.SOURCE)
annotation class OrderBy {

    companion object {

        const val CREATE_TIME_ASC = 1

        const val CREATE_TIME_DESC = 2

        const val ORIGIN_PRICE_ASC = 3

        const val ORIGIN_PRICE_DESC = 4

        const val RENT_ASC = 5

        const val RENT_DESC = 6
    }
}