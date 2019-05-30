package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R

class MainActivity : AppCompatActivity(){


    private var rvCoupons: androidx.recyclerview.widget.RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons) //UI
        rvCoupons?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)


    }

}
