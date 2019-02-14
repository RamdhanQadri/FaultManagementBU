package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewDateHour
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemDateHour(
    private val viewDamper: HomeViewDateHour,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getAllDateHour() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllDateHour()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showDateHaur(data.DateHour)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}