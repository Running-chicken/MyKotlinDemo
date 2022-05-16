package com.example.mykotlindemo.entity

import com.example.mykotlindemo.utils.Utils

open class Demo {

    open var num = 1
    open fun foo() = "foo"
    open fun bar() = "bar"

    open val str = "kotlin"

    open fun testSame(){
        Utils.print("this is class fun")
    }
}