package id.co.gits.gitsplayground.view.recyclerviewpaging

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.co.gits.gitsplayground.R

class ItemAdapter(private val mCtx: Context) : PagedListAdapter<Item, ItemAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_paging_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            holder.textView.text = item.owner?.displayName
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView: TextView = itemView.findViewById(R.id.txt_paging_title)

    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.questionId === newItem.questionId
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

}