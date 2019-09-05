package com.example.listview_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listview_item.view.*

class MainActivity : AppCompatActivity() {

    var listOfCars = ArrayList<Cars>()
    var adapter:CarsAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfCars.add(Cars("Sedan", "Can fit maximum of 4 people",false))
        listOfCars.add(Cars("SUV", "Can fit maximum of 6 people",true))
        listOfCars.add(Cars("2-door", "Can fit maximum of 2 people",false))
        listOfCars.add(Cars("Van", "Can fit maximum of 8 people",true))

        adapter = CarsAdapter(this, listOfCars)
        listview_lv.adapter = adapter
    }


    class CarsAdapter : BaseAdapter {

        var listOfCars = ArrayList<Cars>( )
        var context:Context?=null


        constructor(context: Context, listOfCars: ArrayList<Cars>):super (){
            this.listOfCars = listOfCars
            this.context=context
        }
        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            val car = listOfCars[position]

            if(car.isBig == true){
                val inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myview = inflater.inflate(R.layout.car_big_layout, null)
                myview.tvName.text = car.name
                myview.tvDes.text = car.description
                return myview
            }
            else {
                val inflater =
                    context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myview = inflater.inflate(R.layout.listview_item, null)
                myview.tvName.text = car.name
                myview.tvDes.text = car.description
                return myview
            }

        }

        override fun getItem(p0: Int): Any {
            return listOfCars[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfCars.size
        }
    }
}
