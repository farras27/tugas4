package com.example.retrofit.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import com.bumptech.glide.Glide
import com.example.retrofit.POJO.DetailMovie
import com.example.retrofit.POJO.NowPlaying
import com.example.retrofit.adapter.NowPlayingAdapter
import com.example.retrofit.utils.EndPoints
import com.example.retrofit.utils.InitRetrofit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_now_playing.*
import kotlinx.android.synthetic.main.movie_about_description.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var id = intent.getIntExtra("id_movie",0)
//
//        var mMovieData: List<DetailMovie>? = null
//        var runtime = mMovieData
        getDetailData(id)
    }

    private fun ambilData() {
//        Picasso.get().load(EndPoints.IMAGE_URL_BACKDROP + intent.getStringExtra("backdrop_movie")).into(header_thubmnail)
//        tv_content_original_title?.text = intent.getStringExtra("title_movie")
//        toolbar_detail?.title = intent.getStringExtra("title_movie")
//        header_title?.text = intent.getStringExtra("votesavarage_movie")
//        votes_result?.text = intent.getStringExtra("votecount_movie")

//        tv_overview?.text = intent.getStringExtra("overview_movie")
//        votes_average?.text = intent.getStringExtra("votesavarage_movie")
//        release_year?.text = intent.getStringExtra("releasedate_movie")
//        tv_content_premier?.text = intent.getStringExtra("releasedate_movie")
//        tv_content_description?.text = intent.getStringExtra("overview_movie")


//        Glide.with(context).load(intent.getStringExtra("backdrop_movie")).into(header_thubmnail)

//        ?.text = intent.getStringExtra("email")
//        ?.text = intent.getStringExtra("telp")
//        ?.text = intent.getStringExtra("alamat")
    }

    private fun getDetailData(id: Int){
        var api = InitRetrofit().getInitInstance()
        var call = api.requestDetail(id,EndPoints.API_KEY)
        call.enqueue(object: Callback<DetailMovie> {

            override fun onFailure(call: Call<DetailMovie>, t: Throwable) {
            }
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<DetailMovie>, response: Response<DetailMovie>) {
                if(response != null){
                    if (response.isSuccessful){
                        val data = response.body()
                        votes_result?.text = data!!.vote_count.toString()
                        var rb = data!!.vote_average!!.toInt() * 5
                        rb_votes?.progress = rb
                        votes_average?.text = data!!.vote_average.toString()
                        toolbar_detail?.title = data!!.originalTitle
                        Picasso.get().load(EndPoints.IMAGE_URL_BACKDROP + data!!.backdropPath).into(header_thubmnail)
                        tv_overview?.text = data!!.overview
                        tv_content_description?.text = data!!.overview
                        tv_durasi?.text = data!!.runtime

                        toolbar_detail.setTitleTextColor(Color.WHITE)
                        toolbar_detail.setTitleTextColor(Color.WHITE)
                        toolbar_detail.setSubtitleTextColor(Color.WHITE)
                        toolbar_detail.setSubtitleTextColor(Color.WHITE)

                        release_year?.text = data!!.releaseDate
                        tv_content_premier?.text = data!!.releaseDate

                        tv_content_original_title?.text = data!!.originalTitle

                        
                        var type1 = data!!.genres!!.get(0).genre
                        tv_content_type?.text = type1

                        var companies1 = data!!.productionCompanies!!.get(0).companyName
                        tv_content_production?.text = companies1
                    }
                }

            }
        })
    }
}