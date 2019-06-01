package com.anncode.offersandcoupons.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter

class CouponViewModel: ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getCoupons() : MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>){
        recyclerCouponsAdapter?.setCounponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter?{
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCoupunAt(position: Int): Coupon?{
        var coupons: List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }

}