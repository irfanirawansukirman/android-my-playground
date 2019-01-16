package id.co.gits.gitsplayground.view.animations.hidefabwhenscroll

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.util.widget.HideShowScrollListener
import kotlinx.android.synthetic.main.hide_fab_activity.*

class HideFabActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hide_fab_activity)

        switch_hideFab.setOnCheckedChangeListener { a, isChecked ->
            if (isChecked) {
                if (nested_hideFab.visibility == View.GONE) nested_hideFab.visibility = View.VISIBLE
            } else {
                nested_hideFab.visibility = View.GONE
            }
        }

        // init slide animation
        val slideDown = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_down)
        val slideUp = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_up)

        recycler_hideFab.apply {
            setHasFixedSize(true)
            adapter = HideFabAdapter()

            clearOnScrollListeners()
            addOnScrollListener(object : HideShowScrollListener() {
                override fun onHide() {
                    if (fab_hideFab_child1.isShown && fab_hideFab_child2.isShown && fab_hideFab_child3.isShown) {
                        fab_hideFab_child1.apply {
                            startAnimation(slideDown)
                            visibility = View.GONE
                        }
                        fab_hideFab_child2.apply {
                            startAnimation(slideDown)
                            visibility = View.GONE
                        }
                        fab_hideFab_child3.apply {
                            startAnimation(slideDown)
                            visibility = View.GONE
                        }
                    }
                    fab_hideFab.apply {
                        startAnimation(slideDown)
                        visibility = View.GONE
                    }
                }

                override fun onShow() {
                    fab_hideFab.apply {
                        startAnimation(slideUp)
                        visibility = View.VISIBLE
                    }
                }
            })
        }

        // recyclerview inside nested scroll view
        recycler_hideFab_nested.apply {
            setHasFixedSize(true)
            adapter = HideFabAdapter()
        }

        nested_hideFab.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                if (fab_hideFab_child1.isShown && fab_hideFab_child2.isShown && fab_hideFab_child3.isShown) {
                    fab_hideFab_child1.apply {
                        startAnimation(slideDown)
                        visibility = View.GONE
                    }
                    fab_hideFab_child2.apply {
                        startAnimation(slideDown)
                        visibility = View.GONE
                    }
                    fab_hideFab_child3.apply {
                        startAnimation(slideDown)
                        visibility = View.GONE
                    }
                }
                if (fab_hideFab.isShown) {
                    fab_hideFab.apply {
                        startAnimation(slideDown)
                        visibility = View.GONE
                    }
                }
            } else {
                if (!fab_hideFab.isShown) {
                    fab_hideFab.apply {
                        startAnimation(slideUp)
                        visibility = View.VISIBLE
                    }
                }
            }
        })

        fab_hideFab.setOnClickListener {
            if (!fab_hideFab_child1.isShown && !fab_hideFab_child2.isShown) {
                fab_hideFab_child1.apply {
                    startAnimation(slideUp)
                    visibility = View.VISIBLE
                }
                fab_hideFab_child2.apply {
                    startAnimation(slideUp)
                    visibility = View.VISIBLE
                }
                fab_hideFab_child3.apply {
                    startAnimation(slideUp)
                    visibility = View.VISIBLE
                }
            } else {
                fab_hideFab_child1.apply {
                    startAnimation(slideDown)
                    visibility = View.GONE
                }
                fab_hideFab_child2.apply {
                    startAnimation(slideDown)
                    visibility = View.GONE
                }
                fab_hideFab_child3.apply {
                    startAnimation(slideDown)
                    visibility = View.GONE
                }
            }
        }
    }
}
