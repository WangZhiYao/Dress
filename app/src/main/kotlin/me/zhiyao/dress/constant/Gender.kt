package me.zhiyao.dress.constant

import androidx.annotation.IntDef

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
@IntDef(
    Gender.MALE,
    Gender.FEMALE
)
@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.SOURCE)
annotation class Gender {

    companion object {
        const val MALE = 1

        const val FEMALE = 2
    }
}