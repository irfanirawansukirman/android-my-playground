package id.co.gits.gitsplayground.view.recyclerviewgroupsticky

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupStickyItemBinding

class RecyclerviewGroupStickyAdapter(private var data: List<RecyclerviewGroupStickyModel>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val viewBinding: RecyclerviewGroupStickyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.recyclerview_group_sticky_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    class MainItemRow(private val viewBinding: RecyclerviewGroupStickyItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(title: RecyclerviewGroupStickyModel) {
            viewBinding.nameTitle = title.firstName.toString()
            viewBinding.executePendingBindings()
        }
    }
}