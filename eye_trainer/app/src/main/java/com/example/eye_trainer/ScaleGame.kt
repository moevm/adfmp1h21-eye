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

            val rec = Intent(this, Records::class.java)

            rec.putExtra("name", intent.getStringExtra("name"))
            rec.putExtra("scoreAngle", intent.getStringExtra("scoreAngle"))
            val scale = canvasView.scale
            val answer = answer.text.toString().toDouble()
            var score = 100*answer/scale
            if (score > 100){
                score = 100*scale/answer
            }
            val scale2digits:Double = Math.round(scale * 100.0) / 100.0
            rec.putExtra("scoreScale", "${score.roundToInt()}"+"%"+" Your=${answer}/Real=${scale2digits}")

            startActivity(rec)
        }
    }
}