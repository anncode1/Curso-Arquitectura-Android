package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {

    private var couponRepository: CouponRepository = CouponRepositoryImpl()
    //Repositorio
    fun callCoupons(){
        couponRepository.callCoupunsAPI()
    }

    //ViewModel
    fun getCoupons() : MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupuns()
    }
}