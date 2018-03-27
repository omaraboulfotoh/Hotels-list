package com.omar.tajawaltask.dagger

import com.omar.tajawaltask.app.App
import com.omar.tajawaltask.modules.hoteldetails.HotelComponent
import com.omar.tajawaltask.modules.hoteldetails.HotelModule
import com.omar.tajawaltask.modules.hotelslist.HotelsListComponent
import com.omar.tajawaltask.modules.hotelslist.HotelsListModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent<T> {
    fun inject(app: App)
    fun plus(hotelListModule: HotelsListModule): HotelsListComponent
    fun plus(hotelModule: HotelModule): HotelComponent


}