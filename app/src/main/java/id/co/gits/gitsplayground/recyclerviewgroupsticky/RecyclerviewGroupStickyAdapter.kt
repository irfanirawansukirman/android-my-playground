package id.co.gits.gitsplayground.recyclerviewgroupsticky

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupStickyItemBinding

class RecyclerviewGroupStickyAdapter(private var data: List<RecyclerviewGroupStickyModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding: RecyclerviewGroupStickyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.recyclerview_group_sticky_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    class MainItemRow(private val viewBinding: RecyclerviewGroupStickyItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(title: RecyclerviewGroupStickyModel) {
            viewBinding.nameTitle = title.firstName.toString()
            viewBinding.executePendingBindings()
        }
    }
}