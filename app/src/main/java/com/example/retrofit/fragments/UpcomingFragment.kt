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
import com.example.retrofit.POJO.Upcoming

import com.example.retrofit.R
import com.example.retrofit.adapter.NowPlayingAdapter
import com.example.retrofit.adapter.UpcomingAdapter
import com.example.retrofit.utils.EndPoints
import com.example.retrofit.utils.InitRetrofit
import kotlinx.android.synthetic.main.fragment_now_playing.*
import kotlinx.android.synthetic.main.fragment_upcoming.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_upcoming, container, false)
        var swipe = view.findViewById<View>(R.id.refresh_upcoming) as SwipeRefreshLayout

        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getUpcoming()
        }

        getUpcoming()

        return view
    }

    private fun getUpcoming(){
        var api = InitRetrofit().getInitInstance()
        var call = api.requestUpcoming(EndPoints.API_KEY)
        call.enqueue(object: Callback<Upcoming> {
            override fun onFailure(call: Call<Upcoming>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Upcoming>, response: Response<Upcoming>) {
                if(response != null){
                    if (response.isSuccessful){
                        var data = response.body()?.data
                        val adapter = UpcomingAdapter(activity, data)
                        rv_upcoming.adapter = adapter
                        rv_upcoming.layoutManager = GridLayoutManager(activity, 2)
                    }
                }

            }
        })

    }

}
