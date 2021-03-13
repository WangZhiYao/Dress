package me.zhiyao.dress.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @author WangZhiYao
 * @date 2021/1/22
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (canGoBack()) {
            supportActionBar?.run {
                setHomeButtonEnabled(true)
                setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (canGoBack() && item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    abstract fun canGoBack(): Boolean
}