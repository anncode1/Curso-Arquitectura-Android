package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>)

    //Presentador
    fun getCoupons()
}