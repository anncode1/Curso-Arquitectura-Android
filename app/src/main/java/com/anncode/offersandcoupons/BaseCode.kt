package com.anncode.offersandcoupons

/*
*
*
* MainActivity.kt
val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons)
rvCoupons.layoutManager = LinearLayoutManager(this)
val coupons = ArrayList<Coupon>()

val apiService = getClientService()
val call = apiService.getCoupons()

call.enqueue(object : Callback<JsonObject> {
    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
        Log.e("ERROR: ", t.message)
        t.stackTrace
    }

    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
        val offersJsonArray = response.body()?.getAsJsonArray("offers")
        offersJsonArray?.forEach { jsonElement: JsonElement ->
            var jsonObject = jsonElement.asJsonObject
            var coupon = Coupon(jsonObject)
            coupons.add(coupon)
        }
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)

    }


})


val apiKey = "69d1837829128f9565368ca704c63207"
val urlApi = "http://feed.linkmydeals.com/"

fun getClientService(): ApiService {
    val authInterceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder()
            .addQueryParameter("API_KEY", apiKey)
            .addQueryParameter("format", "json")
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(url)
            .build()

        chain.proceed(newRequest)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor).build()

    val retrofit = Retrofit.Builder()
        .baseUrl(urlApi)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return  retrofit.create(ApiService::class.java)
}

interface ApiService {
    @GET("getOffers/")
    fun getCoupons(): Call<JsonObject>
}

* */