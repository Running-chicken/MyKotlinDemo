package com.example.mykotlindemo.entity

fun main() {
    //KT 先有输入后有输出

    //Unit = void
    var method1 : () -> Unit  //声明

    var method2 : (Int,Int) -> Int //声明

    //Any = object
    var method3 : (String,Double) -> Any? //声明
    //String? 可以接收null
    //String  不可接收null 否则编译不通过
    var method4 : (Int,Double,Float,String?) -> Boolean //声明


    //无参数 无返回  输出文字
    val method01 = { println("this is cc")}
    method01()

    //无参数 返回String
    val method02 = {"this is cc"}
    println(method02())

    //有参数Int,Int 返回Sting
    val method03 = {num1:Int,num2:Int -> num1.toString()+num2.toString()}
    println(method03(1,2))

    //有参数Int,Int 返回Int
    val method04 = {num1:Int,num2:Int -> num1+num2}
    println(method04(2,2))

    //先声明 传入Int 返回String
    val method05 : (Int)->String
    //函数实现
    method05 = fun(value:Int) : String = value.toString()
    println(method05.invoke(99) + "cc")

    //声明+实现 参数Int,Int 返回String
    var method06 : (Int,Int)->String = fun(num1,num2)=num1.toString()+num2.toString()
    println(method06.invoke(10,10))

    //声明+实现 参数String,String 返回空
    var method07 : (String,String) -> Unit = {aStr,bStr -> println("aStr:$aStr bStr:$bStr")}
    method07.invoke("nihao","erge")

    //声明+实现 参数String 返回空  it关键字： 只有一个参数时，使用it
    var method08 : (String) -> Unit = {
        println("传入数据是： $it")
    }
    method08.invoke("me cc")


    //声明 传入Int 返回空   when：根据条件不同处理
    var method09 : (Int)->Unit = {
        when(it){
            1 -> println("你传入的是1")
            in 20..60 -> println("传入是20-60")
            else -> println("都不满足")
        }
    }
    method09.invoke(20)


    //声明 传入Int,Int 返回空   拒绝收值_  节约性能
    var method10 : (Int,Int)->Unit = { _,num2->
        println("传入参数$num2")
    }
    method10.invoke(20,30)


    //声明 传入Any 返回Any
    var method11 :(Any)->Any = {str -> str}
    println(method11("cc"))

    //传入char  使用if else
    var method12 = {sex:Char ->
        if(sex=='男') println("is yes") else println("is no")}
    method12('女')

    //扩展函数 无参数 无返回  可以在函数体使用this 对谁扩展 this就是谁本身
    var method13 : String.() ->Unit={
        println("$this 调用了我")}
    "cuican".method13()

    var mm : String.() -> Boolean={
        println(this)
        true
    }
    "cuicancan".mm()

//    fun<T> T.derry(mm : T.() -> Boolean) == mm()
}




