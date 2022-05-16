package com.example.mykotlindemo.entity

import android.view.View
import com.example.mykotlindemo.utils.Utils

class DemoAbstractSon : DemoAbstract() {


    override var name: String
        get() = "Kotlin"
        set(value) {}

    override fun init() {
        Utils.print("this is abstract fun")
    }

    class HasSon{
        fun init(){
            Utils.print("this is 内部类")
        }
    }


}