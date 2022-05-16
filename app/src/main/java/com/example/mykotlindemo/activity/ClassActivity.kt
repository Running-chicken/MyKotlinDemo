package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mykotlindemo.entity.DemoAbstractSon
import com.example.mykotlindemo.entity.DemoEnum
import com.example.mykotlindemo.entity.DemoInner
import com.example.mykotlindemo.entity.DemoInner.OnClickListener
import com.example.mykotlindemo.entity.DemoTest
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils

fun test(){

}

private fun test1(){

}

internal fun test2(){

}



@Route(path = RouterPath.Test.TEST_CLASS)
class ClassActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var test = Test(1,"kotlin")
//        var test1 = TestDefault()
//        var test2 = TestDefault(1,2)

//        testInterface()


//        testJiCheng()

//        testEnum()

//        outPerson()
//        defaultData()
//        testAbstract()
        testInner()
    }

    private fun testInner(){
        var demoInner = DemoInner()
        demoInner.setOnClickListener(object : OnClickListener{
            override fun setOnItemClickListener(str: String) {
                Utils.print(str)
            }
        })
        demoInner.testOnClick()
    }

    private fun testAbstract(){
        var demoAbstractSon = DemoAbstractSon()
        demoAbstractSon.init()
        DemoAbstractSon.HasSon().init()
    }

    private fun defaultData(){
        val pair = Pair(1,3)
        Utils.print("输出： ${pair.toString()}")
        Utils.print("输出List： ${pair.toList()}")

        val triple = Triple("a",1,false)
        Utils.print("输出： ${triple.toString()}")
        Utils.print("输出List： ${triple.toList()}")
    }

    private fun outPerson(){
        val person = com.example.mykotlindemo.entity.Person("cc",29,180.5)
        val(name,age) = person
        Utils.print("参数1： $name   参数2：$age")

        Utils.print("姓名是： ${person.name}")
        person.name = "zz"
        Utils.print("直接改参数姓名是： ${person.name}")

        val newperson = person.copy(name = "zz")
        Utils.print("copy姓名是： ${newperson.name}")
    }

    private fun testInterface(){
        var demoTest = DemoTest()
        demoTest.testFun1()

        demoTest.testFun5()

        Utils.print("result  = ${demoTest.result()}")
    }

    private fun testSet(){

        var person = Person()
        person.name = 11
        Utils.print("name = ${person.name}")
    }

    private fun testJiCheng(){
        Utils.print(DemoTest().foo())
        Utils.print(DemoTest().bar())

        var demoTest = DemoTest()
        demoTest.str = "cc"
        Utils.print(demoTest.str)

        demoTest.testSame()
    }

    private fun testEnum(){
        Utils.print("name = ${DemoEnum.NORMAL.name}  code=${DemoEnum.NORMAL.ordinal}")
        Utils.print("name = ${enumValues<DemoEnum>().joinToString { it.name }}")
        Utils.print("name = ${enumValueOf<DemoEnum>("NORMAL")}")
        Utils.print("name = ${DemoEnum.values()[0]}")
        Utils.print("name = ${DemoEnum.valueOf("NORMAL")}")
    }

    class Test (var num:Int){
        init {
            Utils.print("初始化： $num")
        }
        constructor(num: Int, str:String) : this(num){
            Utils.print("二级构造方法： $num   $str")
        }
    }

    class TestDefault(num:Int = 8){
        init {
            Utils.print("带默认1参数初始化：$num")
        }
        constructor(num1: Int = 10,num2: Int = 12) : this(num1){
            Utils.print("带默认2参数构造方法：$num1   $num2")
        }
    }



    class Person(){
        var name = 0
        set(value) {
            field = value
        }
    }
}