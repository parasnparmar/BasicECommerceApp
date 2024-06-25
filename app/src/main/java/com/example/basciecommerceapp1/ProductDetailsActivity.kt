package com.example.basciecommerceapp1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.basciecommerceapp1.databinding.ActivityProductDetailsBinding

class ProductDetailActivity : AppCompatActivity() {
    lateinit var productDetailsBinding: ActivityProductDetailsBinding
    var ADD_TO_CART = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productDetailsBinding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(productDetailsBinding.root)

        val bundle = intent.extras
        val product = bundle?.get("product") as Product

        val title = product.title
        val price = product.price
        val description = product.description
        val image = product.image

        productDetailsBinding.txtProductTitle.text = title
        productDetailsBinding.txtProductPrice.text = price.toString()
        productDetailsBinding.imgProduct.setImageResource(image)
        productDetailsBinding.txtProductDescription.text = description

        productDetailsBinding.btnAddToCart.setOnClickListener {
            CartManager.addToCart(product)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("Tag", "onCreateOptionsMenu called")
        menuInflater.inflate(R.menu.addtocart_menu, menu)
        menu!!.addSubMenu(1, 1, 1, "View Cart")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("Tag", "onOpstionsItemSelectedCalled")
        when (item.itemId) {
            1 -> {
                val intent = Intent(this,AddToCartActivity::class.java)
                startActivity(intent)
                return true
            }else ->{
            return false
        }
        }
    }
}

