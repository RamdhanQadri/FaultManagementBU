package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewMonitor
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemMonitor(
    private val view: HomeViewMonitor,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getProblemOutInSSI() {
        view.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemOutIn()).await(),
                        ItemRespon::class.java

                    )
                view.showProb(data.problemOutInSSI)
                view.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getProblemOutInKategoriSSI(kategori: String?) {

        view.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemOutInKategori(kategori)).await(),
                        ItemRespon::class.java

                    )
                view.showProb(data.problemOutInKategori)
                view.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getProblemNt24SSI() {
        view.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemNt24()).await(),
                        ItemRespon::class.java

                    )
                view.showProb(data.problemNt24SSI)
                view.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getProblemSlmSSI() {
        view.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemSlm()).await(),
                        ItemRespon::class.java

                    )
                view.showProb(data.slm)
                view.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getProblemSlmKategori(kategori: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemSlmKategori(kategori)).await(),
                        ItemRespon::class.java

                    )
                view.showProb(data.slmKategori)
                view.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}