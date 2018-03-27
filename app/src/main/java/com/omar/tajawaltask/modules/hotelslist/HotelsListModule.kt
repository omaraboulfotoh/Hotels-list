package com.omar.tajawaltask.modules.hotelslist

import com.omar.tajawaltask.dagger.ActivityScopes
import dagger.Module
import dagger.Provides

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
@Module
class HotelsListModule(val activity: HotelsListActivity) {
    @Provides
    @ActivityScopes
    fun provideHotelsLstView(): HotelListContract.View = activity as HotelListContract.View

    @Provides
    @ActivityScopes
    fun provideHotelsListPresenter(view: HotelListContract.View) = HotelsListPresenter(view)

}