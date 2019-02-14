package r.fm.interfac

import r.fm.model.ItemPortal

interface HomeViewPortal {
    fun showLoading()
    fun hideLoading()
    fun showPortal(data: List<ItemPortal>)
}