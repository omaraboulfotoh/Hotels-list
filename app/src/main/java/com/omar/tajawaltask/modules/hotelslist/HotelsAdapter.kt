package com.omar.tajawaltask.modules.hotelslist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.omar.tajawaltask.R
import com.omar.tajawaltask.app.data.Hotel
import com.omar.tajawaltask.utiles.ItemClickListener

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
class HotelsAdapter(private val context: Context)
    : RecyclerView.Adapter<HotelsAdapter.ViewHolder>() {

    lateinit var itemClickListener: ItemClickListener
    private val dataSet: ArrayList<Hotel> = ArrayList()
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val hotel = dataSet[position]
        viewHolder.textView.setText(hotel.summary.name)
        Glide.with(context).load(hotel.images[0].url).into(viewHolder.imageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_hotel, viewGroup, false)
        val viewHolder = ViewHolder(v)
        viewHolder.itemClickListener = itemClickListener
        return viewHolder
    }


    override fun getItemCount() = dataSet.size


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        lateinit var itemClickListener: ItemClickListener
        val textView: TextView
        val imageView: ImageView

        init {
            v.setOnClickListener { itemClickListener.onItemClicked(adapterPosition) }
            textView = v.findViewById(R.id.tv_hotel_title)
            imageView = v.findViewById(R.id.iv_hotel_img)
        }
    }

    fun setData(arrayList: ArrayList<Hotel>) {
        dataSet.addAll(arrayList)
        notifyDataSetChanged()
    }

    fun clear() {
        dataSet.clear()
        notifyDataSetChanged()
    }

    fun getData(): ArrayList<Hotel> {
        return dataSet
    }

}