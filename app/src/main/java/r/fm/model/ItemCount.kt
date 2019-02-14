package r.fm.model

import com.google.gson.annotations.SerializedName

data class ItemCountIn(
    @SerializedName("jumlah_in")
    val jumlah_in: String? = null
)

data class ItemCountOut(
    @SerializedName("jumlah_out")
    val jumlah_out: String? = null
)

data class ItemCountAllKelolaan(
    @SerializedName("jumlah_all_kelolaan")
    val jumlah_all_kelolaan: String? = null
)

data class ItemCountAllSlm(
    @SerializedName("jumlah_all_slm")
    val jumlah_all_slm: String? = null
)

data class ItemCountAllOut(
    @SerializedName("jumlah_all_out")
    val jumlah_all_out: String? = null
)

data class ItemCountAllIn(
    @SerializedName("jumlah_all_in")
    val jumlah_all_in: String? = null
)