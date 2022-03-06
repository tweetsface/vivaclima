package com.example.vivaclima.ui.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vivaclima.R

import com.example.vivaclima.model.WheatherResponse
import com.squareup.picasso.Picasso
import java.sql.Date
import java.text.SimpleDateFormat

class WheatherAdapter(val wheather:List<WheatherResponse>):RecyclerView.Adapter<WheatherAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.list_wheather, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivwheather.text = wheather[position].list.get(position).temp?.max
        holder.ivc.text = wheather[position].city?.name + " " + wheather[position].city?.country
        holder.ivwheather.text = wheather[position].list.get(position).temp?.day
        holder.ivd.text = wheather[position].list.get(position).weather.get(position).description
        holder.ivf.text = getDateTime(wheather[position].list.get(position).dt)
        holder.ivday.text = getDay(wheather[position].list.get(position).dt)
        holder.ivmm.text =
            "Max:" + wheather[position].list.get(position).temp?.max + "  " + "Min:" + wheather[position].list.get(
                position
            ).temp?.min
        Picasso.get().load(
                "https://openweathermap.org/img/wn/" + wheather[position].list.
                 get(position).weather.get(position).icon + "@2x.png"
            ).into(holder.ivti)
    }


    override fun getItemCount(): Int {
        return wheather.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivwheather:TextView
        val ivti:ImageView
        val ivd:TextView
        val ivc:TextView
        val ivf:TextView
        val ivmm:TextView
        val ivday:TextView

        init {
            // Define click listener for the ViewHolder's View.
            ivwheather=ItemView.findViewById<TextView>(R.id.ivtemperatura)
            ivti=itemView.findViewById<ImageView>(R.id.ivtiempo)
            ivd=itemView.findViewById<TextView>(R.id.ivdescripcion)
            ivc=itemView.findViewById<TextView>(R.id.ivciudad)
            ivf=itemView.findViewById<TextView>(R.id.ivfecha)
            ivmm=itemView.findViewById<TextView>(R.id.ivmaxmin)
           ivday= itemView.findViewById<TextView>(R.id.ivday)
        }
    }

} private fun getDateTime(s: String): String? {
    try {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val netDate = Date(s.toLong() * 1000)
        return sdf.format(netDate)
    } catch (e: Exception) {
        return e.toString()
    }
}

private fun getDay(s: String): String? {
    try {
        val sdf = SimpleDateFormat("E")
        val netDate = Date(s.toLong() * 1000)
        return sdf.format(netDate)
    } catch (e: Exception) {
        return e.toString()
    }
}


