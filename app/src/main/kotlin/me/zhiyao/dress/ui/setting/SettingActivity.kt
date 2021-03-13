package me.zhiyao.dress.ui.setting

import android.os.Bundle
import androidx.activity.viewModels
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import dagger.hilt.android.AndroidEntryPoint
import me.zhiyao.dress.R
import me.zhiyao.dress.constant.OrderBy
import me.zhiyao.dress.databinding.ActivitySettingBinding
import me.zhiyao.dress.ext.viewBinding
import me.zhiyao.dress.ui.base.BaseActivity

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
@AndroidEntryPoint
class SettingActivity : BaseActivity() {

    private val binding by viewBinding(ActivitySettingBinding::inflate)
    private val viewModel by viewModels<SettingViewModel>()

    private val sortOptionList = ArrayList<String>()

    @OrderBy
    private var currentSortOrder: Int = OrderBy.CREATE_TIME_DESC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initView()
    }

    override fun canGoBack() = true

    private fun initData() {
        sortOptionList.add(getString(R.string.setting_dress_sort_create_time_asc))
        sortOptionList.add(getString(R.string.setting_dress_sort_create_time_desc))
        sortOptionList.add(getString(R.string.setting_dress_sort_origin_price_asc))
        sortOptionList.add(getString(R.string.setting_dress_sort_origin_price_desc))
        sortOptionList.add(getString(R.string.setting_dress_sort_rent_asc))
        sortOptionList.add(getString(R.string.setting_dress_sort_rent_desc))

        viewModel.sortOrder.observe(this, {
            currentSortOrder = it
            binding.tvSettingDressSortPreference.text = sortOptionList[currentSortOrder - 1]
        })
    }

    private fun initView() {
        binding.llDressSortPreference.setOnClickListener {
            showChangeDressSortDialog()
        }
    }

    private fun showChangeDressSortDialog() {
        MaterialDialog(this).show {
            listItemsSingleChoice(
                items = sortOptionList,
                initialSelection = currentSortOrder - 1
            ) { _, index, _ ->
                viewModel.setSortOrder(index + 1)
            }
        }
    }
}