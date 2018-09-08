package id.co.gits.gitsplayground

import android.databinding.DataBindingUtil
import android.os.Bundle
import id.co.gits.gitsplayground.base.BaseActivity
import id.co.gits.gitsplayground.databinding.MainActivityBinding
import id.co.gits.gitsplayground.recyclerviewbasic.RecyclerviewBasicFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.apply {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, RecyclerviewBasicFragment.newInstance())
                    .commit()
        }
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

}
