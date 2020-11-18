package com.frodinm.ads_android_test.ui.capture

import android.content.Context
import android.graphics.drawable.Icon
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.frodinm.ads_android_test.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.viewmodel.ext.android.getViewModel

class TimeCaptureView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): ConstraintLayout(context,attrs,defStyleAttr) {

    private val viewModel: TimeCaptureViewModel by lazy {
        (context as FragmentActivity).getViewModel()
    }

    init {
        setupUi()
    }

    private fun setupUi(){

        background = AppCompatResources.getDrawable(context,R.color.cyan)

        val timestamp1TextView = TextView(context,null,0)
        timestamp1TextView.id = View.generateViewId()
        timestamp1TextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)

        viewModel.timeStamp1.observe(context as FragmentActivity, {
            timestamp1TextView.text = String.format(context.getString(R.string._1), it)
        })

        val timestamp2TextView = TextView(context,null,0)
        timestamp2TextView.id = View.generateViewId()
        timestamp2TextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)

        viewModel.timeStamp2.observe(context as FragmentActivity, {
            timestamp2TextView.text = String.format(context.getString(R.string._2), it)
        })

        val timestamp3TextView = TextView(context,null,0)
        timestamp3TextView.id = View.generateViewId()
        timestamp3TextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)

        viewModel.timeStamp3.observe(context as FragmentActivity, {
            timestamp3TextView.text = String.format(context.getString(R.string._3), it)
        })

        val timestamp4TextView = TextView(context,null,0)
        timestamp4TextView.id = View.generateViewId()
        timestamp4TextView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)

        viewModel.timeStamp4.observe(context as FragmentActivity, {
            timestamp4TextView.text = String.format(context.getString(R.string._4), it)
        })

        val floatingActionButton = FloatingActionButton(context,null,0)
        floatingActionButton.id = View.generateViewId()
        floatingActionButton.background = AppCompatResources.getDrawable(context,R.color.pink)
        floatingActionButton.setImageIcon(Icon.createWithResource(context,R.drawable.ic_check_mark))
        floatingActionButton.setOnClickListener {
            viewModel.handleFabClick()
        }

        addView(timestamp1TextView)

        val constraintLayout = this

        with(ConstraintSet()) {
            clone(constraintLayout)
            connect(timestamp1TextView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,0)
            connect(timestamp1TextView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,0)
            applyTo(constraintLayout)
        }

        addView(timestamp2TextView)

        with(ConstraintSet()) {
            clone(constraintLayout)
            connect(timestamp2TextView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,0)
            connect(timestamp2TextView.id, ConstraintSet.TOP, timestamp1TextView.id, ConstraintSet.BOTTOM,0)
            applyTo(constraintLayout)
        }

        addView(timestamp3TextView)

        with(ConstraintSet()) {
            clone(constraintLayout)
            connect(timestamp3TextView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,0)
            connect(timestamp3TextView.id, ConstraintSet.TOP, timestamp2TextView.id, ConstraintSet.BOTTOM,0)
            applyTo(constraintLayout)
        }

        addView(timestamp4TextView)

        with(ConstraintSet()) {
            clone(constraintLayout)
            connect(timestamp4TextView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START,0)
            connect(timestamp4TextView.id, ConstraintSet.TOP, timestamp3TextView.id, ConstraintSet.BOTTOM,0)
            applyTo(constraintLayout)
        }

        addView(floatingActionButton)

        with(ConstraintSet()) {
            clone(constraintLayout)
            connect(floatingActionButton.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END,0)
            connect(floatingActionButton.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,0)
            applyTo(constraintLayout)
        }


    }



}