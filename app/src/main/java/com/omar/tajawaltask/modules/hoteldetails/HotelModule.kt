package com.omar.tajawaltask.modules.hoteldetails

import com.omar.tajawaltask.dagger.ActivityScopes
import dagger.Module
import dagger.Provides

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
@Module
class HotelModule(val activity: HotelDetailsActivity) {
    @Provides
    @ActivityScopes
    fun provideHotelsLstView(): HotelContract.View = activity

    @Provides
    @ActivityScopes
    fun provideHotelPresenter(view: HotelContract.View) = HotelPresenter(view)

}