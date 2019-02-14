package r.fm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOpenProblem(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("tid")
    val tid: String? = null,

    @SerializedName("lokasi")
    val lokasi: String? = null,

    @SerializedName("pengelola")
    val pengelola: String? = null,

    @SerializedName("problem")
    val problem: String? = null,

    @SerializedName("detailproblem")
    val detailproblem: String? = null,

    @SerializedName("subdetailproblem")
    val subdetailproblem: String? = null,

    @SerializedName("openproblem")
    val openproblem: String? = null,

    @SerializedName("duration")
    val duration: String? = null,

    @SerializedName("comm")
    val comm: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("slm")
    val slm: String? = null,

    @SerializedName("codeslm")
    val codeslm: String? = null,

    @SerializedName("is_req")
    val is_req: String? = null,

    @SerializedName("is_process")
    val is_process: String? = null,

    @SerializedName("acttext")
    val acttext: String? = null,

    @SerializedName("atmmp")
    val atmmp: String? = null,

    @SerializedName("wilayah")
    val wilayah: String? = null,

    @SerializedName("rtlticket")
    val rtlticket: String? = null
) : Parcelable