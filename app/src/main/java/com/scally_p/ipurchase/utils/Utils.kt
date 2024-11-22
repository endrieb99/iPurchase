package com.scally_p.ipurchase.utils

import android.annotation.SuppressLint
import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.scally_p.ipurchase.R
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object Utils {

    @SuppressLint("SimpleDateFormat")
    fun formatDate(strDate: String): String {
        var format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return try {
            val newDate = format.parse(strDate) ?: return strDate
            format = SimpleDateFormat("dd MMM yyyy, HH:mm")
            return format.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            strDate
        }
    }

    fun launchChromeCustomTab(context: Context, url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .addDefaultShareMenuItem()
            .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setShowTitle(true)
            .setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_left)
            .setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right)
            .build()
        CustomTabsHelper.addKeepAliveExtra(context, customTabsIntent.intent)

        CustomTabsHelper.openCustomTab(
            context, customTabsIntent,
            Uri.parse(if (url.startsWith("www")) "http://$url" else url),
            WebViewFallback()
        )
    }

    fun playNotificationSound(context: Context) {
        try {
            val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(context, notification)
            r.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun vibratePhone(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    200,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            vibrator.vibrate(200)
        }
    }
}