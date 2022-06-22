package com.example.mykotlindemo.activity

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mykotlindemo.R
import com.example.mykotlindemo.databinding.ActivityContentProviderBinding
import com.example.mykotlindemo.entity.MyContentObserver
import com.example.mykotlindemo.utils.Utils

class ContentProviderActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityContentProviderBinding
    private lateinit var observer : MyContentObserver

    var handler:Handler = object : Handler(Looper.getMainLooper()) {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            mBinding.tvObserver.text = "${msg.obj}"
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityContentProviderBinding>(this,R.layout.activity_content_provider)


        mBinding.tvQueryAll.setOnClickListener {
            var contentResolver = this.contentResolver
            var cursor = contentResolver.query(Uri.parse("content://com.skill.my.provider/person/"),null,null,null,null,null)
            if (cursor != null) {
                while (cursor.moveToNext()){
                    Utils.print(cursor.getString(1))
                }
            }
        }

        observer = MyContentObserver(handler, this)
        val uri = Uri.parse("content://com.skill.my.provider/person")
        contentResolver.registerContentObserver(uri, false, observer)


    }

    override fun onDestroy() {
        super.onDestroy()
        contentResolver.unregisterContentObserver(observer)
    }
}