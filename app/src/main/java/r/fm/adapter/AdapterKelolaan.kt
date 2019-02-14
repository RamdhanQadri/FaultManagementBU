package r.fm.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import r.fm.layoutUi.LayoutKelolaan
import r.fm.model.ItemDamper

class AdapterKelolaan(
    private val items: List<ItemDamper>,
    private val listener: (ItemDamper) -> Unit
) : RecyclerView.Adapter<ItemsKelolaanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsKelolaanViewHolder {
        return ItemsKelolaanViewHolder(
            LayoutKelolaan().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsKelolaanViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.count()
}

class ItemsKelolaanViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val itemTid: TextView = view.find(LayoutKelolaan.tvTid)
    private val itemCpc: TextView = view.find(LayoutKelolaan.tvPengelola_cpc)
    private val itemProblem: TextView = view.find(LayoutKelolaan.tvProblem)

    fun bindItem(items: ItemDamper, listener: (ItemDamper) -> Unit) {
        itemTid.text = items.tidu.toString()
        itemCpc.text = items.pengelolacpcu
        itemProblem.text = items.problemu

        itemView.setOnClickListener {
            listener(items)
        }
    }
}