package me.zhiyao.wedding.ui.main.dress

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.model.DressWithImageAndFilter
import me.zhiyao.wedding.data.repo.DressRepository
import me.zhiyao.wedding.data.repo.FilterRepository


class DressViewModel @ViewModelInject constructor(
    private val dressRepository: DressRepository,
    private val filterRepository: FilterRepository
) : ViewModel() {

    fun getAllDress(
        field: String,
        @OrderBy orderBy: Int
    ): LiveData<PagingData<DressWithImageAndFilter>> =
        dressRepository.getAllDress(field, orderBy)
            .cachedIn(viewModelScope)
            .asLiveData()

    fun getAllDress(
        filterOptionIdList: List<Long>,
        field: String,
        @OrderBy orderBy: Int
    ): LiveData<PagingData<DressWithImageAndFilter>> =
        dressRepository.getAllDress(filterOptionIdList, field, orderBy)
            .cachedIn(viewModelScope)
            .asLiveData()

    val allFilterWithFilterOptionList =
        filterRepository.queryAllFilterWithFilterOptionList()
            .asLiveData()
}