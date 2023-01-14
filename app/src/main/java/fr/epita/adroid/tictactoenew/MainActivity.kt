package fr.epita.adroid.tictactoenew

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    var cp: String = "X"
    var count: Int = 0
    var gameOver: Int =0
    var turn: Int = 0
    var image: Int = R.drawable.cross
    var GameMap: Array<IntArray> = arrayOf(
        intArrayOf(-1, -2, -3),
        intArrayOf(-4, -5, -6),
        intArrayOf(-7, -8, -9)
    )
    var reset: Button? = null
    var button00: ImageView? = null
    var button01: ImageView? = null
    var button02: ImageView? = null
    var button10: ImageView? = null
    var button11: ImageView? = null
    var button12: ImageView? = null
    var button20: ImageView? = null
    var button21: ImageView? = null
    var button22: ImageView? = null
    var currentPlayer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "TicTacToe"

        val infoBtn: ImageView = findViewById(R.id.activity_main_img_info)
        infoBtn.setOnClickListener{
            val url = "https://en.wikipedia.org/wiki/Tic-tac-toe"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        currentPlayer = findViewById(R.id.activity_main_txtView_xo)
        reset = findViewById(R.id.activity_main_PlayAgain)
        reset!!.setOnClickListener {
            reset()
        }
        button00 = findViewById(R.id.activity_main_img00)
        button00!!.setOnClickListener {
            if(GameMap[0][0] == -1) {
                count++
                button00!!.setImageResource(image)
                register(0,0)
                turns()
            }
        }
        button01 = findViewById(R.id.activity_main_img01)
        button01!!.setOnClickListener {
            if(GameMap[0][1] == -2)
            {
                count++
                button01!!.setImageResource(image)
                register(0,1)
                turns()
            }
        }
        button02 = findViewById(R.id.activity_main_img02)
        button02!!.setOnClickListener {
            if(GameMap[0][2] == -3)
            {
                count++
                button02!!.setImageResource(image)
                register(0,2)
                turns()
            }
        }
        button10 = findViewById(R.id.activity_main_img10)
        button10!!.setOnClickListener {
            if(GameMap[1][0] == -4)
            {
                count++
                button10!!.setImageResource(image)
                register(1,0)
                turns()
            }
        }
        button11 = findViewById(R.id.activity_main_img11)
        button11!!.setOnClickListener {
            if(GameMap[1][1] == -5)
            {
                count++
                button11!!.setImageResource(image)
                register(1,1)
                turns()
            }
        }
        button12 = findViewById(R.id.activity_main_img12)
        button12!!.setOnClickListener {
            if(GameMap[1][2] == -6)
            {
                count++
                button12!!.setImageResource(image)
                register(1,2)
                turns()
            }
        }
        button20 = findViewById(R.id.activity_main_img20)
        button20!!.setOnClickListener {
            if(GameMap[2][0] == -7)
            {
                count++
                button20!!.setImageResource(image)
                register(2,0)
                turns()
            }
        }
        button21 = findViewById(R.id.activity_main_img21)
        button21!!.setOnClickListener {
            if(GameMap[2][1] == -8)
            {
                count++
                button21!!.setImageResource(image)
                register(2,1)
                turns()
            }
        }
        button22 = findViewById(R.id.activity_main_img22)
        button22!!.setOnClickListener {
            if(GameMap[2][2] == -9)
            {
                count++
                button22!!.setImageResource(image)
                register(2,2)
                turns()
            }
        }
    }
    fun register(x: Int,y: Int){
        GameMap[x][y] = turn
        checkWin()
    }
    fun turns(){
        if(turn == 0)
        {
            image = R.drawable.circle
            turn = 1
            cp = "O"
            currentPlayer!!.text = "O"
            currentPlayer!!.setTextColor(Color.parseColor("#5D3FD3"))
        }
        else
        {
            image = R.drawable.cross
            turn =0
            cp = "X"
            currentPlayer!!.text = "X"
            currentPlayer!!.setTextColor(Color.parseColor("#088F8F"))
        }
    }
    fun checkWin(){

        if(GameMap[0][0] == GameMap[0][1] && GameMap[0][0] == GameMap[0][2])
            gameOver = 1
        if(GameMap[1][0] == GameMap[1][1] && GameMap[1][0] == GameMap[1][2])
            gameOver = 1
        if(GameMap[2][0] == GameMap[2][1] && GameMap[2][0] == GameMap[2][2])
            gameOver = 1
        if(GameMap[0][0] == GameMap[1][0] && GameMap[0][0] == GameMap[2][0])
            gameOver = 1
        if(GameMap[0][1] == GameMap[1][1] && GameMap[0][1] == GameMap[2][1])
            gameOver = 1
        if(GameMap[0][2] == GameMap[1][2] && GameMap[0][2] == GameMap[2][2])
            gameOver = 1
        if(GameMap[0][0] == GameMap[1][1] && GameMap[0][0] == GameMap[2][2])
            gameOver = 1
        if(GameMap[2][0] == GameMap[1][1] && GameMap[2][0] == GameMap[0][2])
            gameOver = 1
        if(count == 9)
        {
            reset()
        }
        if(gameOver == 1)
        {
            reset()
            val secondactivity = Intent(this, Second_Activity::class.java)
            secondactivity.putExtra("WINNER", cp)
            startActivity(secondactivity)
        }
    }
    fun reset()
    {
        turn = 0
        gameOver = 0
        currentPlayer!!.text = "X"
        count = 0
        image = R.drawable.cross
        currentPlayer!!.setTextColor(Color.parseColor("#088F8F"))
        var arrayReset = -1
        for(i in 0..2)
        {
            for(j in 0..2)
            {
                GameMap[i][j] = arrayReset
                arrayReset--
            }
        }
        button00!!.setImageResource(0)
        button01!!.setImageResource(0)
        button02!!.setImageResource(0)
        button10!!.setImageResource(0)
        button11!!.setImageResource(0)
        button12!!.setImageResource(0)
        button20!!.setImageResource(0)
        button21!!.setImageResource(0)
        button22!!.setImageResource(0)
    }
}