package com.example.retrofit.POJO

import com.google.gson.annotations.SerializedName

class Trailers{

    @SerializedName("results")
    var trailers_result: List<Data>? = null

   class Data{
       @SerializedName("id")
       var id: String? = null

       @SerializedName("key")
       var key: String? = null

       @SerializedName("name")
       var name: String? = null

       @SerializedName("type")
       var type: String? = null

       @SerializedName("site")
       var site: String? = null
   }
}