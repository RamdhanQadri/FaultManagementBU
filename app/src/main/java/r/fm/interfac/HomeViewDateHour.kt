package r.fm.interfac

import r.fm.model.ItemDateHour

interface HomeViewDateHour {
    fun showLoading()
    fun hideLoading()
    fun showDateHaur(data: List<ItemDateHour>)
}