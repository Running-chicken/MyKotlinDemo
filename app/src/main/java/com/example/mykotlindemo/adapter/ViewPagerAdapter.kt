package com.example.mykotlindemo.adapter

import android.content.Context
import androidx.fragment.app.*

class ViewPagerAdapter(var fragmentManager: FragmentManager,var titles:List<String>) :
    FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragments : MutableList<Fragment> = ArrayList()

    public fun addFragemnt(fragment: Fragment){
        fragments.add(fragment)
    }

    override fun getCount(): Int {
        return  fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return  fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}