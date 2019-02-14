package r.fm.interfac

import r.fm.model.ItemDateHour
import r.fm.model.ItemOpenProblem
import r.fm.model.ItemPortal

interface HomeViewOpenProblem {
    fun showLoading()
    fun hideLoading()
    fun showOpenProblem(data: List<ItemOpenProblem>)
    fun showDateHour(data: List<ItemDateHour>)
}