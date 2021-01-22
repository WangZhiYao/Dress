package me.zhiyao.wedding.data.mapper

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
interface IMapper<I, O> {

    fun apply(input: I): O
}