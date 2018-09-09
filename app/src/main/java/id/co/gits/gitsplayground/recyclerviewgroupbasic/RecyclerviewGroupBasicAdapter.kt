package id.co.gits.gitsplayground.recyclerviewgroupbasic

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.MainItemBinding

class RecyclerviewGroupBasicAdapter(private var data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding: MainItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context),
                R.layout.main_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    class MainItemRow(private val viewBinding: MainItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(news: String) {

        }
    }
}