package me.zhiyao.wedding.ui.main.dress

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import me.zhiyao.wedding.R
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
        dressAdapter = DressAdapter()
        binding.rvDress.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDress.adapter = dressAdapter
    }

    private fun initData() {
        viewModel.allDress.observe(viewLifecycleOwner, { dressWithFilter ->
            lifecycleScope.launch {
                dressAdapter.submitData(dressWithFilter)
            }
        })
    }

    override fun onDestroyView() {
        binding.rvDress.adapter = null
        _binding = null
        super.onDestroyView()
    }
}