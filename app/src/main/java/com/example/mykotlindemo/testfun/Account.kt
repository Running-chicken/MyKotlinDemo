package com.example.mykotlindemo.testfun

class Account(var name: String,var amount:Float) {

    fun deposit(amt: Float){
        amount+=amt
        Thread.sleep(100)
    }

    var withdraw : (amt:Float)->Unit = {
        amount-=it
        Thread.sleep(600)
    }

}