package id.co.gits.gitsplayground.view.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.MenuItem
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseActivity
import id.co.gits.gitsplayground.databinding.MainActivityBinding
import id.co.gits.gitsplayground.view.pushnotification.PushNotificationActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.apply {
            replaceFragment(MainFragment.newInstance())

            // Notification background handling
            val intent = intent

            if (intent != null) {
                val b = intent.extras
                if (b != null) {
                    val keys = b.keySet()
                    val title = b["title"]
                    if (title.toString().isNotEmpty()) startActivity(Intent(this@MainActivity, PushNotificationActivity::class.java))

                    for (key in keys) {
                        Log.d(MainActivity::class.java.simpleName, "DATA => Bundle Contains: key=$key")
                    }
                } else {
                    Log.d(MainActivity::class.java.simpleName, "DATA => onCreate: BUNDLE is null")
                }
            } else {
                Log.d(MainActivity::class.java.simpleName, "DATA => onCreate: INTENT is null")
            }
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
                .add(R.id.frame_container, fragment)
                .addToBackStack(fragment::class.java.simpleName)
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
