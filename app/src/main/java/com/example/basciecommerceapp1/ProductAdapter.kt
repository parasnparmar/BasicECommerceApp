package com.example.basciecommerceapp1

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var txtProductTitle: TextView = view.findViewById(R.id.txtProductTitle)
        var imgProdcut: ImageView = view.findViewById(R.id.imgProduct)
        var txtProductPrice: TextView = view.findViewById(R.id.txtProductPrice)
        var txtProductDescription: TextView = view.findViewById(R.id.txtProductDiscription)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val product = products[position]
                    val intent = Intent(view.context, ProductDetailActivity::class.java)
                    intent.putExtra("product", product)
                    Log.d("ProductAdapter", "$product")
                    view.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val productView = layoutInflater.inflate(R.layout.product_view, parent, false)
        return ProductViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.txtProductTitle.text = product.title
        holder.imgProdcut.setImageResource(product.image)
        holder.txtProductPrice.text = product.price.toString()
        holder.txtProductDescription.text = product.description
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
