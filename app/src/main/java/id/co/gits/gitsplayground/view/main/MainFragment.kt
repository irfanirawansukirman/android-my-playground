package id.co.gits.gitsplayground.view.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.view.cordinatorlayoutoverlappingbasic.CoorOverlappingViewActivity
import id.co.gits.gitsplayground.databinding.MainFragmentBinding
import id.co.gits.gitsplayground.view.recyclerviewbasic.RecyclerviewBasicFragment
import id.co.gits.gitsplayground.view.recyclerviewcard.RecyclerviewCardFragment
import id.co.gits.gitsplayground.view.recyclerviewgroupbasic.RecyclerviewGroupBasicFragment
import id.co.gits.gitsplayground.view.recyclerviewgroupsticky.RecyclerviewGroupStickyFragment
import id.co.gits.gitsplayground.view.workmanager.WorkmanagerActivity
import id.co.gits.gitsplayground.view.createpdffromhtml_A4.CreatePdfFromHtmlA4Fragment
import id.co.gits.gitsplayground.view.animations.AnimationsFragment
import id.co.gits.gitsplayground.view.recyclerviewpaging.RecyclerviewPagingFragment
import kotlinx.android.synthetic.main.main_fragment.*

import id.co.gits.gitsplayground.view.reactiveprogramming.ReactiveProgrammingActivity

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class MainFragment : BaseFragment(), MainItemActionListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = MainFragmentBinding.inflate(inflater, container, false).apply {

        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(resources.getString(R.string.app_name))

        recycler_main_menu.apply {
            val menuData = ArrayList<MainModel>()
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(1, "Recyclerview Cardview"))
            menuData.add(MainModel(2, "Recyclerview Group Basic"))
            menuData.add(MainModel(3, "Recyclerview Group Sticky"))
            menuData.add(MainModel(4, "Deeplink Basic"))
            menuData.add(MainModel(5, "Deeplink Multiple Deep Links"))
            menuData.add(MainModel(6, "Coordinator Anchor View"))
            menuData.add(MainModel(8, "Workmanager Basic"))
            menuData.add(MainModel(9, "Recyclerview Paging With API"))
            menuData.add(MainModel(10, "Create PDF From HTML - A4"))
            menuData.add(MainModel(11, "The world of animations"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(7, "Reactive Programming"))

            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = MainAdapter(menuData, this@MainFragment)
        }
    }

    override fun onMenuClick(menu: MainModel) {
        var fragment = Fragment()

        when (menu.id) {
            0 -> fragment = RecyclerviewBasicFragment.newInstance(menu.title)
            1 -> fragment = RecyclerviewCardFragment.newInstance(menu.title)
            2 -> fragment = RecyclerviewGroupBasicFragment.newInstance(menu.title)
            3 -> fragment = RecyclerviewGroupStickyFragment.newInstance(menu.title)
            4 -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://testdeeplink.com/lorem/123")))
            5 -> ""
            6 -> startActivity(Intent(context, CoorOverlappingViewActivity::class.java))
            7 -> startActivity(Intent(context, ReactiveProgrammingActivity::class.java))
            8 -> startActivity(Intent(context, WorkmanagerActivity::class.java))
            9 -> fragment = RecyclerviewPagingFragment.newInstance(menu.title)
            10 -> fragment = CreatePdfFromHtmlA4Fragment.newInstance(menu.title)
            11 -> fragment = AnimationsFragment.newInstance()
        }

        (activity as MainActivity).replaceFragment(fragment)
    }

    companion object {
        fun newInstance() = MainFragment().apply { }
    }
}