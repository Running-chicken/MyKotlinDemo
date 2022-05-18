package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlindemo.utils.Utils

class LambdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val testLambda = {Utils.print("lambda无参数")}
//        testLambda()
//        test()


//        val tL : (Int,Int)->Int = {a,b->a+b}
//        val tL1 = {a:Int,b:Int -> a+b}
//        Utils.print("输出：${tL(3,5)}")
//        Utils.print("输出：${tL1(4,6)}")


//        Utils.print("结果为：${test(1,sum(2,3))}")

//        var array = arrayOf(1,2,3,6,8,12)
//        Utils.print("${array.filter { it>8 }.component1()}")

//        Utils.print("${test1(10) { it > 5 }}")


        testMap()
    }

    fun testMap(){
        val map = mapOf<String,String>("a" to "av","b" to "vb","c" to "vc")
        map.forEach { (key, value) -> Utils.print("$key,$value") }
        map.forEach { (_,value)->Utils.print(" $value") }
    }

    fun test(){
        Utils.print("源无参数")
    }

    fun test(a:Int,b:Int) : Int{
        return a+b
    }


    fun sum(num1:Int,num2:Int):Int{
        return num1+num2
    }

    fun testLambda(a:Int,b:(num1:Int,num2:Int)->Int):Int{
        return 1
    }

    fun test1(a:Int,b:(Int) -> Boolean) :Int{
        return if(b(a)) a else 0
    }



}