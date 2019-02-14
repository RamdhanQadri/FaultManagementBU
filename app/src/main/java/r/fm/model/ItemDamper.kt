package r.fm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemDamper(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("tidu")
    val tidu: Int? = null,

    @SerializedName("kanwilu")
    val kanwilu: String? = null,

    @SerializedName("lokasiu")
    val lokasiu: String? = null,

    @SerializedName("kcspvu")
    val kcspvu: String? = null,

    @SerializedName("kcspvkodeu")
    val kcspvkodeu: String? = null,

    @SerializedName("merkatmu")
    val merkatmu: String? = null,

    @SerializedName("pengelolau")
    val pengelolau: String? = null,

    @SerializedName("pengelolakodeu")
    val pengelolakodeu: String? = null,

    @SerializedName("pengelolavendoru")
    val pengelolavendoru: String? = null,

    @SerializedName("pengelolacpcu")
    val pengelolacpcu: String? = null,

    @SerializedName("pengelolajenisu")
    val pengelolajenisu: String? = null,

    @SerializedName("keteranganu")
    val keteranganu: String? = null,

    @SerializedName("downtimehariu")
    val downtimehariu: String? = null,

    @SerializedName("downtimejamu")
    val downtimejamu: String? = null,

    @SerializedName("lastsuksesu")
    val lastsuksesu: String? = null,

    @SerializedName("cashglu")
    val cashglu: String? = null,

    @SerializedName("problemu")
    val problemu: String? = null,

    @SerializedName("statusu")
    val statusu: String? = null,

    @SerializedName("waktuinsertu")
    val waktuinsertu: String? = null,

    @SerializedName("tglproblemu")
    val tglproblemu: String? = null,

    @SerializedName("lembaru")
    val lembaru: String? = null,

    @SerializedName("disp1u")
    val disp1u: String? = null,

    @SerializedName("disp2u")
    val disp2u: String? = null,

    @SerializedName("disp3u")
    val disp3u: String? = null,

    @SerializedName("disp4u")
    val disp4u: String? = null,

    @SerializedName("denomu")
    val denomu: String? = null,

    @SerializedName("lembar1u")
    val lembar1u: String? = null,

    @SerializedName("lembar2u")
    val lembar2u: String? = null,

    @SerializedName("lembar3u")
    val lembar3u: String? = null,

    @SerializedName("lembar4u")
    val lembar4u: String? = null,

    @SerializedName("rtlidticketu")
    val rtlidticketu: String? = null,

    @SerializedName("rtlproblemu")
    val rtlproblemu: String? = null,

    @SerializedName("rtlpartu")
    val rtlpartu: String? = null,

    @SerializedName("rtlslau")
    val rtlslau: String? = null,

    @SerializedName("rtlketeranganu")
    val rtlketeranganu: String? = null,

    @SerializedName("paguu")
    val paguu: String? = null,

    @SerializedName("sisasaldou")
    val sisasaldou: String? = null,

    @SerializedName("updatertlticketu")
    val updatertlticketu: String? = null,

    @SerializedName("pagudinamisu")
    val pagudinamisu: String? = null,

    @SerializedName("pagulembaru")
    val pagulembaru: String? = null,

    @SerializedName("pagudaysu")
    val pagudaysu: String? = null,

    @SerializedName("latitudeu")
    val latitudeu: String? = null,

    @SerializedName("longitudeu")
    val longitudeu: String? = null,

    @SerializedName("daydowntimetunaiu")
    val daydowntimetunaiu: String? = null,

    @SerializedName("haurdowntimetunaiu")
    val haurdowntimetunaiu: String? = null
) : Parcelable