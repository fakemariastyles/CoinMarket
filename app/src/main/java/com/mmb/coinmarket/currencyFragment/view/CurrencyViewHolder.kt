package com.mmb.coinmarket.currencyFragment.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mmb.coinmarket.R
import com.mmb.coinmarket.domain.model.CurrencyInfo
import kotlinx.android.synthetic.main.item_currency_info_item.view.*

class CurrencyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val name = itemView.findViewById<TextView>(R.id.name)
    val price = itemView.findViewById<TextView>(R.id.price)
    val percentChange1hr = itemView.findViewById<TextView>(R.id.percentChange1hr)
    fun bind(currencyInfo: CurrencyInfo){
        name.text = currencyInfo.name
        price.text = currencyInfo.quote.uSD?.price.toString()
        percentChange1hr.text = currencyInfo.quote.uSD?.percentChange1h.toString()
    }
}