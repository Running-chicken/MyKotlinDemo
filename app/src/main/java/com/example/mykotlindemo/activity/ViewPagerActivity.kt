package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mykotlindemo.R
import com.example.mykotlindemo.adapter.ViewPagerAdapter
import com.example.mykotlindemo.databinding.ActivityViewPagerBinding
import com.example.mykotlindemo.fragment.Demo1Fragment
import com.example.mykotlindemo.utils.RouterPath

@Route(path = RouterPath.Technology.TECH_VP)
class ViewPagerActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityViewPagerBinding

    var frament1:Demo1Fragment = Demo1Fragment()
    var frament2:Demo1Fragment = Demo1Fragment()

    var titles:MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView<ActivityViewPagerBinding>(this,R.layout.activity_view_pager)

        titles.add("title1")
        titles.add("title2")


        var adapter = ViewPagerAdapter(supportFragmentManager,titles)
        adapter.addFragemnt(frament1)
        adapter.addFragemnt(frament2)

        mBinding.vpDemo.adapter = adapter

        mBinding.tbVp.setupWithViewPager(mBinding.vpDemo)



    }
}