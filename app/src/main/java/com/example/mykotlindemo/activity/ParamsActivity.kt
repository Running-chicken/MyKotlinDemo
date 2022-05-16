package com.example.mykotlindemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils

@Route(path = RouterPath.Test.TEST_PARAMS)
class ParamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)
        testBase()
        testCanChange()
        testNum()
        testForString()
        testString()
        testArray()
    }


    /**基础类型*/
    private fun testBase(){
        var a = 10
        var b : String = "100"
        Utils.print("基础类型： var_a = $a  var_b = $b")

    }


    /**可变类型*/
    private fun testCanChange(){
        var a:Int? = 0
        var b:String? = null
        Utils.print("可变类型： var_a = $a  var_b = $b")
    }


    /**
     * 数值对比 内部对比
     */
    private fun testNum(){
        val numValue  = 128
        val numValueBox : Int? = numValue
        var result = false
        var resultThree = false
        result = numValue == numValueBox
        Utils.print("数值对比 = $result")

        resultThree = numValue === numValueBox
        Utils.print("内存对比 = $resultThree")
    }


    /**
     * 依次输出String
     */
    private val str:String = "kotlin"
    private fun testForString(){
        for(s in str){
            Utils.print("依次输出string = $s")
        }
    }

    /**
     * 三重引号内可以输入任意字符
     */
    private fun testString(){
        var str = """fun main(args: Array<String>){println("我是三重引号引用的字符串，我可以包含任意字符")}"""
        Utils.print("任意字符： $str")
    }

    /**
     * 输出数组
     */
    private fun testArray(){
        var array1 = arrayOf(1,2,3)
        var array2 = arrayOf("1","2",3.32)
        var array3 = arrayOfNulls<Int>(3)
        var array4 = Array(5) { index -> (index * 2).toString() }
        for(item in array1){
            Utils.print("整型数组 : $item")
        }
        for(item in array2){
            Utils.print("任意类型数组： $item")
        }
        for(item in array3){
            Utils.print("空数组：$item")
        }
        for(item in array4){
            Utils.print("根据数组index生成数据：$item")
        }
    }

}