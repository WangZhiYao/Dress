package me.zhiyao.wedding.ui.main.reserve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import me.zhiyao.wedding.databinding.FragmentReserveBinding
import me.zhiyao.wedding.ui.base.BaseFragment

class ReserveFragment : BaseFragment() {

    private val viewModel by viewModels<ReserveViewModel>()

    private lateinit var binding: FragmentReserveBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReserveBinding.inflate(inflater, container, false)
        return binding.root
    }
}