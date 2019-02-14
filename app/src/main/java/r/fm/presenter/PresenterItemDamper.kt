package r.fm.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import r.fm.api.AfmApi
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.model.ItemRespon
import r.fm.utils.CoroutineContextProvider

class PresenterItemDamper(
    private val viewDamper: HomeViewDamper,
    private val api: Api,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getKelolaanSentra(namaSentra: String?) {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getKelolaanSentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showProb(data.kelolaanSentra)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSlmSentra(namaSentra: String?) {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getSlmSentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showProb(data.slmSentra)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getKelolaanSearch(tid: Int?) {

        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getKelolaanSearch(tid)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showProb(data.kelolaanSearches)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun getProblemOutInSentra(namaSentra: String?) {

        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemOutInSentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showProb(data.problemOutInSentra)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getProblemNT3Sentra(namaSentra: String?) {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getProblemNT3Sentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showProb(data.problemNt6Sentra)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCountProblemOutSentra(namaSentra: String?) {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getCountProblemOutSentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showCountOut(data.countProbOut)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCountProblemInSentra(namaSentra: String?) {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getCountProblemInSentra(namaSentra)).await(),
                        ItemRespon::class.java

                    )
                viewDamper.showCountIn(data.countProblemIn)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSelectAll() {
        viewDamper.showLoading()
        GlobalScope.launch(context.main) {
            try {
                val data =
                    gson.fromJson(
                        api
                            .doRequest(AfmApi.getSelectAll()).await(),
                        ItemRespon::class.java
                    )
                viewDamper.showProb(data.selectAll)
                viewDamper.hideLoading()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}