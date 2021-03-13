package me.zhiyao.dress.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.zhiyao.dress.constant.OrderBy
import me.zhiyao.dress.data.repo.SettingRepository
import javax.inject.Inject

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingRepository: SettingRepository
) : ViewModel() {

    val sortOrder = settingRepository.sortOrder.asLiveData()

    fun setSortOrder(@OrderBy sortOrder: Int) {
        viewModelScope.launch {
            settingRepository.setSortOrder(sortOrder)
        }
    }
}