package com.example.eye_trainer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.tan
import kotlin.random.Random

class CanvasView @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val centerX: Float = 110.0F
    val centerY: Float = 110.0F
    val width: Float = 100.0F
    val hieght: Float = -100.0F
    var pointX: Float = 0.0F
    var pointY: Float = 0.0F
    var alfa: Double = 0.0
    var flag = 0
    fun calculate(){
        this.alfa = Random.nextDouble(0.01, Math.PI)


        if (this.alfa >= 0.01 && this.alfa <= Math.PI/4){
            this.pointY = -100 * tan(this.alfa.toFloat())
            this.pointX = width
        } else if (this.alfa > Math.PI/4 && this.alfa <= Math.PI*3/4){
            this.pointY = -100F
            this.pointX = 100F * cos(this.alfa.toFloat())
        } else{
            this.pointY = 100F * tan(this.alfa.toFloat())
            this.pointX = -100F
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        if (this.flag == 0){
            calculate()
            this.flag = 1
        }

        //canvas?.drawText((this.alfa*180/Math.PI).toString(), 150F,150F,paint)
        canvas?.drawLine(centerX, centerY, centerX+width, centerY, paint)
        canvas?.drawLine(centerX, centerY, centerX+pointX, centerY+pointY, paint)

    }

}