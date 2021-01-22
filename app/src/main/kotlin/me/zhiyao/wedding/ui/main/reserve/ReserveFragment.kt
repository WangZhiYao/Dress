package me.zhiyao.wedding.ui.main.reserve

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import me.zhiyao.wedding.R
import me.zhiyao.wedding.databinding.FragmentReserveBinding
import me.zhiyao.wedding.ui.base.BaseFragment

class ReserveFragment : BaseFragment(R.layout.fragment_reserve) {

    private val viewModel by viewModels<ReserveViewModel>()

    private var _binding: FragmentReserveBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReserveBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}