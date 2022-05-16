package com.example.mykotlindemo.entity

class DemoInner {


    interface OnClickListener{
        fun setOnItemClickListener(str : String)
    }

    lateinit var listener : OnClickListener
    fun setOnClickListener(listener : OnClickListener){
        this.listener = listener
    }
    fun testOnClick(){
        listener.setOnItemClickListener("这是一个匿名内部类")
    }



}