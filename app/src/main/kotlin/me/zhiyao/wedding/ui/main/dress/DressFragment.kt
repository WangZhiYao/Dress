package me.zhiyao.wedding.ui.main.dress

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.list.customListAdapter
import dagger.hilt.android.AndroidEntryPoint
import me.zhiyao.wedding.R
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.model.DressItem
import me.zhiyao.wedding.databinding.FragmentDressBinding
import me.zhiyao.wedding.ui.base.BaseFragment
import me.zhiyao.wedding.ui.main.dress.adapter.DressAdapter
import me.zhiyao.wedding.ui.main.dress.adapter.FilterOptionAdapter
import me.zhiyao.wedding.ui.main.dress.listener.OnDressClickListener

@AndroidEntryPoint
class DressFragment : BaseFragment(R.layout.fragment_dress),
    OnDressClickListener {

    private val viewModel by viewModels<DressViewModel>()

    private var _binding: FragmentDressBinding? = null
    private val binding get() = _binding!!

    private lateinit var dressAdapter: DressAdapter

    private val onDressChangeObserver: Observer<PagingData<DressItem>> =
        Observer { dressItemList ->
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                dressAdapter.submitData(dressItemList)
                // FIXME: 2021/1/23 It's not a good idea to use postDelayed
                //  scrolling to the top after data changes
                binding.rvDress.postDelayed({
                    binding.rvDress.scrollToPosition(0)
                }, 100)
            }
        }

    @OrderBy
    private var currentOrderBy = OrderBy.CREATE_TIME_DESC

    private lateinit var filterOptionAdapter: FilterOptionAdapter

    private var currentSelectedFilterOptionList = ArrayList<Long>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDressBinding.bind(view)

        initView()
        initData()
    }

    private fun initView() {
        setHasOptionsMenu(true)

        dressAdapter = DressAdapter(this)

        binding.rvDress.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDress.adapter = dressAdapter

        filterOptionAdapter = FilterOptionAdapter()

        binding.fabDress.setOnClickListener {
            getAllFilterWithFilterOptionList()
            showFilterDialog()
        }
    }

    private fun initData() {
        getAllDressOrderBy()
    }

    private fun getAllDressOrderBy() {
        if (currentSelectedFilterOptionList.isNullOrEmpty()) {
            viewModel.getAllDress(currentOrderBy)
                .observe(viewLifecycleOwner, onDressChangeObserver)
        } else {
            viewModel.getAllDress(
                currentSelectedFilterOptionList,
                currentOrderBy
            )
                .observe(viewLifecycleOwner, onDressChangeObserver)
        }
    }

    private fun getAllFilterWithFilterOptionList() {
        viewModel.allFilterWithFilterOptionList.observe(viewLifecycleOwner, { filterItemList ->
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                filterOptionAdapter.filterItemList = filterItemList
                filterOptionAdapter.selectedFilterOptionIdList.addAll(
                    currentSelectedFilterOptionList
                )
            }
        })
    }

    override fun onDressClicked(dress: DressItem) {

    }

    override fun onReserveClicked(dress: DressItem) {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main_dress, menu)
        when (currentOrderBy) {
            OrderBy.CREATE_TIME_ASC -> menu[0].subMenu
                .findItem(R.id.action_sort_create_time_asc).isChecked = true
            OrderBy.CREATE_TIME_DESC -> menu[0].subMenu
                .findItem(R.id.action_sort_create_time_desc).isChecked = true
            OrderBy.ORIGIN_PRICE_ASC -> menu[0].subMenu
                .findItem(R.id.action_sort_origin_price_asc).isChecked = true
            OrderBy.ORIGIN_PRICE_DESC -> menu[0].subMenu
                .findItem(R.id.action_sort_origin_price_desc).isChecked = true
            OrderBy.RENT_ASC -> menu[0].subMenu
                .findItem(R.id.action_sort_rent_asc).isChecked = true
            OrderBy.RENT_DESC -> menu[0].subMenu
                .findItem(R.id.action_sort_rent_desc).isChecked = true
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_create_time_asc -> return changeCurrentSort(
                item, OrderBy.CREATE_TIME_ASC
            )
            R.id.action_sort_create_time_desc -> return changeCurrentSort(
                item, OrderBy.CREATE_TIME_DESC
            )
            R.id.action_sort_origin_price_asc -> return changeCurrentSort(
                item, OrderBy.ORIGIN_PRICE_ASC
            )
            R.id.action_sort_origin_price_desc -> return changeCurrentSort(
                item, OrderBy.ORIGIN_PRICE_DESC
            )
            R.id.action_sort_rent_asc -> return changeCurrentSort(
                item, OrderBy.RENT_ASC
            )
            R.id.action_sort_rent_desc -> return changeCurrentSort(
                item, OrderBy.RENT_DESC
            )
        }
        return false
    }

    private fun changeCurrentSort(
        item: MenuItem,
        @OrderBy newSortOrder: Int
    ): Boolean {
        item.isChecked = true
        currentOrderBy = newSortOrder
        getAllDressOrderBy()
        return true
    }

    private fun showFilterDialog() {
        MaterialDialog(requireContext(), BottomSheet()).show {
            title(R.string.dress_filter)
            customListAdapter(filterOptionAdapter)
            positiveButton(R.string.dress_filter_apply) {
                currentSelectedFilterOptionList.clear()
                currentSelectedFilterOptionList.addAll(filterOptionAdapter.selectedFilterOptionIdList)
                getAllDressOrderBy()
            }
            negativeButton(R.string.dress_filter_clear) {
                currentSelectedFilterOptionList.clear()
                getAllDressOrderBy()
            }
        }
    }

    override fun onDestroyView() {
        binding.rvDress.adapter = null
        _binding = null
        super.onDestroyView()
    }
}