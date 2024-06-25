package com.example.basciecommerceapp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val cartItems: List<CartItems>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCartItemTitle: TextView = view.findViewById(R.id.txtCartItemTitle)
        val imgCartItem: ImageView = view.findViewById(R.id.imgCartItem)
        val txtCartItemPrice: TextView = view.findViewById(R.id.txtCartItemPrice)
        val txtCartItemDescription: TextView = view.findViewById(R.id.txtCartItemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cartItemView = layoutInflater.inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(cartItemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.txtCartItemTitle.text = cartItem.product.title
        holder.imgCartItem.setImageResource(R.drawable.laptop)
        holder.txtCartItemPrice.text = cartItem.product.price.toString()
        holder.txtCartItemDescription.text = cartItem.product.description
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}
