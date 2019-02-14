package r.fm.api

import android.net.Uri
import r.fm.BuildConfig

object AfmApi {
    fun getKelolaanSearch(tid: Int?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("KelolaanSearch.php")
            .appendQueryParameter("tid", tid.toString())
            .build()
            .toString()
    }

    fun getKelolaanSentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("KelolaanSentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    fun getSlmSentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SlmSentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    fun getProblemNT3Sentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SProblemNT3Sentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    fun getProblemOutInSentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SProblemOutInSentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    //Update versi 1.2
    fun getCountProblemInSentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountProblemInSentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    fun getCountProblemOutSentra(namaSentra: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountProblemOutSentra.php")
            .appendQueryParameter("pengelola_cpc", namaSentra)
            .build()
            .toString()
    }

    //Update Versi 1.3
    fun getCountAllKelolaan(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountAllKelolaan.php")
            .build()
            .toString()
    }

    fun getCountAllSlm(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountAllSlm.php")
            .build()
            .toString()
    }

    fun getCountAllOut(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountAllOut.php")
            .build()
            .toString()
    }

    fun getCountAllIn(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("CountAllIn.php")
            .build()
            .toString()
    }

    //Update Versi 1.4
    fun getProblemSlmKategori(ketegori: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SlmKategori.php")
            .appendQueryParameter("rtl_problem", ketegori)
            .build()
            .toString()
    }

    fun getProblemOutInKategori(ketegori: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SProblemOutInKategori.php")
            .appendQueryParameter("problem", ketegori)
            .build()
            .toString()
    }

    fun getProblemOutIn(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SProblemOutIn.php")
            .build()
            .toString()
    }

    fun getProblemNt24(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SProblemNt24.php")
            .build()
            .toString()
    }

    fun getProblemSlm(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("Slm.php")
            .build()
            .toString()
    }

    //Update Versi 1.5
    fun getSelectAll(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAll.php")
            .build()
            .toString()
    }

    //Update Versi 1.6
    fun getTidFromSaldo(tid: Int?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectTidFromSaldo.php")
            .appendQueryParameter("atmid", tid.toString())
            .build()
            .toString()
    }

    fun getAllFromSaldo(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllFromSaldo.php")
            .build()
            .toString()
    }

    fun getAllDateHour(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllDateHour.php")
            .build()
            .toString()
    }

    fun getAllPortal(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllPortal.php")
            .build()
            .toString()
    }

    fun getAllOpenProblem(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllOpenProblem.php")
            .build()
            .toString()
    }

    fun getAllOpenProblemOutIn(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllOpenProblemOutIn.php")
            .build()
            .toString()
    }

    fun getAllOpenProblemWarning(): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("Android")
            .appendPath("kotlin")
            .appendPath("SelectAllOpenProblemWarning.php")
            .build()
            .toString()
    }
}