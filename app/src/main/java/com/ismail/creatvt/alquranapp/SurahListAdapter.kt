package com.ismail.creatvt.alquranapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismail.creatvt.alquranapp.data.DataItem
import kotlinx.android.synthetic.main.surah_item_layout.view.*

class SurahListAdapter(val surahList: List<DataItem?>): RecyclerView.Adapter<SurahListAdapter.SurahViewHolder>() {

    class SurahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.surah_item_layout,
            parent,
            false
        )
        return SurahViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surah = surahList[position]
        holder.itemView.surah_name.text = surah?.name?.transliteration?.en
        holder.itemView.surah_number.text = surah?.number?.toString()
        holder.itemView.revelation.text = surah?.revelation?.en
        holder.itemView.verse_count.text = "${surah?.numberOfVerses} Verses"
    }

    override fun getItemCount(): Int {
        return surahList.size
    }
}