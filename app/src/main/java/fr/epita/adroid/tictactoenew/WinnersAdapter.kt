package fr.epita.adroid.tictactoenew

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WinnersAdapter(val data : List<Winners>, val context : Activity, val onItemClickListner : View.OnClickListener): RecyclerView.Adapter<WinnersAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView)
    {
        val nameTextView: TextView = itemView.findViewById(R.id.third_name)
        val dateTextView : TextView = itemView.findViewById(R.id.third_date)
        val logoImageView : ImageView = itemView.findViewById(R.id.third_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView : View =  LayoutInflater.from(context).inflate(R.layout.winner_list, parent, false)
        itemView.setOnClickListener (onItemClickListner)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = data[position].name
        holder.dateTextView.text = data[position].date

        if (data[position].win == "X")
        {
            holder.logoImageView.setImageResource(R.drawable.cross)
        }
        else
        {
            holder.logoImageView.setImageResource(R.drawable.circle)
        }
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return data.size
    }

}