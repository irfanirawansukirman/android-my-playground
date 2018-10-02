package id.co.gits.gitsplayground.recyclerviewgroupsticky

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.base.BaseFragment
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupStickyFragmentBinding
import id.co.gits.gitsplayground.main.MainActivity
import id.co.gits.gitsplayground.util.putArgs
import kotlinx.android.synthetic.main.recyclerview_group_sticky_fragment.*
import java.util.*

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class RecyclerviewGroupStickyFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = RecyclerviewGroupStickyFragmentBinding.inflate(inflater, container, false).apply {

        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbarTitle(arguments?.getString(TAG) ?: "")
        (activity as MainActivity).showHomeBackButton(true)

        recycler_groupSticky.apply {
            val people = ArrayList<RecyclerviewGroupStickyModel>(45)
            people.add(RecyclerviewGroupStickyModel("George",
                    "Washington"))
            people.add(RecyclerviewGroupStickyModel("John",
                    "Adams"))
            people.add(RecyclerviewGroupStickyModel("Thomas",
                    "Jefferson"))
            people.add(RecyclerviewGroupStickyModel("James",
                    "Madison"))
            people.add(RecyclerviewGroupStickyModel("James",
                    "Monroe"))
            people.add(RecyclerviewGroupStickyModel("John Quincy",
                    "Adams"))
            people.add(RecyclerviewGroupStickyModel("Andrew",
                    "Jackson"))
            people.add(RecyclerviewGroupStickyModel("Martin",
                    "Van Buren"))
            people.add(RecyclerviewGroupStickyModel("William",
                    "Harrison"))
            people.add(RecyclerviewGroupStickyModel("John",
                    "Tyler"))
            people.add(RecyclerviewGroupStickyModel("Zachary",
                    "Taylor"))
            people.add(RecyclerviewGroupStickyModel("Millard",
                    "Fillmore"))
            people.add(RecyclerviewGroupStickyModel("Franklin",
                    "Pierce"))
            people.add(RecyclerviewGroupStickyModel("James",
                    "Buchanan"))
            people.add(RecyclerviewGroupStickyModel("Abraham",
                    "Lincoln"))
            people.add(RecyclerviewGroupStickyModel("Andrew",
                    "Johnson"))
            people.add(RecyclerviewGroupStickyModel("Ulysses",
                    "Grant"))
            people.add(RecyclerviewGroupStickyModel("Rutherford",
                    "Hayes"))
            people.add(RecyclerviewGroupStickyModel("James",
                    "Garfield"))
            people.add(RecyclerviewGroupStickyModel("Chester",
                    "Arthur"))
            people.add(RecyclerviewGroupStickyModel("Grover",
                    "Cleveland"))
            people.add(RecyclerviewGroupStickyModel("Benjamin",
                    "Harrison"))
            people.add(RecyclerviewGroupStickyModel("William",
                    "McKinley"))
            people.add(RecyclerviewGroupStickyModel("Theodore",
                    "Roosevelt"))
            people.add(RecyclerviewGroupStickyModel("William",
                    "Taft"))
            people.add(RecyclerviewGroupStickyModel("Woodrow",
                    "Wilson"))
            people.add(RecyclerviewGroupStickyModel("Warren",
                    "Harding"))
            people.add(RecyclerviewGroupStickyModel("Calvin",
                    "Coolidge"))
            people.add(RecyclerviewGroupStickyModel("Herbert",
                    "Hoover"))
            people.add(RecyclerviewGroupStickyModel("Harry",
                    "Truman"))
            people.add(RecyclerviewGroupStickyModel("Dwight",
                    "Eisenhower"))
            people.add(RecyclerviewGroupStickyModel("John",
                    "Kennedy"))
            people.add(RecyclerviewGroupStickyModel("Lyndon",
                    "Johnson"))
            people.add(RecyclerviewGroupStickyModel("Richard",
                    "Nixon"))
            people.add(RecyclerviewGroupStickyModel("Gerald",
                    "Ford"))
            people.add(RecyclerviewGroupStickyModel("Jimmy",
                    "Carter"))
            people.add(RecyclerviewGroupStickyModel("Ronald",
                    "Reagan"))
            people.add(RecyclerviewGroupStickyModel("George H.W.",
                    "Bush"))
            people.add(RecyclerviewGroupStickyModel("Bill",
                    "Clinton"))
            people.add(RecyclerviewGroupStickyModel("George W.",
                    "Bush"))
            people.add(RecyclerviewGroupStickyModel("Barack",
                    "Obama"))
            people.add(RecyclerviewGroupStickyModel("Donald",
                    "Trump"))

            val sectionItemDecoration = RecyclerviewGroupStickyItemDecoration(resources.getDimensionPixelOffset(
                    R.dimen.actionBarSize), true, getSectionCallback(people))

            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(sectionItemDecoration)
            adapter = RecyclerviewGroupStickyAdapter(people)
        }
    }

    private fun getSectionCallback(people: List<RecyclerviewGroupStickyModel>): RecyclerviewGroupStickyItemDecoration.SectionCallback {
        return object : RecyclerviewGroupStickyItemDecoration.SectionCallback {
            override fun isSection(position: Int): Boolean {
                return position == 0 || people[position]
                        .lastName
                        .substring(0, 0) != people.get(position - 1)
                        .lastName
                        .substring(0, 0)
            }

            override fun getSectionHeader(position: Int): CharSequence {
                return people[position]
                        .lastName
                        .subSequence(0, 1)
            }
        }
    }

    companion object {
        var TAG = RecyclerviewGroupStickyFragment::class.java.simpleName

        fun newInstance(title: String) = RecyclerviewGroupStickyFragment().putArgs {
            putString(TAG, title)
        }
    }
}