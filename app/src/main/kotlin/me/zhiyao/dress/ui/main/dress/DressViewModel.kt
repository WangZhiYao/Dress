package me.zhiyao.dress.ui.main.dress

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.zhiyao.dress.constant.OrderBy
import me.zhiyao.dress.data.model.DressItem
import me.zhiyao.dress.data.repo.DressRepository
import me.zhiyao.dress.data.repo.FilterRepository
import me.zhiyao.dress.data.repo.SettingRepository
import javax.inject.Inject

@HiltViewModel
class DressViewModel @Inject constructor(
    private val dressRepository: DressRepository,
    private val filterRepository: FilterRepository,
    private val settingRepository: SettingRepository
) : ViewModel() {

    fun getAllDress(
        @OrderBy orderBy: Int
    ): LiveData<PagingData<DressItem>> =
        dressRepository.getAllDress(orderBy)
            .cachedIn(viewModelScope)
            .asLiveData()

    fun getAllDress(
        filterOptionIdList: List<Long>,
        @OrderBy orderBy: Int
    ): LiveData<PagingData<DressItem>> =
        dressRepository.getAllDress(filterOptionIdList, orderBy)
            .cachedIn(viewModelScope)
            .asLiveData()

    val allFilterWithFilterOptionList =
        filterRepository.queryAllFilterWithFilterOptionList()
            .asLiveData()

    val sortOrder = settingRepository.sortOrder.asLiveData()
}