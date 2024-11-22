package com.scally_p.ipurchase

import android.app.Application
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.scally_p.ipurchase.data.local.RealmConfig
import com.scally_p.ipurchase.di.getModules
import org.koin.android.ext.koin.androidContext
import io.realm.Realm
import org.koin.core.context.startKoin

class iPurchaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        configureRealm()
        startKoin()
        startPython()
    }

    private fun configureRealm() {
        Realm.init(this)
        val config = RealmConfig.getConfig()
        Realm.setDefaultConfiguration(config)
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@iPurchaseApp)
            modules(getModules())
        }
    }

    fun startPython() {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
    }
}