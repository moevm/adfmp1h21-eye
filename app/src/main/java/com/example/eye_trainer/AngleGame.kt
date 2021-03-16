package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_angle_game.*

class AngleGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angle_game)

        button.setOnClickListener {
            val rec = Intent(this, Records::class.java)
            rec.putExtra("player", intent.getStringExtra("name"))
            rec.putExtra("score", "${answer.text.toString().toDouble()/90*100}")
            startActivity(rec)
        }
    }
}