package me.zhiyao.wedding.ui.setting

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.repo.SettingRepository

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
class SettingViewModel @ViewModelInject constructor(
    private val settingRepository: SettingRepository
) : ViewModel() {

    val sortOrder = settingRepository.sortOrder.asLiveData()

    fun setSortOrder(@OrderBy sortOrder: Int) {
        viewModelScope.launch {
            settingRepository.setSortOrder(sortOrder)
        }
    }
}