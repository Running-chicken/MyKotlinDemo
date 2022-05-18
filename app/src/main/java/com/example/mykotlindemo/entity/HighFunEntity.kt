package com.example.mykotlindemo.entity

fun main() {


    login("can","1234") {
        if (it) {
            println("登录成功")
        } else {
            println("登录失败")

        }
    }


    "zhenzhen".derry()
}

private fun login(username:String,password:String,/*第三个参数是函数  声明 参数Boolean 返回空*/ responseResult: (Boolean)->Unit ){
    if(username == "can" && password == "1234"){
        responseResult(true)
    }else{
        responseResult(false)
    }
}



