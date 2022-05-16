package com.example.mykotlindemo.entity

import com.example.mykotlindemo.utils.Utils

sealed class SealedExpr{
    data class Student(var name:String,var age:Int) : SealedExpr()
    object Add : SealedExpr()
    companion object Minus : SealedExpr()
}

object NotANumber : SealedExpr()

fun eval(expr: SealedExpr) = when(expr){
    is SealedExpr.Student -> Utils.print("this is student")
    is SealedExpr.Add -> Utils.print("this is add")
    is SealedExpr.Minus -> Utils.print("this is minus")
    NotANumber -> Double.NaN
}
