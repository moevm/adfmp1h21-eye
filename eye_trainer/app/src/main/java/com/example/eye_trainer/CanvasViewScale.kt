package com.example.eye_trainer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.tan
import kotlin.random.Random

class CanvasViewScale @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val centerX: Float = 110.0F
    val centerY: Float = 110.0F
    val width: Float = 50.0F
    var scale: Float = 0.0F
    var flag = 0
    fun calculate(){
        this.scale = Random.nextDouble(0.5, 5.0).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        if (this.flag == 0){
            calculate()
            this.flag = 1
        }

        //canvas?.drawText(this.scale.toString(), 150F,150F,paint)
        canvas?.drawLine(centerX, centerY, centerX+width, centerY, paint)
        canvas?.drawLine(centerX, centerY+50.0f, centerX+width*this.scale, centerY+50.0f, paint)

    }

}