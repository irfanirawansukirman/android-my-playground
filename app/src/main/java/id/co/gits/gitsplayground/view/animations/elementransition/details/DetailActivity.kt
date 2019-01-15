package id.co.gits.gitsplayground.view.animations.elementransition.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import id.co.gits.gitsplayground.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
    }

    override fun onBackPressed() {
        //To support reverse transitions when user clicks the device back button
        supportFinishAfterTransition()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //To support reverse transition when user clicks the action bar's Up/Home button
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
