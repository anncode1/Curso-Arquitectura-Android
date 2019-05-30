package com.anncode.offersandcoupons.model

import androidx.lifecycle.MutableLiveData

interface CouponRepository {
    fun getCoupuns(): MutableLiveData<List<Coupon>>
    fun callCoupunsAPI()

}