package r.fm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import r.fm.layoutUi.LayoutOpenProblem
import r.fm.model.ItemOpenProblem

class AdapterOpenProblem(
    private val items: List<ItemOpenProblem>,
    private val listener: (ItemOpenProblem) -> Unit
) : RecyclerView.Adapter<ItemsViewHolderOpenProblem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolderOpenProblem {
        return ItemsViewHolderOpenProblem(
            LayoutOpenProblem().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolderOpenProblem, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.count()
}

class ItemsViewHolderOpenProblem(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemTid: TextView = view.find(LayoutOpenProblem.tvTid)
    private val itemLokasi: TextView = view.find(LayoutOpenProblem.tvLokasi)
    private val itemProblem: TextView = view.find(LayoutOpenProblem.tvProblem)
    private val itemStatus: TextView = view.find(LayoutOpenProblem.tvUpdate_rtl_ticket)
    private val itemOpenProblem: TextView = view.find(LayoutOpenProblem.tvOpenProblem)
    private val itemDowntime: TextView = view.find(LayoutOpenProblem.tvDowntime)
    private val itemCpc: TextView = view.find(LayoutOpenProblem.tvPengelola_cpc)

    fun bindItem(items: ItemOpenProblem, listener: (ItemOpenProblem) -> Unit) {
        itemTid.text = items.tid.toString()
        itemLokasi.text = items.lokasi
        itemStatus.text = items.description
        itemOpenProblem.text = " " + items.openproblem
        itemDowntime.text = " " + items.duration

        itemView.setOnClickListener {
            listener(items)
        }

        val problem = items.problem?.toInt()
        val detailproblem = items.detailproblem?.toInt()
        val subdetailproblem = items.subdetailproblem?.toInt()
        val pengelola = items.pengelola

        if (problem == 1) {
            itemProblem.text = "Restocking"
        } else if (problem == 2) {
            itemProblem.text = "Maintenance"
        } else if (problem == 3) {
            itemProblem.text = "Cash Out"
        } else if (problem == 4) {
            itemProblem.text = ""
            if (detailproblem == 1) {
                itemProblem.text = "Journal"
            } else if (detailproblem == 2) {
                itemProblem.text = "Card Reader"
            } else if (detailproblem == 3) {
                itemProblem.text = "Receipt"
            } else if (detailproblem == 4) {
                itemProblem.text = "DF"
                if (subdetailproblem == 1) {
                    itemProblem.text = " CO"
                } else if (subdetailproblem == 1) {
                    itemProblem.text = " Cassete"
                } else if (subdetailproblem == 2) {
                    itemProblem.text = ""
                }
            } else if (detailproblem == 5) {
                itemProblem.text = "EPP"
            } else if (detailproblem == 6) {
                itemProblem.text = "Presenter Error"
            }
        } else if (problem == 5) {
            itemProblem.text = "Down"
        } else if (problem == 6) {
            itemProblem.text = "Warning "
            if (detailproblem == 1) {
                itemProblem.text = "3 Cassette Failed"
            } else if (detailproblem == 2) {
                itemProblem.text = "Cash Low"
            }
        }

        if (pengelola.equals("AMB")) {
            itemCpc.text = "SSI AMBON"
        } else if (pengelola.equals("BPP")) {
            itemCpc.text = "SSI BALIKPAPAN"
        } else if (pengelola.equals("BNA")) {
            itemCpc.text = "SSI BANDA ACEH"
        } else if (pengelola.equals("BJB")) {
            itemCpc.text = "SSI BANJARBARU"
        } else if (pengelola.equals("BJM")) {
            itemCpc.text = "SSI BANJARMASIN"
        } else if (pengelola.equals("BWI")) {
            itemCpc.text = "SSI BANYUWANGI"
        } else if (pengelola.equals("BTM")) {
            itemCpc.text = "SSI BATAM"
        } else if (pengelola.equals("BKS")) {
            itemCpc.text = "SSI BEKASI"
        } else if (pengelola.equals("BKL")) {
            itemCpc.text = "SSI BENGKULU"
        } else if (pengelola.equals("BMA")) {
            itemCpc.text = "SSI BIMA"
        } else if (pengelola.equals("BGR")) {
            itemCpc.text = "SSI BOGOR"
        } else if (pengelola.equals("BRO")) {
            itemCpc.text = "SSI BOJONEGORO"
        } else if (pengelola.equals("BSD")) {
            itemCpc.text = "SSI BSD"
        } else if (pengelola.equals("CBI")) {
            itemCpc.text = "SSI CIBINONG"
        } else if (pengelola.equals("CKR")) {
            itemCpc.text = "SSI CIKARANG"
        } else if (pengelola.equals("DPS")) {
            itemCpc.text = "SSI DENPASAR"
        } else if (pengelola.equals("DPK")) {
            itemCpc.text = "SSI DEPOK"
        } else if (pengelola.equals("DKB")) {
            itemCpc.text = "SSI DUKUH BAWAH"
        } else if (pengelola.equals("DMI")) {
            itemCpc.text = "SSI DUMAI"
        } else if (pengelola.equals("DRI")) {
            itemCpc.text = "SSI DURI"
        } else if (pengelola.equals("END")) {
            itemCpc.text = "SSI ENDE"
        } else if (pengelola.equals("FMI")) {
            itemCpc.text = "SSI FATMAWATI"
        } else if (pengelola.equals("GTO")) {
            itemCpc.text = "SSI GORONTALO"
        } else if (pengelola.equals("HMN")) {
            itemCpc.text = "SSI HARMONI 1"
        } else if (pengelola.equals("HMN2")) {
            itemCpc.text = "SSI HARMONI 2"
        } else if (pengelola.equals("JBI")) {
            itemCpc.text = "SSI JAMBI"
        } else if (pengelola.equals("JTW")) {
            itemCpc.text = "SSI JATIWARNA"
        } else if (pengelola.equals("JAP")) {
            itemCpc.text = "SSI JAYAPURA"
        } else if (pengelola.equals("KWG")) {
            itemCpc.text = "SSI KARAWANG"
        } else if (pengelola.equals("KDR")) {
            itemCpc.text = "SSI KENDARI"
        } else if (pengelola.equals("KPA")) {
            itemCpc.text = "SSI KUPANG"
        } else if (pengelola.equals("LGS")) {
            itemCpc.text = "SSI LANGSA"
        } else if (pengelola.equals("LSW")) {
            itemCpc.text = "SSI LHOKSEUMAWE"
        } else if (pengelola.equals("LWK")) {
            itemCpc.text = "SSI LUWUK"
        } else if (pengelola.equals("MDO")) {
            itemCpc.text = "SSI MANADO"
        } else if (pengelola.equals("MTR")) {
            itemCpc.text = "SSI MATARAM"
        } else if (pengelola.equals("MRE")) {
            itemCpc.text = "SSI MAUMERE"
        } else if (pengelola.equals("MDN")) {
            itemCpc.text = "SSI MEDAN"
        } else if (pengelola.equals("MBO")) {
            itemCpc.text = "SSI MEULABOH"
        } else if (pengelola.equals("MRB")) {
            itemCpc.text = "SSI MUARA BUNGO"
        } else if (pengelola.equals("PDG")) {
            itemCpc.text = "SSI PADANG"
        } else if (pengelola.equals("PSP")) {
            itemCpc.text = "SSI PADANG SIDEMPUAN"
        } else if (pengelola.equals("PLK")) {
            itemCpc.text = "SSI PALANGKARAYA"
        } else if (pengelola.equals("PLP")) {
            itemCpc.text = "SSI PALOPO"
        } else if (pengelola.equals("PLU")) {
            itemCpc.text = "SSI PALU"
        } else if (pengelola.equals("PKR")) {
            itemCpc.text = "SSI PANGKALAN KERINCI"
        } else if (pengelola.equals("PSN")) {
            itemCpc.text = "SSI PASURUAN"
        } else if (pengelola.equals("PKU")) {
            itemCpc.text = "SSI PEKANBARU"
        } else if (pengelola.equals("PMS")) {
            itemCpc.text = "SSI PEMATANG SIANTAR"
        } else if (pengelola.equals("PDB")) {
            itemCpc.text = "SSI PONDOK BAMBU"
        } else if (pengelola.equals("RTP")) {
            itemCpc.text = "SSI RANTAU PRAPAT"
        } else if (pengelola.equals("RGT")) {
            itemCpc.text = "SSI RENGAT"
        } else if (pengelola.equals("SMD")) {
            itemCpc.text = "SSI SAMARINDA"
        } else if (pengelola.equals("SPT")) {
            itemCpc.text = "SSI SAMPIT"
        } else if (pengelola.equals("SLG")) {
            itemCpc.text = "SSI SELONG"
        } else if (pengelola.equals("SMG")) {
            itemCpc.text = "SSI SEMARANG"
        } else if (pengelola.equals("SRG")) {
            itemCpc.text = "SSI SERANG"
        } else if (pengelola.equals("SGR")) {
            itemCpc.text = "SSI SINGARAJA"
        } else if (pengelola.equals("SON")) {
            itemCpc.text = "SSI SORONG"
        } else if (pengelola.equals("SBW")) {
            itemCpc.text = "SSI SUMBAWA"
        } else if (pengelola.equals("TRG")) {
            itemCpc.text = "SSI TANGERANG 1"
        } else if (pengelola.equals("TRG2")) {
            itemCpc.text = "SSI TANGERANG 2"
        } else if (pengelola.equals("TNT")) {
            itemCpc.text = "SSI TERNATE"
        } else if (pengelola.equals("TBK")) {
            itemCpc.text = "SSI TJ. BALAI KARIMUN"
        } else if (pengelola.equals("TJP")) {
            itemCpc.text = "SSI TJ. PINANG"
        } else if (pengelola.equals("UBT")) {
            itemCpc.text = "SSI UJUNG BATU"
        } else {
            itemCpc.text = ""
        }
    }
}