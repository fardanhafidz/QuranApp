package com.idn.alquranapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.alquranapp.databinding.ItemAyahBinding
import com.idn.alquranapp.core.domain.model.Ayah
import com.idn.alquranapp.core.domain.model.QuranEdition

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.MyViewHolder>() {
    private val listAyah = ArrayList<Ayah>()
    private val listQuranEditions = ArrayList<QuranEdition>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(dataAyah: List<Ayah>?, dataEdition: List<QuranEdition>?) {
        if (dataAyah == null || dataEdition == null) return
        listAyah.clear()
        listAyah.addAll(dataAyah)
        listQuranEditions.clear()
        listQuranEditions.addAll(dataEdition)
    }

    class MyViewHolder(val binding: ItemAyahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listAyah = listAyah[position]
        val quranAudio = listQuranEditions[1].listAyahs[position]
        val quranTranslationIndo = listQuranEditions[2].listAyahs[position]

        holder.binding.apply {
            itemNumberAyah.text = listAyah.numberInSurah.toString()
            itemAyah.text = listAyah.text
            itemTranslation.text = quranTranslationIndo.text
            this.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(quranAudio)
            }
        }
    }

    override fun getItemCount() = listAyah.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Ayah)
    }
}