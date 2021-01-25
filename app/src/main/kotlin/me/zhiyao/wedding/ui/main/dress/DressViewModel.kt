package me.zhiyao.wedding.ui.main.dress

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.model.DressItem
import me.zhiyao.wedding.data.repo.DressRepository
import me.zhiyao.wedding.data.repo.FilterRepository
import me.zhiyao.wedding.data.repo.SettingRepository


class DressViewModel @ViewModelInject constructor(
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