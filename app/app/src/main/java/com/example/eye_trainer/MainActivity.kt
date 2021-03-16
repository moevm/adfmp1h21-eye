package com.example.eye_trainer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game.setOnClickListener{
            val myIntent = Intent(this, EnterName::class.java)
            startActivity(myIntent)
        }
    }
}