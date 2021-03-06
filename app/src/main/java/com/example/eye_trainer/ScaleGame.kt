package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scale_game.*
import kotlin.math.roundToInt

class ScaleGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale_game)

        button.setOnClickListener {

            val next = Intent(this, SquareGame::class.java)

            next.putExtra("name", intent.getStringExtra("name"))
            next.putExtra("scoreAngle", intent.getStringExtra("scoreAngle"))
            val scale = canvasViewScale.scale
            val answer = answer.text.toString().toDouble()
            var score = 100*answer/scale
            if (score > 100){
                score = 100*scale/answer
            }

            next.putExtra("scoreScale", "${score.roundToInt()}")

            startActivity(next)
        }
    }
}