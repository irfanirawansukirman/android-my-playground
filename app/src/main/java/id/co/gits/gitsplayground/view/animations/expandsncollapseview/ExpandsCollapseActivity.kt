package id.co.gits.gitsplayground.view.animations.expandsncollapseview

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import id.co.gits.gitsplayground.R
import kotlinx.android.synthetic.main.expands_collapse_activity.*

class ExpandsCollapseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expands_collapse_activity)

        img_expandsCollapse.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(card_expandsCollapse)
            }

            if (txt_expandsCollaps.visibility == View.GONE) {
                txt_expandsCollaps.visibility = View.VISIBLE
            } else {
                txt_expandsCollaps.visibility = View.GONE
            }
        }
    }
}
