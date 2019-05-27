package com.anncode.offersandcoupons

/*
*
* MODEL
*
* VIEW CONTROLLER
* MainActivity.kt

VIEW - CONTROLLER
val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons) //UI
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
//VIEW - CONTROLLER

// Network Resource MODEL

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
//MODEL
interface ApiService {
    @GET("getOffers/")
    fun getCoupons(): Call<JsonObject>
}
//MODEL

//VIEW - CONTROLLER
CouponDetailActivity.java

        couponSelected = intent.getSerializableExtra("COUPON") as Coupon

        var tvTitleDetail: TextView = findViewById(R.id.tvTitleDetail)
        var tvDescriptionShortDetail: TextView = findViewById(R.id.tvDescriptionShortDetail)
        var tvCategoryDetail: TextView = findViewById(R.id.tvCategoryDetail)
        var tvDateDetail: TextView = findViewById(R.id.tvDateDetail)
        var tvDescriptionDetailData: TextView = findViewById(R.id.tvDescriptionDetailData)
        var tvOffertDetailData: TextView = findViewById(R.id.tvOffertDetailData)
        var tvWebsiteDetailData: TextView = findViewById(R.id.tvWebsiteDetailData)
        var tvDateEndData: TextView = findViewById(R.id.tvDateEndData)
        var imgHeaderDetail: ImageView = findViewById(R.id.imgHeaderDetail)
        var imgCouponDetail: CircleImageView = findViewById(R.id.imgCouponDetail)
        var btnOpenOffer: Button = findViewById(R.id.btnOpenOffer)

        tvTitleDetail.text = couponSelected?.title
        tvDescriptionShortDetail.text = couponSelected?.descriptionShort
        tvCategoryDetail.text = couponSelected?.category
        tvDateDetail.text = couponSelected?.endDate
        tvDescriptionDetailData.text = couponSelected?.description
        tvOffertDetailData.text = couponSelected?.offer
        tvWebsiteDetailData.text = couponSelected?.website
        tvDateEndData.text = couponSelected?.endDate

        Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop().into(imgHeaderDetail)
        Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop().into(imgCouponDetail)

        btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(couponSelected?.url)
            startActivity(openURL)
        }
//VIEW- CONTROLLER
* */