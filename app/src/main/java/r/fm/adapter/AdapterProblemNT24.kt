package r.fm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import r.fm.layoutUi.LayoutProblemNT24
import r.fm.model.ItemDamper

class AdapterProblemNT24(
    private val items: List<ItemDamper>,
    private val listener: (ItemDamper) -> Unit
) : RecyclerView.Adapter<ItemsNt24ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsNt24ViewHolder {
        return ItemsNt24ViewHolder(
            LayoutProblemNT24().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsNt24ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.count()
}

class ItemsNt24ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemTid: TextView = view.find(LayoutProblemNT24.tvTid)
    private val itemLokasi: TextView = view.find(LayoutProblemNT24.tvLokasi)
    private val itemLastTrx: TextView = view.find(LayoutProblemNT24.tvLastTransaksi)
    private val itemDownTimeTunaiDay: TextView = view.find(LayoutProblemNT24.tvDonwTimeTunaiDay)
    private val itemCpc: TextView = view.find(LayoutProblemNT24.tvPengelola_cpc)

    fun bindItem(items: ItemDamper, listener: (ItemDamper) -> Unit) {
        itemTid.text = items.tidu.toString()
        itemLokasi.text = items.lokasiu
        itemDownTimeTunaiDay.text = " " + items.daydowntimetunaiu + " Hari"
        itemCpc.text = items.pengelolacpcu
        itemLastTrx.text = " " + items.lastsuksesu

        itemView.setOnClickListener {
            listener(items)
        }
    }
}