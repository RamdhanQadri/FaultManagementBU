package r.fm.interfac

import r.fm.model.*

interface HomeViewDamper {
    fun showLoading()
    fun hideLoading()
    fun showProb(data: List<ItemDamper>)
    fun showCountIn(data: List<ItemCountIn>)
    fun showCountOut(data: List<ItemCountOut>)
    fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>)
    fun showCountAllSlm(data: List<ItemCountAllSlm>)
    fun showCountAllOut(data: List<ItemCountAllOut>)
    fun showCountAllIn(data: List<ItemCountAllIn>)
}