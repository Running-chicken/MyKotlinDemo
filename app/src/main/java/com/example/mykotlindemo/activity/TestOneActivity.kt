package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlindemo.R

const val TAG = "test_kt"
class TestOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_one)

//        testParams("is test",isTrue =  false,num=20)
        var array = arrayOf("a","b","c","d")
        testParams1(num=3,*array)
    }

    private fun print(msg:String){
        println(com.example.mykotlindemo.TAG + msg)
    }

    private fun testParams(str:String,num :Int =1, isTrue : Boolean = false){
        print("$str  $num  $isTrue")
    }

    private fun testParams1(num: Int = 2, vararg str: String){
        for(item in str){
            print(item)
        }

    }


}