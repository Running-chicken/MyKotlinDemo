package com.example.mykotlindemo.entity

import com.example.mykotlindemo.utils.Utils

class DemoTest() : Demo(),DemoInterface {
    override fun foo(): String {
        return "fee"
    }


    override var str: String = "111"
    override fun testSame() {
        super<Demo>.testSame()
        super<DemoInterface>.testSame()
    }

    override fun testFun1() {
        Utils.print("this is interface 实现")
    }


    override var num:Int = 4

    fun result() : Int{
        return num
    }

}