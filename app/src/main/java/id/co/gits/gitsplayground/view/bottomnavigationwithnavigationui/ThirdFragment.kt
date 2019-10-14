package id.co.gits.gitsplayground.view.bottomnavigationwithnavigationui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.gits.gitsplayground.R
import kotlinx.android.synthetic.main.bottom_content_fragment.*

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_bottom_nav.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = BottomAdapter()
        }
    }

}