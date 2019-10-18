package com.example.retrofit.POJO

import com.google.gson.annotations.SerializedName

class NowPlaying {

    @SerializedName("results")
    var data : List<NowPlayingData>? = null

    inner class NowPlayingData{
        @SerializedName("popularity")
        val popularity: Double? = null

        @SerializedName("vote_count")
        val vote_count: Int? = null

        @SerializedName("video")
        val video: String? = null

        @SerializedName("poster_path")
        val poster_path: String? = null

        @SerializedName("id")
        val id: Int? = null

        @SerializedName("adult")
        val adult: Boolean? = null

        @SerializedName("backdrop_path")
        val backdrop_path: String? = null

        @SerializedName("original_language")
        val original_language: String? = null

        @SerializedName("original_title")
        val original_title: String? = null

        @SerializedName("title")
        val title: String? = null

        @SerializedName("vote_average")
        val vote_average: Double? = null

        @SerializedName("overview")
        val overview: String? = null

        @SerializedName("release_date")
        val release_date: String? = null


    }
}