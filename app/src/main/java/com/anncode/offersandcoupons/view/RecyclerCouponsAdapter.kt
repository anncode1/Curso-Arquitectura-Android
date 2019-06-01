package com.anncode.offersandcoupons.view

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter( var couponViewModel: CouponViewModel ,var resource: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    var coupons: List<Coupon>? = null

    fun setCounponsList(coupons: List<Coupon>?){
        this.coupons= coupons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding:  ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponViewModel, p1)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            binding?.setVariable(BR.model, couponViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }


    }

}
