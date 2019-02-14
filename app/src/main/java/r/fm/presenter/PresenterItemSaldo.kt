package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewSaldo
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemSaldo(
    private val viewDamper: HomeViewSaldo,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getTidFromSaldo(tid: Int?) {

        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getTidFromSaldo(tid)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showSaldo(data.SelectTidFromSaldo)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllFromSaldo() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllFromSaldo()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showSaldo(data.SelectAllFromSaldo)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}