package me.zhiyao.wedding.ui.main.dress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import me.zhiyao.wedding.databinding.FragmentDressBinding
import me.zhiyao.wedding.ui.base.BaseFragment
import me.zhiyao.wedding.ui.main.dress.adapter.DressAdapter

@AndroidEntryPoint
class DressFragment : BaseFragment() {

    private val viewModel by viewModels<DressViewModel>()

    private lateinit var binding: FragmentDressBinding

    private lateinit var dressAdapter: DressAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
}