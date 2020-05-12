package com.example.colorgame

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    var point = ""
    var username = ""

    var db = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.point = intent.getStringExtra("points")
        this.username = intent.getStringExtra("username")

        if (this.point.toInt() <11)
        {
            phrase.text = "Do you know what color is?"
        } else if(this.point.toInt() < 21)
        {
            phrase.text = "Good for the first time"
        } else {
            phrase.text = "You are amazing!"
        }
        points.text = "SCORE: "+ this.point

        this.get_scores()

    }

    fun get_scores()
    {

        db.insertData(User(username, point.toInt()))
        var data = db.readData()
        var msg = ""

        for (i in 0..data.size-1)
        {
            msg += data[i].name+"  #  " +data[i].points.toString()+"\n"
        }
        result_text.text = msg
    }


    fun mail_to(view: View)
    {
        var mailIntent = Intent(Intent.ACTION_SEND)

        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"

        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "GAME SCORE")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "You got "+this.point+" point")

        startActivity(Intent.createChooser(mailIntent, "Choose Email Client..."))
    }

}
