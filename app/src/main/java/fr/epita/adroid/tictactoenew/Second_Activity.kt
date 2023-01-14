package fr.epita.adroid.tictactoenew

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Second_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val actionBar = supportActionBar
        actionBar!!.title = "TicTacToe"

        val originIntent = intent
        val message = originIntent.getStringExtra("WINNER")

        val userInput : EditText = findViewById(R.id.second_editTXT_enterName)

        val winnerFlash : TextView = findViewById(R.id.second_txtView_winnerLOGO)
        if(message == "X")
        {
            winnerFlash.setTextColor(Color.parseColor("#088F8F"))
        }
        else
        {
            winnerFlash.setTextColor(Color.parseColor("#5D3FD3"))
        }
        winnerFlash.text = message

        val submit : Button = findViewById(R.id.second_btn_submitScore)
        submit.setOnClickListener{
            val x = findViewById(R.id.second_editTXT_enterName) as EditText
            var y = x.text.toString()
            if(y != ""){ val thirdactivity = Intent(this@Second_Activity, Third_Activity::class.java)
                    thirdactivity.putExtra("name",y)
                    thirdactivity.putExtra("winner",message)
                    startActivity(thirdactivity)
            }

        }
    }
}