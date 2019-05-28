package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Interactor
    fun getCoupons()
}