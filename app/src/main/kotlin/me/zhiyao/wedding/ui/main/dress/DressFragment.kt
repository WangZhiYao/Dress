package me.zhiyao.wedding.ui.main.dress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import me.zhiyao.wedding.databinding.FragmentDressBinding

class DressFragment : Fragment() {

    private val viewModel by viewModels<DressViewModel>()

    private lateinit var binding: FragmentDressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDressBinding.inflate(inflater, container, false)
        return binding.root
    }
}