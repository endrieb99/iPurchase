package com.scally_p.ipurchase.data.local

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(private val context: Context) {

    companion object {

        private val TAG = PrefsManager::class.java.simpleName

        private const val PREFS_FILE_NAME = "i_purchase_preferences"
        private const val ON_BOARDING_SEEN = "on_boarding_seen"
    }

    private val prefs: SharedPreferences by lazy {
        context.applicationContext.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clearPreferences() {
        prefs.edit().clear().apply()
    }

    var onBoardingSeen: Boolean
        get() {
            return prefs.getBoolean(ON_BOARDING_SEEN, false)
        }
        set(onBoardingSeen) {
            prefs.edit().putBoolean(ON_BOARDING_SEEN, onBoardingSeen).apply()
        }
}