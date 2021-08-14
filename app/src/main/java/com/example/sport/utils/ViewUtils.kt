package com.example.sport.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.sport.R

class ViewUtils {



    fun TextView.textOrGone(id:Int= R.string.empty_with_variables, texto:String?) {
        if (texto.isNullOrBlank() || texto=="0" ){
            visibility= View.GONE
        }else{

            this.setText(context.getString(id,texto))

        }
    }
}