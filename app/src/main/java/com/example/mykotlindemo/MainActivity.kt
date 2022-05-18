package com.example.mykotlindemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mykotlindemo.activity.LambdaActivity
import com.example.mykotlindemo.activity.ListActivity
import com.example.mykotlindemo.databinding.ActivityMainBinding
import com.example.mykotlindemo.utils.RouterPath


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mBinding.tvParams.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_PARAMS).navigation()
        }

        mBinding.tvCondition.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CONDITION).navigation()
        }

        mBinding.tvCharacter.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CHARACTER).navigation()
        }

        mBinding.tvFunction.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_FUNCTION).navigation()
        }

        mBinding.tvClass.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Test.TEST_CLASS).navigation()
        }

        mBinding.tvLambda.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var intent = Intent()
                intent.setClass(this@MainActivity,LambdaActivity::class.java)
                startActivity(intent)
            }
        })

        mBinding.tvList.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var intent = Intent();
                intent.setClass(this@MainActivity,ListActivity::class.java)
                startActivity(intent)
            }
        })
    }



}

