package id.co.gits.gitsplayground.recyclerviewcard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.databinding.RecyclerviewCardItemBinding

class RecyclerviewCardAdapter(private var data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainItemRow(
            RecyclerviewCardItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))

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