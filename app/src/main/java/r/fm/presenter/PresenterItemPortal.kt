package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewPortal
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemPortal(
    private val viewDamper: HomeViewPortal,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getAllPortal() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllPortal()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showPortal(data.SelectAllPortal)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}