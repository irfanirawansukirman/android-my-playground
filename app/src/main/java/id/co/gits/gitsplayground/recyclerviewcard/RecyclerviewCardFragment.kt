package id.co.gits.gitsplayground.recyclerviewcard

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewCardFragmentBinding
import id.co.gits.gitsplayground.main.MainActivity
import kotlinx.android.synthetic.main.recyclerview_card_fragment.*

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class RecyclerviewCardFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = RecyclerviewCardFragmentBinding.inflate(inflater, container, false).apply {

        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(RecyclerviewCardFragment::class.java.simpleName)
        (activity as MainActivity).showHomeBackButton(true)

        recycler_card.apply {
            val dummyData = ArrayList<String>()
            for (i in 0 until 20) {
                dummyData.add(RecyclerviewCardFragment::class.java.simpleName)
            }

            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = RecyclerviewCardAdapter(dummyData)
        }
    }

    companion object {
        fun newInstance() = RecyclerviewCardFragment().apply { }
    }
}