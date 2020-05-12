package com.example.colorgame

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_field.*
import kotlin.random.Random

class GameField : AppCompatActivity() {

    var username: String = ""
    var gender: String = ""
    var score_count: Int = 0
    var all_colors = listOf("Red", "Green", "Black", "Yellow", "Blue", "Orange", "Gray")
    var all_hex = listOf("#FF0000", "#00FF00", "#000000", "#FFFF00", "#0000FF", "#FFA500", "#9C9C9C")

    var left_data = listOf("", "")
    var right_data = listOf("", "")
    var bg_color = "white"

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.stop_item -> {
                val scoreIntent = Intent(this, ResultActivity::class.java)
                scoreIntent.putExtra("bg_color", this.bg_color)
                scoreIntent.putExtra("points", score_count.toString())
                startActivity(scoreIntent)

                score_count = 0
                return true
            }
            R.id.quit_item -> {
                finish()
            }
            R.id.bg_sub_dark -> {
                back_layout.setBackgroundColor(Color.DKGRAY)
            }
            R.id.bg_sub_gray -> {
                back_layout.setBackgroundColor(Color.GRAY)
            }
            R.id.bg_sub_white -> {
                back_layout.setBackgroundColor(Color.LTGRAY)
            }


        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState!=null)
        {
            score_count = savedInstanceState.getInt("score_point")
        }

        setContentView(R.layout.activity_game_field)
        username = intent.getStringExtra("username").toString()
        gender = intent.getStringExtra("gender").toString()
        user_name.text = "Welcome, "+gender+username+"\nChoose the correct name of color below:"

        this.setFields()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score_point", score_count)

    }

    fun setFields()
    {
        var left_color = all_colors[Random.nextInt(0, all_colors.size-1)]
        var left_hex = all_hex[Random.nextInt(0, all_colors.size-1)]
        var right_color = all_colors[Random.nextInt(0, all_colors.size-1)]
        var right_hex = all_hex[Random.nextInt(0, all_colors.size-1)]

        left_color_view.text = left_color
        left_color_view.setTextColor(Color.parseColor(left_hex))

        right_color_view.text = right_color
        right_color_view.setTextColor(Color.parseColor(right_hex))

        left_data = listOf(left_color, left_hex)
        right_data = listOf(right_color, right_hex)
    }

    fun isCoincidence(color: String, hex: String): Boolean
    {
        if (all_colors.indexOf(color) == all_hex.indexOf(hex))
            return true
        return false

    }

    fun checkAnswer(btn :View)
    {
        var vin = false
        var vin_1 = false
        var vin_2 = false
        var msg = "Score: "
        if (btn.id == R.id.left_btn)
        {
            vin = isCoincidence(left_data[0], left_data[1])
        }
        else if (btn.id == R.id.right_btn)
        {
            vin = isCoincidence(right_data[0], right_data[1])
        }
        else
        {
            vin_1 = isCoincidence(left_data[0], left_data[1])
            vin_2 = isCoincidence(right_data[0], right_data[1])
            vin = !vin_1 && !vin_2 //TRUE if all is FALSE
        }


        if(vin)
        {
            score_count++
            msg+=score_count.toString()
        }
        else {
            //GAME OVER
            val scoreIntent = Intent(this, ResultActivity::class.java)
            scoreIntent.putExtra("username", username)
            scoreIntent.putExtra("points", score_count.toString())
            startActivity(scoreIntent)

            msg = "You lose! Your score: " + score_count.toString() + "\nTry again!"
            score_count = 0
        }

        score.text = msg
        this.setFields()
    }

    fun changeBg(view: View) {
        var white = white_bg.isChecked()
        var dark = dark_bg.isChecked()
        var gray = white && dark

        if(gray) {
            back_layout.setBackgroundColor(Color.GRAY)
            this.bg_color = "gray"
        }
        else if(dark)
        {
            back_layout.setBackgroundColor(Color.DKGRAY)
            this.bg_color = "dark"
        }
        else
        {
            back_layout.setBackgroundColor(Color.WHITE)
            this.bg_color = "white"
        }
    }

}
