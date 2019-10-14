package id.co.gits.gitsplayground.view.recyclerviewbasic

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.RecyclerviewBasicItemBinding

class RecyclerviewBasicAdapter(private var data: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val viewBinding: RecyclerviewBasicItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.context), R.layout.recyclerview_basic_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    override fun getItemCount() = data.size

    class MainItemRow(private val viewBinding: RecyclerviewBasicItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(title: String) {
            viewBinding.title = title
        }
    }
}