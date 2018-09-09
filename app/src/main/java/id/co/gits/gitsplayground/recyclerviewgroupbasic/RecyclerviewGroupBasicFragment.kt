package id.co.gits.gitsplayground.recyclerviewgroupbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupBasicFragmentBinding
import id.co.gits.gitsplayground.main.MainActivity
import kotlinx.android.synthetic.main.recyclerview_group_basic_fragment.*

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class RecyclerviewGroupBasicFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = RecyclerviewGroupBasicFragmentBinding.inflate(inflater, container, false).apply {

        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(RecyclerviewGroupBasicFragment::class.java.simpleName)
        (activity as MainActivity).showHomeBackButton(true)

        recycler_groupBasic.apply {

        }
    }

    companion object {
        fun newInstance() = RecyclerviewGroupBasicFragment().apply {  }
    }
}