package id.co.gits.gitsplayground.view.main

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.MainItemBinding

class MainAdapter(private var data: List<MainModel>,
                  private val menuItemListener: MainItemActionListener) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val viewBinding: MainItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.main_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position], menuItemListener)
    }

    class MainItemRow(private val viewBinding: MainItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(item: MainModel, menuItemListener: MainItemActionListener) {
            viewBinding.menu = item
            viewBinding.menuItemListener = menuItemListener
            viewBinding.executePendingBindings()
        }
    }
}