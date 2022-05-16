package com.example.mykotlindemo

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.openDebug()
        ARouter.openLog()
        ARouter.init(this)
    }

}