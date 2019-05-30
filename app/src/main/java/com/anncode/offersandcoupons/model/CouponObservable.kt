package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable

class CouponObservable: BaseObservable() {

    private var couponRepository: CouponRepository = CouponRepositoryImpl()
    //Repositorio
    fun callCoupons(){
        couponRepository.callCoupunsAPI()
    }

    //ViewModel
}