package com.mmb.coinmarket.currencyFragment.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmb.coinmarket.CoinMarketApplication
import com.mmb.coinmarket.R
import com.mmb.coinmarket.currencyFragment.contract.CurrencyContract
import com.mmb.coinmarket.currencyFragment.presenter.CurrencyPresenter
import com.mmb.coinmarket.domain.model.CurrencyInfo
import java.lang.ref.WeakReference
import javax.inject.Inject

class CurrencyFragment : Fragment(), CurrencyContract.View {
    @Inject lateinit var presenter: CurrencyContract.Presenter
    lateinit var adapter: CurrencyAdapter
    lateinit var recyclerView: RecyclerView
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onActivityCreated()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoinMarketApplication.component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context , DividerItemDecoration.HORIZONTAL))
        presenter.setPresenterView(this)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_list_view_layout , container , false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun showCurrency(items: List<CurrencyInfo>) {
        println(items)
        adapter = CurrencyAdapter(items)
        recyclerView.adapter = adapter
    }

    override fun showErrorToUser(msg: Int, title: Int) {
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ok)) { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            .create()
            .show()
    }
}