package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_angle_game.*
import kotlin.math.roundToInt


class AngleGame : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angle_game)


        button.setOnClickListener {
            val next = Intent(this, ScaleGame::class.java)
            next.putExtra("name", intent.getStringExtra("name"))
            val answer = answer.text.toString().toDouble()
            var alfa = canvasView.alfa*180/Math.PI

            var score = answer/alfa*100
            if (score > 100){
                score = alfa/answer*100
            }
            if (score>99){
                score = 100.0
            }

            next.putExtra("scoreAngle", "${score.roundToInt()}"+"%"+" Your=${answer.toInt()}/Real=${alfa.toInt()}")

            startActivity(next)
        }
    }
}