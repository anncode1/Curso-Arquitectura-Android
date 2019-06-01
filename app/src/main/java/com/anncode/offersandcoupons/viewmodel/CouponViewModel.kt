package com.anncode.offersandcoupons.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel: ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null
    var selected:MutableLiveData<Coupon> = MutableLiveData<Coupon>()

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

    fun getCouponSelected(): MutableLiveData<Coupon> {
        return selected
    }
    fun onItemClick(index: Int){
        val coupon = getCoupunAt(index)
        selected.value = coupon
    }

}


@BindingAdapter("imageUrl")
fun getImageCouponAt(imgCouponDetail: CircleImageView, imageUrl: String ){
    Picasso.get().load(imageUrl).resize(520, 520).centerCrop().into(imgCouponDetail )

}