package com.example.eye_trainer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if ((intent.getStringExtra("name")) != null){
            hello_label.text = "Привет, ${intent.getStringExtra("name")}!"
        }

        game.setOnClickListener{
            val myIntent = Intent(this, EnterName::class.java)
            startActivity(myIntent)
        }

        records.setOnClickListener {
            val myintent = Intent(this, Records::class.java)
            myintent.putExtra("name", intent.getStringExtra("name"))
            myintent.putExtra("scoreAngle", intent.getStringExtra("scoreAngle"))
            myintent.putExtra("scoreScale", intent.getStringExtra("scoreScale"))
            startActivity(myintent)
        }
    }
}