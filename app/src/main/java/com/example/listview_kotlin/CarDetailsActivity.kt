package com.example.listview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_car_details.*

class CarDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        val bun: Bundle? = intent.extras
        val name = bun!!.getString("name")
        val des = bun!!.getString("desc")

        car_type_tv.text = name
        car_details_tv.text = des
    }
}
