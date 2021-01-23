package me.zhiyao.wedding.ui.main.dress

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import me.zhiyao.wedding.R
import me.zhiyao.wedding.constant.OrderBy
import me.zhiyao.wedding.data.db.model.Dress
import me.zhiyao.wedding.databinding.FragmentDressBinding
import me.zhiyao.wedding.ui.base.BaseFragment
import me.zhiyao.wedding.ui.main.dress.adapter.DressAdapter

@AndroidEntryPoint
class DressFragment : BaseFragment(R.layout.fragment_dress) {

    private val viewModel by viewModels<DressViewModel>()

    private var _binding: FragmentDressBinding? = null
    private val binding get() = _binding!!

    private lateinit var dressAdapter: DressAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDressBinding.bind(view)

        initView()
        initData()
    }

    private fun initView() {
        setHasOptionsMenu(true)

        dressAdapter = DressAdapter()

        binding.rvDress.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDress.adapter = dressAdapter
    }

    private fun initData() {
        getAllDressOrderBy(Dress::createTime.name, OrderBy.DESC)
    }

    private fun getAllDressOrderBy(field: String, @OrderBy orderBy: Int) {
        viewModel.getAllDressOrderBy(field, orderBy)
            .observe(viewLifecycleOwner, { dressWithFilter ->
                viewLifecycleOwner.lifecycleScope.launch {
                    dressAdapter.submitData(dressWithFilter)
                    // FIXME: 2021/1/23 It's not a good idea to use postDelayed
                    //  scrolling to the top after data changes
                    binding.rvDress.postDelayed({
                        binding.rvDress.scrollToPosition(0)
                    }, 100)
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main_dress, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_create_time_asc -> {
                getAllDressOrderBy(Dress::createTime.name, OrderBy.ASC)
                item.isChecked = true
                return true
            }
            R.id.action_sort_create_time_desc -> {
                getAllDressOrderBy(Dress::createTime.name, OrderBy.DESC)
                item.isChecked = true
                return true
            }
            R.id.action_sort_origin_price_asc -> {
                getAllDressOrderBy(Dress::originPrice.name, OrderBy.ASC)
                item.isChecked = true
                return true
            }
            R.id.action_sort_origin_price_desc -> {
                getAllDressOrderBy(Dress::originPrice.name, OrderBy.DESC)
                item.isChecked = true
                return true
            }
            R.id.action_sort_rent_asc -> {
                getAllDressOrderBy(Dress::rent.name, OrderBy.ASC)
                item.isChecked = true
                return true
            }
            R.id.action_sort_rent_desc -> {
                getAllDressOrderBy(Dress::rent.name, OrderBy.DESC)
                item.isChecked = true
                return true
            }
        }
        return false
    }

    override fun onDestroyView() {
        binding.rvDress.adapter = null
        _binding = null
        super.onDestroyView()
    }
}