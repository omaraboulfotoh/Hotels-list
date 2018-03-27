package com.omar.tajawaltask.dagger

import com.omar.tajawaltask.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app
}