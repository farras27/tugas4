package com.example.retrofit.POJO
import com.google.gson.annotations.SerializedName

class DetailMovie {

    @SerializedName("backdrop_path")
    val backdropPath: String? = null

    @SerializedName("budget")
    val budget: String? = null

    @SerializedName("genres")
    val genres: List<Genre>? = null

    class Genre {
        @SerializedName("id")
        val genreId: String? = null

        @SerializedName("name")
        val genre: String? = null
    }

    @SerializedName("vote_average")
    val vote_average: Double? = null

    @SerializedName("vote_count")
    val vote_count: Int? = null

    @SerializedName("homepage")
    val homepage: String? = null

    @SerializedName("original_title")
    val originalTitle: String? = null

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("production_companies")
    val productionCompanies: List<Company>? = null

    class Company {
        @SerializedName("id")
        val companyId: String? = null
        @SerializedName("name")
        val companyName: String? = null
    }

    @SerializedName("release_date")
    val releaseDate: String? = null

    @SerializedName("runtime")
    val runtime: String? = null
}