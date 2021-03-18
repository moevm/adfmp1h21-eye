package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_records.*

class Records : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        name.text = intent.getStringExtra("player")
        score.text = intent.getStringExtra("score")

        button2.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            menu.putExtra("name", name.text)
            startActivity(menu)
        }

    }
}