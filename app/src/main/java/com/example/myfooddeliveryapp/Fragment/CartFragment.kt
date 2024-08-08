package com.example.myfooddeliveryapp.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfooddeliveryapp.Adapter.CartAdapter
import com.example.myfooddeliveryapp.CongratsBottomSheet
import com.example.myfooddeliveryapp.PayOutActivity
import com.example.myfooddeliveryapp.R
import com.example.myfooddeliveryapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Burger", "Fried Chicken", "French Fries", "Chips")
        val cartItemPrice = listOf("$5", "$6", "$7","$8")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu4,
            R.drawable.menu6,
            R.drawable.menu8,
        )

        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.RecyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.RecyclerViewCart.adapter = adapter

        binding.btnProceed.setOnClickListener {
            val intent = Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}