package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mykotlindemo.utils.RouterPath
import com.example.mykotlindemo.utils.Utils

@Route(path = RouterPath.Test.TEST_CHARACTER)
class CharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        testCharacter()
        testQuestPoint()
        testFunctionBack()
        testLet()
        testEval()
    }

    private fun testCharacter(){
        var a = 10
        var b = 2
        var c = true
        Utils.print("+a = ${+a}  !c = ${!c}")
        Utils.print("+a = ${a.unaryPlus()}  -a = ${a.unaryMinus()}  !c=${c.not()}")


        var m = 5
        var n = 5
        Utils.print("m++= ${m.also { m.inc() }}   --n=${n.dec().also { n = it }}")
        Utils.print("a+b: ${a.plus(b)}    a-b: ${a.minus(b)}    a*b: ${a.times(b)}   a/b:${a.div(b)}  a%b: ${a.rem(b)} ")

        var d = 1
        var e = 2
        d+=e
        Utils.print("d+=e: $d ")


        //区间 同..
        var s = 3 in 0.rangeTo(10)
        Utils.print("s = $s")


        for(index in 0.rangeTo(10).step(2)){
            Utils.print("index = $index")
        }
    }


    /**
     * 使用?.判断非空
     */
    private fun testQuestPoint(){
        var a : Int? = 12
        a = null
        Utils.print("a = $a")

        var b : String? = "abcdefg"
        b = null
        Utils.print("b= ${b?.length}")

        var builder : Builder? = Builder()?.setName(null)?.setAge(29)?.setSex("男")
        Utils.print(builder.toString())

    }
    class Builder{
        private var name : String? = "Tom"
        private var age : Int? = 18
        private var sex : String? = "男"

        fun setName(name : String?) : Builder?{
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

    private fun testFunctionBack() : Int?{
        var str = "abfewfewf"
        Utils.print("测试方法返回值："+str?.length)
        return str?.length
    }

    private fun testLet(){
        var array = arrayOf(1,null,3,4,null,6,null,8,null,null)
//        for(index in array){
//            if(index == null){
//                continue
//            }
//            Utils.print("跳过空数组：$index")
//        }
        for(index in array){
            index?.let { Utils.print("let过滤后index = $it") }
        }
    }

    /**
     * ?:操作符 一般和？.配合使用  判断为空时返回默认值
     * eval 屏蔽安全操作符
     */
    private fun testEval(){
        var testStr : String ? = null
        var length = -1
        length = testStr?.length ?: 0
        Utils.print("length : $length")

        val num : Int? = "Kotlin" as? Int
        Utils.print("num = $num")
    }
}