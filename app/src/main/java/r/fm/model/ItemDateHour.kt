package r.fm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemDateHour (
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("tgl")
    val tgl: String? = null
) : Parcelable