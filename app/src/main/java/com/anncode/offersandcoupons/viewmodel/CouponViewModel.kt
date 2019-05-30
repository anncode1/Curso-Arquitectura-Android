package com.anncode.offersandcoupons.viewmodel

import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.model.CouponObservable

class CouponViewModel: ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()

    fun callCoupons(){
        couponObservable.callCoupons()
    }
}