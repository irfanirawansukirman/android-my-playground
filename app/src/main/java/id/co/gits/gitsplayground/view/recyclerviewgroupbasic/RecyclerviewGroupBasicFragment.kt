package id.co.gits.gitsplayground.view.recyclerviewgroupbasic

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupBasicFragmentBinding
import id.co.gits.gitsplayground.view.main.MainActivity
import id.co.gits.gitsplayground.util.putArgs
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
        (activity as MainActivity).setToolbarTitle(arguments?.getString(TAG) ?: "")
        (activity as MainActivity).showHomeBackButton(true)

        recycler_groupBasic.apply {
            val dummyData = ArrayList<RecyclerviewGroupBasicModel>()
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(0, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))
            dummyData.add(RecyclerviewGroupBasicModel(1, 0, "Lorem"))

            setHasFixedSize(true)
            itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
            adapter = RecyclerviewGroupBasicAdapter(dummyData)
        }
    }

    companion object {
        var TAG = RecyclerviewGroupBasicFragment::class.java.simpleName

        fun newInstance(title: String) = RecyclerviewGroupBasicFragment().putArgs {
            putString(TAG, title)
        }
    }
}