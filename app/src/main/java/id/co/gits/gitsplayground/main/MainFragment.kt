package id.co.gits.gitsplayground.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.MainFragmentBinding
import id.co.gits.gitsplayground.recyclerviewbasic.RecyclerviewBasicFragment
import id.co.gits.gitsplayground.recyclerviewcard.RecyclerviewCardFragment
import id.co.gits.gitsplayground.recyclerviewgroupbasic.RecyclerviewGroupBasicFragment
import id.co.gits.gitsplayground.recyclerviewgroupsticky.RecyclerviewGroupStickyFragment
import kotlinx.android.synthetic.main.main_fragment.*

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
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))
            menuData.add(MainModel(0, "Recyclerview Basic Basic Super Glue"))
            menuData.add(MainModel(0, "Recyclerview Basic"))

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
        }

        (activity as MainActivity).replaceFragment(fragment)
    }

    companion object {
        fun newInstance() = MainFragment().apply { }
    }
}