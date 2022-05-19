package com.example.mykotlindemo.view

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager

class MyViewPager : ViewPager {


    constructor(context: Context):super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var height = 0
        for(i in 0 until childCount){
            var childView = getChildAt(i)
            childView.measure(widthMeasureSpec,MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED))
            var childHeight = childView.measuredHeight
            if(childHeight>=height){
                height = childHeight
            }
        }

        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY))
    }
}