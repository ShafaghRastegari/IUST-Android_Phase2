package com.example.pamm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.zip.Inflater

class AdapterRecyclerView(val listImage:ArrayList<ModelCar>,val onClickItemRecyclerview: OnClickItemRecyclerview) : RecyclerView.Adapter<AdapterRecyclerView.vh>()


{
   inner  class vh(itemView: View) :   RecyclerView.ViewHolder(itemView) {
      val imageView :ImageView =itemView.findViewById(R.id.image_item)
      val tvName    :TextView  =itemView.findViewById(R.id.tv_nameCar)
      val tvAge     :TextView  =itemView.findViewById(R.id.tv_ageCar)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        return  vh( LayoutInflater.from(parent.context).inflate(R.layout.item_recy,parent,false))
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
            val m=listImage[position]
        holder.imageView.setImageResource( m.image)
        holder.tvName.text = m.name
        holder.tvAge.text=m.Yearofconstruction

        holder.itemView.setOnClickListener {
            onClickItemRecyclerview.click(m,holder.itemView.id)

        }

    }

    interface  OnClickItemRecyclerview{

        fun click(modelCar: ModelCar,id:Int)
    }

}