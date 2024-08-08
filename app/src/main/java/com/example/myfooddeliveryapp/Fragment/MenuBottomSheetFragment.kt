package com.example.myfooddeliveryapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfooddeliveryapp.Adapter.CartAdapter
import com.example.myfooddeliveryapp.R
import com.example.myfooddeliveryapp.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Burger", "Fried Chicken", "French Fries", "Chips", "Fish tots")
        val menuItemPrice = listOf("$5", "$6", "$7","$8", "$40")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu4,
            R.drawable.menu6,
            R.drawable.menu8,
            R.drawable.menu7
        )

        val adapter = CartAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}