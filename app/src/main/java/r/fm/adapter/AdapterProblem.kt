package r.fm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import r.fm.layoutUi.LayoutProblem
import r.fm.model.ItemDamper

class AdapterProblem(
    private val items: List<ItemDamper>,
    private val listener: (ItemDamper) -> Unit
) : RecyclerView.Adapter<ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutProblem().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.count()
}

class ItemsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemTid: TextView = view.find(LayoutProblem.tvTid)
    private val itemLokasi: TextView = view.find(LayoutProblem.tvLokasi)
    private val itemProblem: TextView = view.find(LayoutProblem.tvProblem)
    private val itemStatus: TextView = view.find(LayoutProblem.tvUpdate_rtl_ticket)
    private val itemLastTrx: TextView = view.find(LayoutProblem.tvLastTransaksi)
    private val itemDowntime: TextView = view.find(LayoutProblem.tvDowntime)
    private val itemDownhari: TextView = view.find(LayoutProblem.tvDownhari)
    private val itemCpc: TextView = view.find(LayoutProblem.tvPengelola_cpc)

    fun bindItem(items: ItemDamper, listener: (ItemDamper) -> Unit) {
        itemTid.text = items.tidu.toString()
        itemLokasi.text = items.lokasiu
        itemProblem.text = items.problemu
        itemStatus.text = items.updatertlticketu
        itemLastTrx.text = " " + items.lastsuksesu
        itemDowntime.text = " " + items.downtimehariu + " "
        itemDownhari.text = " " + items.downtimejamu
        itemCpc.text = items.pengelolacpcu

        itemView.setOnClickListener {
            listener(items)
        }
    }
}