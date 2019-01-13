package com.example.pc.kode_homework_recycler

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DataAdapter(val langList: List<Language>) :
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val languages = langList[position]

        holder.title.text = languages.title
        holder.author.text = "Автор: " + languages.author
        holder.paradigma.text = "Парадигмы: " + languages.paradigms.toString()
        holder.date.text = "Появился в: " + languages.data.toString() + " году"
        holder.index.text = "Рейтинг: " + languages.index.toString() + "%"
        holder.imageView.setImageResource(languages.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, WebActivity::class.java)
            intent.putExtra("Title", languages.title)
            it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return langList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView
        val author: TextView
        val imageView: ImageView
        val paradigma: TextView
        val date: TextView
        val index: TextView

        init {
            title = itemView.findViewById(R.id.lang_title)
            author = itemView.findViewById(R.id.lang_author)
            imageView = itemView.findViewById(R.id.img_lang)
            paradigma = itemView.findViewById(R.id.lang_paradigma)
            date = itemView.findViewById(R.id.lang_data)
            index = itemView.findViewById(R.id.lang_index)
        }
    }

}
