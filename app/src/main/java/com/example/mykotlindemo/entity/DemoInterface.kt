package com.example.mykotlindemo.entity

import com.example.mykotlindemo.utils.Utils

interface DemoInterface {
    fun testSame(){
        Utils.print("this is interface fun")
    }

    fun testFun1()

    fun testFun5(){}


    val num:Int
    get() = 3
}