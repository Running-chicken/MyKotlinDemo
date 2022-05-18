package com.example.mykotlindemo.testfun

class AccountOperator(var account: Account) :Runnable {

    override fun run() {

        synchronized(account){
            account.deposit(300f)
            account.withdraw(400f)
            println("test_kt ${Thread.currentThread().name} ${account.amount}")

        }
    }
}