package com.example.eye_trainer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.tan
import kotlin.random.Random

class CanvasViewSquare @JvmOverloads constructor(context: Context,
                                                attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val centerX: Float = 5.0F
    val centerY: Float = 5.0F
    val width: Float = 250.0F
    var scale: Float = 0.0F
    var flag = 0
    fun calculate(){
        this.scale = Random.nextInt(10,100).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val black = Paint(Paint.ANTI_ALIAS_FLAG)
        val white = Paint()
        white.setARGB(255, 138, 36, 36)

        if (this.flag == 0){
            calculate()
            this.flag = 1
        }

        //canvas?.drawText(this.scale.toString(), 150F,150F,paint)
        canvas?.drawRect(centerX, centerY, centerX+width, centerY+150F, black)
        canvas?.drawRect(centerX+1, centerY+1, centerX+(width*scale/100), centerY+148F, white)
        //canvas?.drawLine(centerX, centerY, centerX+width, centerY, paint)
        //canvas?.drawLine(centerX, centerY+50.0f, centerX+width*this.scale, centerY+50.0f, paint)

    }

}