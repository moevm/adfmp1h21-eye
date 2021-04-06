package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scale_game.*
import kotlinx.android.synthetic.main.activity_scale_game.answer
import kotlinx.android.synthetic.main.activity_scale_game.button
import kotlinx.android.synthetic.main.activity_square_game.*
import kotlin.math.roundToInt

class SquareGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_game)

        button.setOnClickListener {

            val rec = Intent(this, Records::class.java)

            rec.putExtra("name", intent.getStringExtra("name"))
            rec.putExtra("scoreAngle", intent.getStringExtra("scoreAngle"))
            rec.putExtra("scoreScale", intent.getStringExtra("scoreScale"))
            val scale = canvasViewSquare.scale
            val answer = answer.text.toString().toDouble()
            var score = 100*answer/scale
            if (score > 100){
                score = 100*scale/answer
            }

            rec.putExtra("scoreSquare", "${score.roundToInt()}")

            startActivity(rec)
        }
    }
}