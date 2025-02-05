package com.example.myfooddeliveryapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfooddeliveryapp.databinding.CartItemBinding

class CartAdapter (
    private val cartItems: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private var cartImage: MutableList<Int>
): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                txtVwCartItemName.text = cartItems[position]
                txtVwCartItemPrice.text = cartItemPrice[position]
                imgVwCartItem.setImageResource(cartImage[position])
                txtVwCartItemQuantity.text = quantity.toString()

                imgBtnMinus.setOnClickListener {
                    decreaseQuantity(position)

                }

                imgBtnPlus.setOnClickListener {
                    increaseQuantity(position)

                }

                imgBtnTrash.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION)
                        deleteItem(itemPosition)
                }

            }

        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.txtVwCartItemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.txtVwCartItemQuantity.text = itemQuantities[position].toString()

            }
        }

        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            cartImage.removeAt(position)
            cartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }
    }
}
