package fr.epita.adroid.tictactoenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.Collections.addAll

class Third_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val actionBar = supportActionBar
        actionBar!!.title = "TicTacToe"

        val originIntent = intent
        val name = originIntent.getStringExtra("name")
        val winner = originIntent.getStringExtra("winner")

        val dateInString = Calendar.getInstance().time

        val data: List<Winners> = arrayListOf(
                Winners(name!!,winner!!, dateInString.toString())

        )
        val winnerRecyclerView : RecyclerView = findViewById(R.id.third_list)
        val onItemClickListener : View.OnClickListener = object : View.OnClickListener {
            override fun onClick(clickedItemView: View?){
                val clickedPosition : Int = clickedItemView!!.tag as Int
                Toast.makeText(this@Third_Activity, "You clicked on : " + data[clickedPosition].name,
                    Toast.LENGTH_SHORT).show()
            }
        }
        winnerRecyclerView.layoutManager = LinearLayoutManager(this@Third_Activity)
        winnerRecyclerView.adapter = WinnersAdapter(data,this@Third_Activity,onItemClickListener)
    }
}