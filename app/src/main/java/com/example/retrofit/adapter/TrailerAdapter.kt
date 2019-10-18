package com.example.retrofit.adapter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.POJO.Trailers
import com.example.retrofit.POJO.Upcoming
import com.example.retrofit.R
import com.example.retrofit.activities.DetailActivity
import com.example.retrofit.utils.EndPoints
import com.squareup.picasso.Picasso

class TrailerAdapter (c: FragmentActivity?, data: List<Trailers.Data>?): RecyclerView.Adapter<TrailerAdapter.ViewHolder>() {

    var mTrailerData: List<Trailers.Data>? = data
    var mContext: Context? = c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(mContext).inflate(R.layout.trailer_item, parent, false)
         return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mTrailerData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trailerData: Trailers.Data = mTrailerData!![position]

        Picasso.get().load("http://img.youtube.com/vi/${trailerData.key}/hqdefault.jpg").into(holder!!.imgTrailer)

        holder.imgTrailer.setOnClickListener { watchYoutube(trailerData.key) }
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var imgTrailer = itemView?.findViewById<View>(R.id.iv_trailer) as ImageView
    }

    private fun watchYoutube(id: String?){
        val appIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))

        try{
            mContext!!.startActivity(appIntent)
        }catch (ex: ActivityNotFoundException){
            mContext!!.startActivity(webIntent)
        }
    }

}