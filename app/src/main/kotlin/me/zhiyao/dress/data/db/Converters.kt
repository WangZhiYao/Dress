package me.zhiyao.dress.data.db

import androidx.room.TypeConverter
import me.zhiyao.dress.constant.Gender

/**
 *
 * @author WangZhiYao
 * @date 2021/1/17
 */
class Converters {

    @TypeConverter
    fun fromGender(gender: Gender): Int = gender.id

    @TypeConverter
    fun toGender(id: Int): Gender? = Gender.getById(id)
}