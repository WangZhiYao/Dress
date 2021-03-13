package me.zhiyao.dress.ui.main.customer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import me.zhiyao.dress.R
import me.zhiyao.dress.databinding.FragmentCustomerBinding
import me.zhiyao.dress.ui.base.BaseFragment

class CustomerFragment : BaseFragment(R.layout.fragment_customer) {

    private val viewModel by viewModels<CustomerViewModel>()

    private var _binding: FragmentCustomerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCustomerBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}