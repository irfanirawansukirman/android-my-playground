package id.co.gits.gitsplayground.view.bottomnavigationwithnavigationui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.gits.gitsplayground.R

class BottomAdapter : RecyclerView.Adapter<BottomAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.bottom_navigation_item, parent, false))
    }

    override fun getItemCount() = 30

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view)
}