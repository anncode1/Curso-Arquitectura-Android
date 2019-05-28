package com.anncode.offersandcoupons.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.ApiAdapter
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {
    override fun showCoupons(coupons: ArrayList<Coupon>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCoupons() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var couponPresenter: CouponPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //couponPresenter = CouponPresenterImpl()

        //VIEW
        val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons) //UI
        rvCoupons.layoutManager = LinearLayoutManager(this)
        val coupons = ArrayList<Coupon>()
        //VIEW


        //CONTROLLER
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
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
                //VIEW
                rvCoupons.adapter = RecyclerCouponsAdapter(
                    coupons,
                    R.layout.card_coupon
                )
                //VIEW
            }


        })
        //CONTROLLER


    }
}
