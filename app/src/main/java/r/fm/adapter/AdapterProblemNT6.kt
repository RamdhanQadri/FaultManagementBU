package r.fm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import r.fm.layoutUi.LayoutProblemNT6
import r.fm.model.ItemDamper

class AdapterProblemNT6(
    private val items: List<ItemDamper>,
    private val listener: (ItemDamper) -> Unit
) : RecyclerView.Adapter<ItemsNt6ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsNt6ViewHolder {
        return ItemsNt6ViewHolder(
            LayoutProblemNT6().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsNt6ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.count()
}

class ItemsNt6ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemTid: TextView = view.find(LayoutProblemNT6.tvTid)
    private val itemLokasi: TextView = view.find(LayoutProblemNT6.tvLokasi)
    private val itemLastTrx: TextView = view.find(LayoutProblemNT6.tvLastTransaksi)
    private val itemCpc: TextView = view.find(LayoutProblemNT6.tvPengelola_cpc)

    fun bindItem(items: ItemDamper, listener: (ItemDamper) -> Unit) {
        itemTid.text = items.tidu.toString()
        itemLokasi.text = items.lokasiu
        itemCpc.text = items.pengelolacpcu
        itemLastTrx.text = " " + items.lastsuksesu

        itemView.setOnClickListener {
            listener(items)
        }
    }
}