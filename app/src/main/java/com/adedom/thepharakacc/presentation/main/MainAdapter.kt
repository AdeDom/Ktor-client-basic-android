package com.adedom.thepharakacc.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.adedom.thepharakacc.R
import com.adedom.thepharakacc.model.Staff
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_staff.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var list = mutableListOf<Staff>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val (fullName, nickName, position, imgUrl) = list[position]

        if (fullName.isNullOrBlank()) holder.itemView.tvFullName.isVisible = false
        if (nickName.isNullOrBlank()) holder.itemView.tvNickName.isVisible = false
        if (position.isNullOrBlank()) holder.itemView.tvPosition.isVisible = false

        holder.itemView.tvFullName.text = "ชื่อ $fullName"
        holder.itemView.tvNickName.text = "ชื่อเล่น $nickName"
        holder.itemView.tvPosition.text = "ตำแหน่ง $position"

        Glide.with(holder.itemView.ivStaff)
            .load(imgUrl)
            .into(holder.itemView.ivStaff)
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<Staff>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
