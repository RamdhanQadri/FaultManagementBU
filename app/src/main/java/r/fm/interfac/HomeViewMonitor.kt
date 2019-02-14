package r.fm.interfac

import r.fm.model.ItemDamper

interface HomeViewMonitor {
    fun showLoading()
    fun hideLoading()
    fun showProb(data: List<ItemDamper>)
}