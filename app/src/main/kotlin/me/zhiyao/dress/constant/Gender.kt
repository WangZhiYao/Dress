package me.zhiyao.dress.constant

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
enum class Gender(val id: Int) {

    FEMALE(0),

    MALE(1);

    companion object {
        fun getById(id: Int): Gender? {
            for (value in values()) {
                if (value.id == id) {
                    return value
                }
            }

            return null
        }
    }
}