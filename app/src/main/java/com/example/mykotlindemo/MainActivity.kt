package com.example.mykotlindemo

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mykotlindemo.activity.TestOneActivity
import com.example.mykotlindemo.databinding.ActivityMainBinding
import com.example.mykotlindemo.utils.TAG



class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mBinding.tvOpenTestOne.setOnClickListener(View.OnClickListener {
            var intent = Intent()
            intent.setClass(this,TestOneActivity::class.java)
            startActivity(intent)
        })

//        test()
//        test1()
//        test2()
//        test3()
//        test4()
//        test5()
//        test6()
//        test7()
//        test8()
//        test9()
//        test10()
//        test11()
//        test12()
//        test13()
//        test14()
        testParams()
        testParams("cc",20)
    }

    //int 类型
    var a = 10

    /**String类型*/
    private var b : String = "100"

    var c : Int = 50
    private val d:Int=104

    private fun test(){

        a = 344
        c+=1
        println(TAG + "基础类型： var_a = $a \t var_b = $b \t var_c = $c \t val_d=$d")

    }


    private var a1:Int? = 0
    var b1:String? = null
    private fun test1(){
        println(TAG + "可变类型： var_a = $a1 \t var_b = $b1")
    }


    private val numValue : Int = 1280
    private val numValueBox : Int? = numValue
    private var result : Boolean = false
    private var resultThree : Boolean = false
    private fun test2(){
        result = numValue==numValueBox
        println("$TAG 数值对比 = $result")

        resultThree = numValue===numValueBox
        println("$TAG 内存对比 = $resultThree")
    }


    private val str:String = "kotlin"
    private fun test3(){
        for(s in str){
            println("$TAG 依次输出string = $s")
        }
    }

    var str1:String = "hello \t kotlin"
    var str2:String = """ fun main(args: Array<String>){println("我是三重引号引用的字符串，我可以包含任意字符")} """
    private fun test4(){
        println("$TAG = $str1")
        println("$TAG = $str2")
    }

    var array1 = arrayOf(1,2,3)
    var array2 = arrayOf("1","2",3.32)
    var array3 = arrayOfNulls<Int>(3)
    var array4 = Array(5) { index -> (index * 2).toString() }
    private fun test5(){
        for(item in array1){
            println("$TAG 整型数组 : $item")
        }
        for(item in array2){
            println("$TAG 任意类型数组： $item")
        }
        for(item in array3){
            println(TAG + "空数组：" + item)
        }
        for(item in array4){
            println(TAG +"intex*2数组："+ item)
        }
    }


    var numA = 1
    var numB = if(numA<2) 3 else 5
    var numC = if(numA>2){
        numB
    }else{
        numA++
        numA = 30
        numA
    }
    private fun test6(){
        Log.i(TAG, "条件语句:$numB")
        Log.i(TAG,"条件块:$numC")
    }


    private fun test7(){
//        for(i in 0 until 5){
//            println(TAG + "for循环递增："+i);
//        }
//        for(i in 15 downTo 11){
//            println(TAG + "for循环递减："+i);
//        }
//        for(i in 0 .. 5){
//            println(TAG + "for循环递增："+i);
//        }

//        for(i in 0 .. 10 step 2){
//            println(TAG + "for循环递增："+i);r array = arrayOf(1,3,5,7,9)
////        for(i in array.indices){
////            println(TAG+"for循环数组:$i " + array[i])
////        }
//        }
//        va

        var array1 = arrayOf(2,4,6,7,10)
        for((index,value) in array1.withIndex()){
            Log.i(TAG,"for循环数组withIndex : $index == $value")
        }

    }


    private fun test8(){
        var array = arrayOf(2,"1",false,3.5)
        var iterator : Iterator<Any> = array.iterator()
        while (iterator.hasNext()){
            println(TAG + "测试迭代器： ${iterator.next()}")
        }

    }

    private fun test9(){
//        when(5){
//            1 -> println("$TAG when语句: 1")
//            2 -> println("$TAG : when语句2")
//            5 -> println("$TAG : when语句5")
//            else -> println(TAG + "when语句 10")
//
//        }
//        when(1){
//            1,2,3 -> println(TAG+"when逗号分隔： 1")
//            4 -> println(TAG+"when逗号分隔： 4")
//            5 -> println(TAG+"when逗号分隔： 5")
//            else -> println(TAG+"when逗号分隔： 6")
//        }

//        var num = 5;
//        when(num>5){
//            true -> println(TAG+"when条件： num>5")
//            false -> println(TAG+"when条件: num<5")
//            else -> println(TAG+"when条件： num=5")
//        }

//        var array = arrayOf(1,2,3,4,5)
//        when(1){
//            in array.toIntArray() -> print("1在数组中")
//            in 0..10 -> print("1在0到10中")
//            !in 5..10 -> print("1不在5到10中")
//            else -> print("都错了")
//        }
//        var str = "this is kotlin"
//        when(str){
//            is String -> print("$str 是字符串")
//            else -> print("不是字符串")
//        }
        var arrayString = arrayOfNulls<String>(4)
        for(i in arrayString){
            print("this is $i")
        }
    }

    private fun test10(){
        var a = 10
        var c = true
//        print("+a = ${+a}  !c = ${!c}")
//        print("+a = ${a.unaryPlus()}  -a = ${a.unaryMinus()}  !c=${c.not()}")


        var b = 2
//        print("a++= ${a.also { a.inc() }} --b=${b.dec().also { b = it }}")
//        print("a+b: ${a.plus(b)} a-b: ${a.minus(b)} a*b: ${a.times(b)} a/b:${a.div(b)}  a%b: ${a.rem(b)} ")
//        a+=b
//        try {
//            print("a+=b: $a ")
//        } catch (e: Exception) {
//            print(e.toString())
//        }
//
        var s = 3 in b.rangeTo(a)
        print("s = $s")

        for(index in b.rangeTo(a).step(2)){
            print("index = $index")
        }
    }

    private fun test11(){
        var a : Int? = 12
        a = null
        print("a = $a")

        var b : String? = "abcdefg"
        b = null
        print("b= ${b?.length}")

        var builder : Builder? = Builder().setName("cc")?.setAge(29)?.setSex("男")
        print(builder.toString())

    }
    class Builder{
        private var name : String? = "Tom"
        private var age : Int? = 18
        private var sex : String? = "男"

        fun setName(name : String) : Builder?{
            this.name = name
            return this
        }

        fun setAge(age : Int?) : Builder?{
            this.age = age
            return this
        }

        fun setSex(sex : String?) : Builder?{
            this.sex = sex
            return this
        }

        override fun toString(): String {
            return "Builder(name=$name age=$age sex=$sex)"
        }

    }

    private fun test12() : Int?{
        var str : String = "abfewfewf"
        print("测试方法返回值："+str?.length)
        return str?.length
    }

    private fun test13(){
        var array = arrayOf(1,null,3,4,null,6,null,8,null,null)
        for(index in array){
            if(index == null){
                continue
            }
            print("跳过空数组：$index")
        }
        for(index in array){
            index?.let { print("index = $it") }
        }
    }

    private fun test14(){
        var testStr : String ? = "null"
        var length =0
//        length = if(testStr!=null) testStr.length else 0
        length = testStr?.length ?: 0
        print("length:$length")

        val str : String? = null
//        print("test!! ${str!!.length}")

        val num : Int? = "Kotlin" as? Int
        print("num = $num")
    }

    private fun testParams(str:String = "this is str",a : Int =1){
        print("$str $a")
    }

    private fun print(msg:String){
        println(TAG + msg)
    }
}

