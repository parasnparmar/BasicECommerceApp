package com.example.basciecommerceapp1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basciecommerceapp1.databinding.CartViewActivityBinding

class AddToCartActivity : AppCompatActivity() {
    private lateinit var binding: CartViewActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CartViewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cartItems = CartManager.getCartItems()
        val totalPrice = CartManager.getCartTotal()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CartAdapter(cartItems)
        binding.recyclerView.adapter = adapter

        binding.txtProductPrice.text = "Total: $totalPrice"
    }
}
