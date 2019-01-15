package id.co.gits.gitsplayground.view.animations.elementransition

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.view.View
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseActivity
import id.co.gits.gitsplayground.view.animations.elementransition.details.DetailActivity
import kotlinx.android.synthetic.main.list_activity.*

class MyListActivity : BaseActivity(), MyListCourier {

    override fun onItemClicked(item: MyListModel, views: ArrayList<View>) {
        val intent = Intent(this@MyListActivity, DetailActivity::class.java)

        // Cara ke 1, Jika hanya satu object yg di apply animasi
        // val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                // this@MyListActivity, imageView, ViewCompat.getTransitionName(imageView) ?: ""
        // )

        // Cara ke 2, Jika lebih dari satu object yang di apply animasi
        val pairObj1 = Pair.create(views[0], ViewCompat.getTransitionName(views[0]) ?: "")
        val pairObj2 = Pair.create(views[1], ViewCompat.getTransitionName(views[1]) ?: "")
        val pairObj3 = Pair.create(views[2], ViewCompat.getTransitionName(views[2]) ?: "")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MyListActivity,
                pairObj1, pairObj2, pairObj3)

        startActivity(intent, options.toBundle())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        val dummyList = mutableListOf<MyListModel>().apply {
            add(MyListModel(
                    title = getString(R.string.app_name),
                    desc = getString(R.string.app_name),
                    urlImage = R.drawable.dummy))
            add(MyListModel(
                    title = getString(R.string.app_name),
                    desc = getString(R.string.app_name),
                    urlImage = R.drawable.dummy))
            add(MyListModel(
                    title = getString(R.string.app_name),
                    desc = getString(R.string.app_name),
                    urlImage = R.drawable.dummy))
            add(MyListModel(
                    title = getString(R.string.app_name),
                    desc = getString(R.string.app_name),
                    urlImage = R.drawable.dummy))
            add(MyListModel(
                    title = getString(R.string.app_name),
                    desc = getString(R.string.app_name),
                    urlImage = R.drawable.dummy))
        }

        recycler_animation.apply {
            setHasFixedSize(true)
            adapter = MyListAdapter(dummyList, this@MyListActivity)
        }
    }
}
