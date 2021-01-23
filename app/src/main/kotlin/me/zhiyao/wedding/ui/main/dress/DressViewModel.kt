package me.zhiyao.wedding.ui.main.dress

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.model.DressWithFilter
import me.zhiyao.wedding.data.repo.DressRepository


class DressViewModel @ViewModelInject constructor(
    private val dressRepository: DressRepository
) : ViewModel() {

    fun getAllDressOrderBy(
        field: String,
        @OrderBy orderBy: Int
    ): LiveData<PagingData<DressWithFilter>> =
        dressRepository.getAllDressOrderBy(field, orderBy)
            .cachedIn(viewModelScope)
            .asLiveData()
}