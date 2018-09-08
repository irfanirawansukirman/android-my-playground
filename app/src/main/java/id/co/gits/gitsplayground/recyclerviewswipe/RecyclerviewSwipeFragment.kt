package id.co.gits.gitsplayground.recyclerviewswipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewSwipeFragmentBinding

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class RecyclerviewSwipeFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = RecyclerviewSwipeFragmentBinding.inflate(inflater, container, false).apply {

        }

        return binding.root
    }

    companion object {
        fun newInstance() = RecyclerviewSwipeFragment().apply {  }
    }
}