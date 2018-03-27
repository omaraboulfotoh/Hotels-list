package com.omar.tajawaltask.modules.hotelslist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.omar.tajawaltask.R
import com.omar.tajawaltask.app.App
import com.omar.tajawaltask.app.data.Hotel
import com.omar.tajawaltask.modules.hoteldetails.HotelDetailsActivity
import com.omar.tajawaltask.utiles.ItemClickListener
import javax.inject.Inject

class HotelsListActivity : AppCompatActivity(), HotelListContract.View, View.OnClickListener
        , SwipeRefreshLayout.OnRefreshListener, ItemClickListener {

    val Activity.app: App
        get() = application as App
    val component by lazy { app.component.plus(HotelsListModule(this)) }

    @Inject
    lateinit var mPresenter: HotelsListPresenter

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var hotelsAdapter: HotelsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels_list)
//        inject
        component.inject(this)

//        init views
        toolbar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.rv_hotels)
        swipeRefresh = findViewById(R.id.swipe_refresh)
        mPresenter.start()

    }

    override fun init() {
        toolbar.getChildAt(0).setOnClickListener(this)
        swipeRefresh.setOnRefreshListener(this)
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        hotelsAdapter = HotelsAdapter(this)
        hotelsAdapter.itemClickListener = this
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = hotelsAdapter;

        mPresenter.loadHotels()
    }

    override fun setHotels(arrayList: ArrayList<Hotel>) {
        hotelsAdapter.setData(arrayList)
    }

    override fun refresh() {
        hotelsAdapter.clear()
    }

    override fun navigateToHotel(hotel: Hotel) {
        val intent = Intent(this, HotelDetailsActivity::class.java)
        intent.putExtra("hotel", hotel)
        startActivity(intent)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh.isRefreshing = false
    }

    override fun onClick(v: View?) {
        onBackPressed()
    }

    override fun onRefresh() {
        mPresenter.refresh()
    }

    override fun onItemClicked(position: Int) {
        navigateToHotel(hotelsAdapter.getData()[position])
    }
}
