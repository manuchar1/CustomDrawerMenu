package com.tbcacademy.customdrawermenu.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tbcacademy.customdrawermenu.R
import com.tbcacademy.customdrawermenu.databinding.RowNavDrawerBinding
import com.tbcacademy.customdrawermenu.model.ItemModel
import kotlinx.android.synthetic.main.row_nav_drawer.view.*

class DrawerAdapter(private var items: ArrayList<ItemModel>, private var currentPos: Int) :
    RecyclerView.Adapter<DrawerAdapter.NavigationItemViewHolder>() {

    private lateinit var context: Context

    inner class NavigationItemViewHolder(private val binding: RowNavDrawerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val binding = RowNavDrawerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NavigationItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {

        if (position == currentPos) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.drawer_menu_start_color
                )
            )
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    android.R.color.transparent
                )
            )
        }

        holder.itemView.setOnClickListener {
            onItemClickListener
        }

        holder.itemView.navigation_icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        holder.itemView.navigation_title.setTextColor(Color.WHITE)

        holder.itemView.navigation_title.text = items[position].title

        holder.itemView.navigation_icon.setImageResource(items[position].icon)

    }

    private var onItemClickListener: ((ItemModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (ItemModel) -> Unit) {
        onItemClickListener = listener

    }
}