package com.example.mykotlindemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils

@Route(path = RouterPath.Test.TEST_FUNCTION)
class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        testParams("is test")
//
//        var array = arrayOf("a","b","c","d")
//        testParamsArray(num=3,strArray = *array,str = "aaa")


//        testStringOut()
//        testStringFind()
//        testStringSubString()
//        testStringReplace()
//        testStringSplit()
        testStringCount()
    }



    private fun testParams(str:String = "this is str", a : Int =1){
        Utils.print("$str $a")
    }


    private fun testParamsArray(num: Int = 2, str:String,vararg strArray: String){
        Utils.print("num = $num   str = $str")

        for(item in strArray){
            Utils.print(item)
        }
    }




    private var str = "kotlin is a very a good"
    private fun testStringOut(){

        Utils.print("输出第一个参数： ${str.first()}")
        Utils.print("输出最后一个参数： ${str.last()}")
        Utils.print("输出符合条件第一个： ${str.firstOrNull { it == 'o' }}")
    }

    private fun testStringFind(){
        Utils.print("查找字符串位置 使用indexOf方法： ${str.indexOf("o",0)}")
        Utils.print("查找字符串最后位置 使用lastIndexOf方法： ${str.lastIndexOf("o")}")
    }

    private fun testStringSubString(){
        Utils.print("截图字符串： ${str.substring(10)}")
        Utils.print("截图字符串： ${str.substring(0,10)}")
        Utils.print("截图字符串： ${str.substring(IntRange(0,10))}")
    }

    private fun testStringReplace(){
        Utils.print("替换字符串： ${str.replace('i','I')}")
        Utils.print("替换第一个字符串： ${str.replaceFirst('i','I')}")
        Utils.print("裁掉字符之前部分 并在前边拼接新字符串： ${str.replaceBefore('a',"cc")}")
        Utils.print("裁掉字符最后出现位置之前部分 并在前边拼接新字符串： ${str.replaceBeforeLast("a","cc")}")
        Utils.print("裁掉字符出现位置之后部分 并在后边拼接新字符串： ${str.replaceAfter("a","cc")}")
        Utils.print("裁掉字符最后出现位置之后部分 并在后边拼接新字符串： ${str.replaceAfterLast("a","cc")}")

    }

    private fun testStringSplit(){
        var list = str.split("a")
        for(item in list){
            Utils.print("分割字符串： $item")
        }
    }

    private fun testStringCount(){
        Utils.print("字符出现次数: ${str.count { it == 'o' }}")
    }
}