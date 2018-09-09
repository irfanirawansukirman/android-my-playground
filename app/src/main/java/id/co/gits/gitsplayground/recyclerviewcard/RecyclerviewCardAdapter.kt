package id.co.gits.gitsplayground.recyclerviewcard

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.databinding.RecyclerviewCardItemBinding

class RecyclerviewCardAdapter(private var data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding: RecyclerviewCardItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context),
                R.layout.recyclerview_card_item, parent, false)

        return MainItemRow(viewBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    class MainItemRow(private val viewBinding: RecyclerviewCardItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(nameTitle: String) {
            viewBinding.nameTitle = nameTitle
        }
    }
}