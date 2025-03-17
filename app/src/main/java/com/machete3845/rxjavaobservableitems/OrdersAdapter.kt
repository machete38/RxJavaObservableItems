package com.machete3845.rxjavaobservableitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.machete3845.rxjavaobservableitems.databinding.OrderLayoutBinding

class OrdersAdapter(val list: List<OrderModel>) : RecyclerView.Adapter<OrdersAdapter.OrdersAdapterViewHolder>() {

    inner class OrdersAdapterViewHolder(val binding: OrderLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(order: OrderModel)
        {
            binding.tvOrderName.text = order.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersAdapterViewHolder {
        val binding = OrderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OrdersAdapterViewHolder, position: Int) {
       holder.bind(list[position])
    }
}