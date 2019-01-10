package id.co.gits.gitsplayground.view.recyclerviewgroupbasic

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupBasicHeaderBinding
import id.co.gits.gitsplayground.databinding.RecyclerviewGroupBasicItemBinding

class RecyclerviewGroupBasicAdapter(private var data: List<RecyclerviewGroupBasicModel>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.recyclerview_group_basic_header) {
            val viewBinding: RecyclerviewGroupBasicHeaderBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.context),
                    R.layout.recyclerview_group_basic_header, parent, false)

            HeaderItemRow(viewBinding)
        } else {
            val viewBinding: RecyclerviewGroupBasicItemBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(parent.context),
                    R.layout.recyclerview_group_basic_item, parent, false)

            MainItemRow(viewBinding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].type == 0) {
            R.layout.recyclerview_group_basic_header
        } else {
            R.layout.recyclerview_group_basic_item
        }
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainItemRow) {
            holder.bindItem(data[position])
        } else {
            (holder as HeaderItemRow).bindItem(data[position])
        }
    }

    class MainItemRow(private val viewBinding: RecyclerviewGroupBasicItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(item: RecyclerviewGroupBasicModel) {
            viewBinding.nameTitle = item.title
            viewBinding.executePendingBindings()
        }
    }

    class HeaderItemRow(private val viewBinding: RecyclerviewGroupBasicHeaderBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(item: RecyclerviewGroupBasicModel) {
            viewBinding.nameTitle = item.title
            viewBinding.executePendingBindings()
        }
    }

}