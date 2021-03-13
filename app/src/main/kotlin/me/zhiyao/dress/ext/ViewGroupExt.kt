package me.zhiyao.dress.ext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 *
 * @author WangZhiYao
 * @date 2021/1/24
 */
inline fun <T : ViewBinding> ViewGroup.viewBinding(
    crossinline viewBindingFactory: (LayoutInflater, ViewGroup, Boolean) -> T,
    attachToParent: Boolean = false
) =
    viewBindingFactory.invoke(LayoutInflater.from(context), this, attachToParent)