package com.example.eye_trainer

import android.content.Context
import org.junit.Test
import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun check_angle1(){
        val angle = AngleGame()
        val a = CanvasView(angle)
        a.calculate()
        assertTrue(a.alfa<Math.PI)
    }
    @Test
    fun check_angle2(){
        val angle = AngleGame()
        val a = CanvasView(angle)
        a.calculate()
        if (a.alfa >= 0.01 && a.alfa <= Math.PI/4)
            assertTrue(a.pointY < 0F)
    }
    @Test
    fun check_angle3(){
        val angle = AngleGame()
        val a = CanvasView(angle)
        a.calculate()
        if (a.alfa > Math.PI/4 && a.alfa <= Math.PI*3/4)
            assertTrue(a.pointX < 100F)
    }

    @Test
    fun check_scale1() {
        val scale = ScaleGame()
        val s = CanvasViewScale(scale)
        s.calculate()
        assertTrue(s.scale <= 5)

    }
    @Test
    fun check_scale2() {
        val scale = ScaleGame()
        val s = CanvasViewScale(scale)
        s.calculate()
        assert(s.scale>=0.5)
    }
}