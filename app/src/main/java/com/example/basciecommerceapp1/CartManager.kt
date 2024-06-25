package com.example.basciecommerceapp1

object CartManager {
    private val cartItems = mutableListOf<CartItems>()

    fun addToCart(product: Product) {
        val existingItem = cartItems.find { it.product.title == product.title }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            cartItems.add(CartItems(product, 1))
        }
    }

    fun getCartItems(): List<CartItems> {
        return cartItems
    }

    fun getCartTotal(): Double {
        return cartItems.sumByDouble { it.product.price * it.quantity }
    }
}
