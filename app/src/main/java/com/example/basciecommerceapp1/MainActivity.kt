package com.example.basciecommerceapp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basciecommerceapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val products = ArrayList<Product>()
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(activityMainBinding.root)
        initData()
        initViews()
        initAdapter()

    }

    private fun initAdapter(){
        activityMainBinding.recyclerViewProduct.adapter = ProductAdapter(products)
    }
    private fun initViews(){
        activityMainBinding.recyclerViewProduct.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)

    }
    private fun initData(){
        for(i in 1..10){
            products.add(Product("HP Laptop $i",10000.0,"i5-12gen-2023-16gb-1tb",R.drawable.laptop))
        }
    }
}