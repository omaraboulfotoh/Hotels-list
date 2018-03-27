package com.omar.tajawaltask.modules.hoteldetails

import com.omar.tajawaltask.dagger.ActivityScopes
import dagger.Subcomponent

/**
 * Created by omaraboulfotoh on 3/27/18.
 */

@ActivityScopes
@Subcomponent(modules = arrayOf(HotelModule::class))
interface HotelComponent {
    fun inject(activity: HotelDetailsActivity)
}