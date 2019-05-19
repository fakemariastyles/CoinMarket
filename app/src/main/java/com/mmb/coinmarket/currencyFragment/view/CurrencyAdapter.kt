package com.mmb.coinmarket.currencyFragment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmb.coinmarket.R
import com.mmb.coinmarket.domain.model.CurrencyInfo

class CurrencyAdapter(private val items: List<CurrencyInfo>) : RecyclerView.Adapter<CurrencyViewHolder>() {
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency_info_item, parent, false)
        return CurrencyViewHolder(view)
    }

}