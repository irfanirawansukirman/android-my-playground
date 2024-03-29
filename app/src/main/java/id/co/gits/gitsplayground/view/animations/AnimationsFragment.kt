package id.co.gits.gitsplayground.view.animations

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.util.putArgs
import id.co.gits.gitsplayground.view.animations.buttonroundedpressed.RoundedButtonPressedActivity
import id.co.gits.gitsplayground.view.animations.elementransition.MyListActivity
import id.co.gits.gitsplayground.view.animations.hidefabwhenscroll.HideFabActivity
import kotlinx.android.synthetic.main.animations_fragment.*
import id.co.gits.gitsplayground.view.animations.expandsncollapseview.ExpandsCollapseActivity

class AnimationsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.animations_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_animations_transition.setOnClickListener {
            startActivity(Intent(context, MyListActivity::class.java))
        }
        txt_animations_roundButton.setOnClickListener {
            startActivity(Intent(context, RoundedButtonPressedActivity::class.java))
        }
        txt_animations_hideFab.setOnClickListener {
            startActivity(Intent(context, HideFabActivity::class.java))
        }
        txt_animations_expandsCollapse.setOnClickListener {
            startActivity(Intent(context, ExpandsCollapseActivity::class.java))
        }
    }

    companion object {
        fun newInstance() = AnimationsFragment().putArgs { }
    }
}