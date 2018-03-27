package com.omar.tajawaltask.modules.hotelslist

import com.omar.tajawaltask.dagger.ActivityScopes
import dagger.Subcomponent

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
@ActivityScopes
@Subcomponent(modules = arrayOf(HotelsListModule::class))
interface HotelsListComponent {
    fun inject(activity: HotelsListActivity)
}