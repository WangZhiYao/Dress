package me.zhiyao.dress.ui.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 *
 * @author WangZhiYao
 * @date 2021/1/22
 */
abstract class BaseFragment(@LayoutRes private val resId: Int) : Fragment(resId)