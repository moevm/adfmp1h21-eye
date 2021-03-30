package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_records.*

class Records : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        name.text = intent.getStringExtra("name")
        scoreAngle.text = intent.getStringExtra("scoreAngle")
        scoreScale.text = intent.getStringExtra("scoreScale")

        button2.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            menu.putExtra("name", name.text)
            menu.putExtra("scoreAngle", scoreAngle.text)
            menu.putExtra("scoreScale", scoreScale.text)
            startActivity(menu)
        }

        startAgain.setOnClickListener {
            val game = Intent(this, AngleGame::class.java)
            game.putExtra("name", name.text)
            game.putExtra("scoreAngle", scoreAngle.text)
            game.putExtra("scoreScale", scoreScale.text)
            startActivity(game)
        }

    }
}
