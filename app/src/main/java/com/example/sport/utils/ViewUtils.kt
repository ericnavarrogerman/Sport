package com.example.sport.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
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
                .placeholder(R.drawable.ic_baseline_refresh_24)
                .error(R.drawable.ic_baseline_wifi_off_24)
                .into(this)
        }

        @JvmStatic
        @BindingAdapter("setTextFoundation")
        fun TextView.setFoundationYear( texto:String?) {
            if (texto.isNullOrBlank() || texto=="0" ){
                visibility= View.GONE
            }else{

                this.setText(context.getString(R.string.date_foundation,texto))

            }
        }

        @JvmStatic
        @BindingAdapter("setLink")
        fun ImageView.setLink( url:String?) {
            if (URLUtil.isValidUrl("http://$url")){
                var uri = Uri.parse("http://$url")
                var intent =Intent(Intent.ACTION_VIEW,uri)
                this.setOnClickListener {

                    try {
                        this.context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            this.context, "No application can handle this request."
                                    + " Please install a webbrowser", Toast.LENGTH_LONG
                        ).show()
                        e.printStackTrace()
                    }
                     }
            }else{
                visibility= View.GONE

            }
        }

    }


}