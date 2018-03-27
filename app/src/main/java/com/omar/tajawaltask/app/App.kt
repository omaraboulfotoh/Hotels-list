package com.omar.tajawaltask.app

import android.app.Application
import com.omar.tajawaltask.dagger.AppComponent
import com.omar.tajawaltask.dagger.AppModule
import com.omar.tajawaltask.dagger.DaggerAppComponent

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
class App : Application() {
    val component: AppComponent<Any?> by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}