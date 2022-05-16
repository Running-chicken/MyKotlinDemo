package com.example.mykotlindemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mykotlindemo.utils.Constants
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils

@Route(path = RouterPath.Test.TEST_CONDITION)
class ConditionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testIfElse()
        testFor()
        testIterator()
        testWhen()
    }

    private fun testIfElse(){
        var numA = 5
        var numB = if(numA<2) 3 else 5
        var numC =
            if(numA<2){
                100
            }else{
                numA++
                numA
            }

        Utils.print("条件语句数值B:$numB")
        Utils.print("条件语句数值C:$numC")
    }


    private fun testFor(){
        for(i in 0 until 5){
            Utils.print("for循环递增不包含：$i");
        }
        for(i in 15 downTo 11){
            Utils.print(Constants.TAG + "for循环递减包含：$i");
        }
        for(i in 0 .. 5){
            Utils.print(Constants.TAG + "for循环递增全包含：$i");
        }

        for(i in 0 .. 10 step 2){
            Utils.print("for循环递增 步长2 包含：$i");

        }

        var array = arrayOf(2,4,6,7,10)
        for(i in array.indices){
            Utils.print("for循环数组indices 可打印坐标:$i ==" + array[i])
        }


        for((index,value) in array.withIndex()){
            Utils.print("for循环数组withIndex 可打印坐标和value: $index == $value")
        }

    }


    private fun testIterator(){
        var array = arrayOf(2,"1",false,3.5)
        var iterator : Iterator<Any> = array.iterator()
        while (iterator.hasNext()){
            Utils.print("测试迭代器： ${iterator.next()}")
        }

    }

    private fun testWhen(){
        when(5){
            1 -> Utils.print("when语句: 1")
            2 -> Utils.print("when语句2")
            5 -> Utils.print("when语句5")
            else -> Utils.print("when语句 10")

        }
        when(1){
            1,2,3 -> Utils.print("when逗号分隔： 1")
            4 -> Utils.print("when逗号分隔： 4")
            else -> Utils.print("when逗号分隔： 6")
        }

        var num = 5;
        when(num>5){
            true -> Utils.print("when条件： num>5")
            false -> Utils.print("when条件: num<=5")
            else -> Utils.print("when条件： num=5")
        }

        var array = arrayOf(1,2,3,4,5)
        when(1){
            in array.toIntArray() -> Utils.print("1在数组中")
            else -> Utils.print("都错了")
        }
        when(1){
            in 0..10 -> Utils.print("1在0到10中")
            else -> Utils.print("都错了")
        }
        when(1){
            !in 5..10 -> Utils.print("1不在5到10中")
            else -> Utils.print("都错了")
        }

        var str = "this is kotlin"
        when(str){
            is String -> Utils.print("$str 是字符串")
            else -> Utils.print("不是字符串")
        }

        var arrayString = arrayOfNulls<String>(4)
        for(i in arrayString){
            Utils.print("this is $i")
        }
    }


}