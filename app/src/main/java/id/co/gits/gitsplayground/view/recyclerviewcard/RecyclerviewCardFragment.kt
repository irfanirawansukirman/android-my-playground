package id.co.gits.gitsplayground.view.recyclerviewcard

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewCardFragmentBinding
import id.co.gits.gitsplayground.view.main.MainActivity
import id.co.gits.gitsplayground.util.putArgs
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
        (activity as MainActivity).setToolbarTitle(arguments?.getString(TAG) ?: "")
        (activity as MainActivity).showHomeBackButton(true)

        recycler_card.apply {
            val dummyData = ArrayList<String>()
            for (i in 0 until 20) {
                dummyData.add(RecyclerviewCardFragment::class.java.simpleName)
            }

            setHasFixedSize(true)
            itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
            adapter = RecyclerviewCardAdapter(dummyData)
        }
    }

    companion object {
        var TAG = RecyclerviewCardFragment::class.java.simpleName

        fun newInstance(title: String) = RecyclerviewCardFragment().putArgs {
            putString(TAG, title)
        }
    }
}