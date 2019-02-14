package r.fm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemSaldo (
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("atmid")
    val atmid: String? = null,

    @SerializedName("location")
    val location: String? = null,

    @SerializedName("outos")
    val outos: String? = null,

    @SerializedName("comm")
    val comm: String? = null,

    @SerializedName("journal")
    val journal: String? = null,

    @SerializedName("ccr")
    val ccr: String? = null,

    @SerializedName("receipt")
    val receipt: String? = null,

    @SerializedName("cashout")
    val cashout: String? = null,

    @SerializedName("cashlow")
    val cashlow: String? = null,

    @SerializedName("cassette1")
    val cassette1: String? = null,

    @SerializedName("cassette2")
    val cassette2: String? = null,

    @SerializedName("cassette3")
    val cassette3: String? = null,

    @SerializedName("cassette4")
    val cassette4: String? = null,

    @SerializedName("df")
    val df: String? = null,

    @SerializedName("db")
    val db: String? = null,

    @SerializedName("moneyleft")
    val moneyleft: String? = null,

    @SerializedName("rejectbin")
    val rejectbin: String? = null,

    @SerializedName("presenter")
    val presenter: String? = null,

    @SerializedName("spvmode")
    val spvmode: String? = null,

    @SerializedName("cast_atm")
    val cast_atm: String? = null,

    @SerializedName("lembar")
    val lembar: String? = null,

    @SerializedName("hoper1")
    val hoper1: String? = null,

    @SerializedName("hoper2")
    val hoper2: String? = null,

    @SerializedName("hoper3")
    val hoper3: String? = null,

    @SerializedName("hoper4")
    val hoper4: String? = null,

    @SerializedName("max_lbr")
    val max_lbr: String? = null,

    @SerializedName("real_lbr")
    val real_lbr: String? = null,

    @SerializedName("denom")
    val denom: String? = null,

    @SerializedName("pengelola")
    val pengelola: String? = null,

    @SerializedName("wilayah")
    val wilayah: String? = null
) : Parcelable