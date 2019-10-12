package sample.qiitaclient

import android.content.Context
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

@BindingAdapter("app:imageUrl")
fun ImageView.loadImage(url: String) = Glide.with(context).load(url).into(this)

@BindingAdapter("app:loadUrl")
fun WebView.loadUrl(url: String) = loadUrl(url)
