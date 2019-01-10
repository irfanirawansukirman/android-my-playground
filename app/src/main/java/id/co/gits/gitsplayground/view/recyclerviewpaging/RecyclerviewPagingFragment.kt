package id.co.gits.gitsplayground.view.recyclerviewpaging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewPagingApiFragmentBinding
import id.co.gits.gitsplayground.util.putArgs
import id.co.gits.gitsplayground.view.main.MainActivity

class RecyclerviewPagingFragment: BaseFragment() {

    lateinit var viewBinding: RecyclerviewPagingApiFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = RecyclerviewPagingApiFragmentBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(arguments?.getString(TAG) ?: "")
        (activity as MainActivity).showHomeBackButton(true)
    }

    companion object {
        val TAG = RecyclerviewPagingFragment::class.java.simpleName

        fun newInstance(title: String) = RecyclerviewPagingFragment().putArgs {
            putString(TAG, title)
        }
    }

}