package com.dicoding.dinoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDinoAdapter(private val listDino: ArrayList<Dino>) : RecyclerView.Adapter<ListDinoAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    // BUAT APA?
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    // ngasih template item_row_dino
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_dino, parent, false)
        return ListViewHolder(view)
    }


    // memasang data dari listDino ke holder(tampilan pada tiap row dari view)
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc) = listDino[position]
        val img = listDino[position].img
        holder.imgPhoto.setImageResource(img)
        holder.tvName.text = name
        holder.tvDescription.text = desc
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listDino[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listDino.size



    // class yang digunakan untuk menampung slot tampilan data pada item_row_dino
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // INI BUAT APA? MASIH GATAU
    interface OnItemClickCallback {
        fun onItemClicked(data: Dino)
    }


}

