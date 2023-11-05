package com.example.pertemuan10

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas10.Siswa
import com.example.tugas10.databinding.DataSiswaBinding

typealias OnClickSiswa = (Siswa) -> Unit

class SiswaAdapter(private val listSiswa: List<Siswa>, private val onClickSiswa: OnClickSiswa) : RecyclerView.Adapter<SiswaAdapter.ItemSiswaViewHolder>() {

    inner class ItemSiswaViewHolder(private val binding: DataSiswaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : Siswa){
            with(binding){
                val resID = root.context.resources.getIdentifier(
                    data.photo,
                    "drawable",
                    root.context.packageName
                )
                fotoSiswa.setImageResource(resID)
                namaSiswa.text = data.name
                ipkSiswa.text = data.ipk

                val ipk = data.ipk.toFloat()
                if(ipk > 3.8){
                    colorStrip.background = ColorDrawable(Color.RED)
                }else if(ipk > 3.5){
                    colorStrip.background = ColorDrawable(Color.GREEN)
                } else {
                    colorStrip.background = ColorDrawable(Color.BLUE)
                }

                itemView.setOnClickListener {
                    onClickSiswa(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSiswaViewHolder {
        val binding = DataSiswaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemSiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listSiswa.size
    }

    override fun onBindViewHolder(holder: ItemSiswaViewHolder, position: Int) {
        holder.bind(listSiswa[position])
    }
}