package com.example.retrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.POJO.Upcoming
import com.example.retrofit.R
import com.example.retrofit.activities.DetailActivity
import com.example.retrofit.utils.EndPoints
import com.example.retrofit.utils.SquareLayout
import com.squareup.picasso.Picasso

class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    var mMovieData: List<Upcoming.UpcomingData>? = null
    var mContext: Context? = null

    constructor(c: FragmentActivity?, data: List<Upcoming.UpcomingData>?){
        this.mMovieData = data
        this.mContext = c

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(mContext).inflate(R.layout.upcoming_thumbnail,parent,false)

        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mMovieData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val upcomingData: Upcoming.UpcomingData = mMovieData!![position]

        Picasso.get().load(EndPoints.IMAGE_URL_POSTER + upcomingData.poster_path).into(holder!!.movieThumb)

        holder.squareLayout.setOnClickListener {
            val intent = Intent(mContext?.applicationContext, DetailActivity::class.java)
            intent.putExtra("id_movie", upcomingData.idMovie)
            intent.putExtra("title_movie", upcomingData.movieTitle)
            intent.putExtra("backdrop_movie", upcomingData.backdrop_path)
            intent.putExtra("overview_movie", upcomingData.overview)
            intent.putExtra("releasedate_movie", upcomingData.release_date)
            intent.putExtra("votesavarage_movie", upcomingData.vote_avarage)
            intent.putExtra("votecount_movie", upcomingData.vote_count)
            mContext!!.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var movieThumb = itemView?.findViewById<View>(R.id.upcoming_thumbnail) as ImageView
        var squareLayout = itemView?.findViewById<View>(R.id.sq_Upcoming) as SquareLayout
    }

}