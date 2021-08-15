package com.example.sport.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.sport.R

class ViewUtils {

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageUrl")
        fun ImageView.setImageUrl(url:String){
            Glide.with(this.context)
                .load(url)
                .placeholder(R.drawable.ic_baseline_sports_basketball_24)
                .into(this)
        }

    }

    fun TextView.textOrGone(id:Int= R.string.empty_with_variables, texto:String?) {
        if (texto.isNullOrBlank() || texto=="0" ){
            visibility= View.GONE
        }else{

            this.setText(context.getString(id,texto))

        }
    }



}