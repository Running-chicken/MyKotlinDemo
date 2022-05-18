package com.example.mykotlindemo.testfun


fun main(){


    var account = Account("cuican",10000f)
    var accountOperator = AccountOperator(account)
    var threadArrays = Array(5){Thread()}
    for(i in 0..4){
        threadArrays[i] = Thread(accountOperator,"Thread $i")
        threadArrays[i].start()
    }

}
