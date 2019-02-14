package r.fm.interfac

import r.fm.model.ItemSaldo

interface HomeViewSaldo {
    fun showLoading()
    fun hideLoading()
    fun showSaldo(data: List<ItemSaldo>)
}