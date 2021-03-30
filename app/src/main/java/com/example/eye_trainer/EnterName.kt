package com.example.eye_trainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_enter_name.*

class EnterName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_name)

        submit_name.setOnClickListener {
            val game = Intent(this, AngleGame::class.java)
            game.putExtra("name", editText.text.toString())
            startActivity(game)
        }

    }
}