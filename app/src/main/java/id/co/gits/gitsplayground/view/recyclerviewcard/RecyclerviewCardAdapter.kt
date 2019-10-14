package id.co.gits.gitsplayground.view.recyclerviewcard

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.gits.gitsplayground.databinding.RecyclerviewCardItemBinding

class RecyclerviewCardAdapter(private var data: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainItemRow(
            RecyclerviewCardItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as MainItemRow).bindItem(data[position])
    }

    class MainItemRow(private val viewBinding: RecyclerviewCardItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(viewBinding.root) {

        fun bindItem(nameTitle: String) {
            viewBinding.nameTitle = nameTitle
        }
    }
}