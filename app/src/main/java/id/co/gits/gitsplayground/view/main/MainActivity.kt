package id.co.gits.gitsplayground.view.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseActivity
import id.co.gits.gitsplayground.databinding.MainActivityBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.apply {
            replaceFragment(MainFragment.newInstance())
        }
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun showHomeBackButton(showButton: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(showButton)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 1) {
            supportFragmentManager.popBackStackImmediate()
            showHomeBackButton(false)
        } else {
            finish()
        }
    }

}
