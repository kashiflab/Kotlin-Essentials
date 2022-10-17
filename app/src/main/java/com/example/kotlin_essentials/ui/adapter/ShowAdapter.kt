package com.example.kotlin_essentials.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_essentials.R
import com.example.kotlin_essentials.data.models.TvShowResponseItem
import com.google.android.material.imageview.ShapeableImageView

class ShowAdapter(private val context: Context, private val shows: List<TvShowResponseItem>) :
    RecyclerView.Adapter<ShowAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imageView = itemView.findViewById<ShapeableImageView>(R.id.img)
        val title = itemView.findViewById<TextView>(R.id.title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tv_show_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = shows[position]

        Glide.with(context).load(obj.image.medium).into(holder.imageView)
        holder.title.text = obj.name

    }

    override fun getItemCount(): Int {
        return shows.size
    }
}