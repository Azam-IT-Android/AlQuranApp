package com.ismail.creatvt.alquranapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismail.creatvt.alquranapp.data.VersesItem
import kotlinx.android.synthetic.main.ayah_item_layout.view.*

class AyahListAdapter(val ayahList: List<VersesItem?>): RecyclerView.Adapter<AyahListAdapter.AyahViewHolder>() {

    class AyahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.ayah_item_layout,
            parent,
            false
        )
        return AyahViewHolder(view)
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        val ayah = ayahList[position]
        holder.itemView.arabic.text = ayah?.text?.arab
        holder.itemView.translation.text = ayah?.translation?.en
    }

    override fun getItemCount(): Int {
        return ayahList.size
    }
}