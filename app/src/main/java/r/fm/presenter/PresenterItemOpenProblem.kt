package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewOpenProblem
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemOpenProblem(
    private val viewDamper: HomeViewOpenProblem,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getAllOpenProblem() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllOpenProblem()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showOpenProblem(data.OpenProblem)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllOpenProblemOutIn() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllOpenProblemOutIn()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showOpenProblem(data.OpenProblemOutIn)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllOpenProblemWarning() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getAllOpenProblemWarning()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showOpenProblem(data.OpenProblemWarning)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

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
                viewDamper.showDateHour(data.DateHour)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}