package com.example.mykotlindemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mykotlindemo.R
import com.example.mykotlindemo.databinding.VpDemoItemBinding

class Demo1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var mBinding = DataBindingUtil.inflate<VpDemoItemBinding>(inflater,R.layout.vp_demo_item,container,false)
        return mBinding.root
    }

}