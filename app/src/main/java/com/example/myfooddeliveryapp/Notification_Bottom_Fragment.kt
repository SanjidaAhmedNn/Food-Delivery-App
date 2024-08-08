package com.example.myfooddeliveryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfooddeliveryapp.Adapter.NotificationAdapter
import com.example.myfooddeliveryapp.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater, container, false)
        val notifications = listOf("Your order has been canceled successfully",
                                    "Order has been taken by the driver",
                                    "Congrats your order has been placed")
        val notificationImages = listOf(R.drawable.sademoji, R.drawable.iconcar, R.drawable.icontick)
        val adapter = NotificationAdapter(ArrayList(notifications), ArrayList(notificationImages))

        binding.recyclerVwNotification.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerVwNotification.adapter = adapter

        return binding.root
    }

    companion object {

    }
}