package id.co.gits.gitsplayground.recyclerviewbasic

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.MainActivity
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewBasicFragmentBinding
import kotlinx.android.synthetic.main.recyclerview_basic_fragment.*

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class RecyclerviewBasicFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = RecyclerviewBasicFragmentBinding.inflate(inflater, container, false).apply {

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(RecyclerviewBasicFragment::class.java.simpleName)

        recycler_basic.apply {
            val data = ArrayList<String>()
            for (i in 0 until 20) {
                data.add(RecyclerviewBasicFragment::class.java.simpleName)
            }

            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = RecyclerviewBasicAdapter(data)
        }
    }

    companion object {
        fun newInstance() = RecyclerviewBasicFragment().apply {  }
    }
}