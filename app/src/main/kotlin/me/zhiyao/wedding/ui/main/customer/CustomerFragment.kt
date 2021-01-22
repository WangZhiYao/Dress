package me.zhiyao.wedding.ui.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import me.zhiyao.wedding.databinding.FragmentCustomerBinding
import me.zhiyao.wedding.ui.base.BaseFragment

class CustomerFragment : BaseFragment() {

    private val viewModel by viewModels<CustomerViewModel>()

    private lateinit var binding: FragmentCustomerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }
}