package com.frodinm.ads_android_test.ui


import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(){

    fun showToast(resId: Int, args: List<String> = emptyList()) {
        if(args.isNotEmpty()){
            Toast.makeText(context, String.format(context?.getString(resId)!!, *args.toTypedArray()), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, context?.getString(resId), Toast.LENGTH_SHORT).show()
        }
    }
}