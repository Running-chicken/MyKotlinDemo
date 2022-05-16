package com.example.mykotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
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
    }



}

