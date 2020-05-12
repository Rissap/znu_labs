package com.example.colorgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConfirm.setOnClickListener {
            if(inputUserName.text.toString()=="") {

            }
            else {
                val intent = Intent(this, GameField::class.java)
                intent.putExtra("username", inputUserName.text.toString())
                if (male_radio.isChecked())
                {
                    intent.putExtra("gender", "Mr. ")
                } else if (female_radio.isChecked())
                {
                    intent.putExtra("gender", "Ms. ")
                }
                else if(other_radio.isChecked()){
                    intent.putExtra("gender", "Alien ")
                } else
                {
                    intent.putExtra("gender", "Anonymous ")
                }

                //inputUserName.visibility = View.INVISIBLE
                //btnConfirm.visibility = View.INVISIBLE


                startActivity(intent)
                finish()

            }
        }
    }
}
