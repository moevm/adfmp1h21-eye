package com.example.eye_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_records.*

class Records : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        var db = DataBaseHandler(this)
        val score = (intent.getStringExtra("scoreAngle")?.toInt()?.plus(intent.getStringExtra("scoreScale")?.toInt()!!))?.plus(intent.getStringExtra("scoreSquare")?.toInt()!!)?.div(3)
        if (score != null) {
            db.updateData(intent.getStringExtra("name").toString(), score.toInt())
        }

        var data = db.readData()
        for (i in 0..data.size-1)
            name.append(data.get(i).name + " " + data.get(i).score + "\n")


        //name.text = intent.getStringExtra("name")
        //scoreAngle.text = intent.getStringExtra("scoreAngle")
        //scoreScale.text = intent.getStringExtra("scoreScale")

        delete.setOnClickListener {
            db.deleteData()
            name.text = ""
        }
        button2.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

        startAgain.setOnClickListener {
            val game = Intent(this, AngleGame::class.java)
            game.putExtra("name", intent.getStringExtra("name").toString())
            startActivity(game)
        }

    }
}
