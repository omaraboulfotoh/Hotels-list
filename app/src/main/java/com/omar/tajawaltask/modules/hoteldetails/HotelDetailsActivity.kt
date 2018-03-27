package com.omar.tajawaltask.modules.hoteldetails

import android.app.Activity
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.omar.tajawaltask.R
import com.omar.tajawaltask.app.App
import com.omar.tajawaltask.app.data.Hotel
import javax.inject.Inject


class HotelDetailsActivity : AppCompatActivity()
        , HotelContract.View, View.OnClickListener, OnMapReadyCallback {


    val Activity.app: App
        get() = application as App
    val component by lazy { app.component.plus(HotelModule(this)) }


    @Inject
    lateinit var mpresenter: HotelPresenter

    private lateinit var toolbar: Toolbar
    private lateinit var ivHotelImg: ImageView
    private lateinit var tvTittle: TextView
    private lateinit var tvPrice: TextView
    private lateinit var tvOldPrice: TextView
    private lateinit var tvAddress: TextView
    private lateinit var googleMap: GoogleMap
    private var lat: Double = 0.toDouble()
    private var lng: Double = 0.toDouble()
    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)
        component.inject(this)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
//        inti view
        toolbar = findViewById(R.id.toolbar)
        ivHotelImg = findViewById(R.id.iv_hotel_img)
        tvTittle = findViewById(R.id.tv_hotel_title)
        tvAddress = findViewById(R.id.tv_hotel_address)
        tvPrice = findViewById(R.id.tv_hotel_price)
        tvOldPrice = findViewById(R.id.tv_hotel_old_price)
        mpresenter.init()
    }

    override fun displayHotel(img: String, title: String, address: String, lowPrice: Double, highPrice: Double, lat: Double, lng: Double) {

        this.lat = lat
        this.lng = lng
        this.title = title

        toolbar.getChildAt(0).setOnClickListener(this)
        toolbar.setTitle(title)
        Glide.with(this).load(img).into(ivHotelImg)
        tvTittle.text = title
        tvAddress.text = address
//        set price
        tvPrice.text = "$lowPrice LE"
        tvOldPrice.text = "$highPrice LE"
        tvOldPrice.setPaintFlags(tvOldPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        setMarker(lat, lng)
    }

    private fun setMarker(lat: Double, lng: Double) {
        val sydney = LatLng(lat, lng)
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(lat, lng), 16f)

        googleMap?.addMarker(MarkerOptions().position(sydney)
                .title(title))
        googleMap.moveCamera(cameraUpdate)
    }

    override fun getHotel(): Hotel {
        return intent.extras.getParcelable("hotel")
    }

    override fun onClick(p0: View?) {
        onBackPressed()
    }

}
