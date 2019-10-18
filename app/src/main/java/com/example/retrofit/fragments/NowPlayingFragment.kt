package com.example.retrofit.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.retrofit.POJO.NowPlaying

import com.example.retrofit.R
import com.example.retrofit.adapter.NowPlayingAdapter
import com.example.retrofit.utils.EndPoints
import com.example.retrofit.utils.InitRetrofit
import kotlinx.android.synthetic.main.fragment_now_playing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_now_playing, container, false)
        var swipe = view.findViewById<View>(R.id.refresh_now_playing) as SwipeRefreshLayout

        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getNowPlayingData()
        }

        getNowPlayingData()

        return view
    }

    private fun getNowPlayingData(){
        var api = InitRetrofit().getInitInstance()
        var call = api.requestNowPlaying(EndPoints.API_KEY)
        call.enqueue(object: Callback<NowPlaying>{
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {

            }

            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                if(response != null){
                    if (response.isSuccessful){
                        var data = response.body()?.data
                        val adapter = NowPlayingAdapter(activity, data)
                        rv_now_playing.adapter = adapter
                        rv_now_playing.layoutManager = GridLayoutManager(activity, 2)
                    }
                }

            }
        })

    }

}
