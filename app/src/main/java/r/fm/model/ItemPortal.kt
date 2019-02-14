package r.fm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemPortal(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("sentra")
    val sentra: String? = null,

    @SerializedName("kelolaan")
    val kelolaan: String? = null,

    @SerializedName("atmup")
    val atmup: String? = null,

    @SerializedName("uptunai")
    val uptunai: String? = null,

    @SerializedName("co")
    val inFlm: String? = null,

    @SerializedName("df")
    val outFlm: String? = null,

    @SerializedName("slm")
    val slm: String? = null,

    @SerializedName("up")
    val availability: String? = null,

    @SerializedName("perform")
    val reliability: String? = null,

    @SerializedName("wilayah")
    val wilayah: String? = null
) : Parcelable