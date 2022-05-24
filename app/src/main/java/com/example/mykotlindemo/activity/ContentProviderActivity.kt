package com.example.mykotlindemo.activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mykotlindemo.R
import com.example.mykotlindemo.databinding.ActivityContentProviderBinding
import com.example.mykotlindemo.utils.Utils

class ContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mBinding = DataBindingUtil.setContentView<ActivityContentProviderBinding>(this,R.layout.activity_content_provider)


        var contentResolver = this.contentResolver
        var cursor = contentResolver.query(Uri.parse("content://com.cc.myprovider/user"),null,null,null,null,null)
        if (cursor != null) {
            while (cursor.moveToNext()){
                Utils.print(cursor.getString(1))
            }
        }

    }
}