package r.fm

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.kotlinB.model.*
import r.fm.model.*
import r.fm.presenter.PresenterItemDamper
import r.fm.view.MainActivity

class UtamaActivity : AppCompatActivity(), HomeViewDamper {

    private var item: MutableList<ItemDamper> = mutableListOf()
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var waktuInsert: TextView
    private lateinit var jumlahKelolaan: TextView
    private lateinit var jumlahSlm: TextView
    private lateinit var jumlahOut: TextView
    private lateinit var jumlahtIn: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        val request = Api()
        val gson = Gson()
        presenterDamper = PresenterItemDamper(this, request, gson)

        linearLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL
            padding = Gravity.CENTER
            backgroundResource = R.mipmap.ic_s_round

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(
                    R.color.colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
                )

                linearLayout {
                    lparams(matchParent, matchParent)
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER

                    cardView {
                        waktuInsert = textView {
                            textSize = 16f
                            gravity = Gravity.CENTER_HORIZONTAL
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(matchParent, wrapContent)
                    }

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            gravity = Gravity.CENTER_HORIZONTAL

                            jumlahKelolaan = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(matchParent, wrapContent)

                            jumlahSlm = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(matchParent, wrapContent)

                            jumlahOut = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(matchParent, wrapContent)

                            jumlahtIn = textView {
                                textSize = 16f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(matchParent, wrapContent)

                            button = button {
                                text = "Next"
                            }.lparams(matchParent, wrapContent)
                        }
                    }.lparams(matchParent, wrapContent)
                }
            }
        }

        swipeRefresh.onRefresh {
            presenterDamper.getSelectAll()
        }
        presenterDamper.getSelectAll()

        button.setOnClickListener {
            startActivity<MainActivity>()
        }
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun showProb(data: List<ItemDamper>) {
        swipeRefresh.isRefreshing = false
        item.clear()
        data.forEach {
            when {
                it.updatertlticketu.equals("IN_SLM")
                -> {
                    item.add(it)
                    when {
                        item.isEmpty()
                        -> {
                            jumlahSlm.text = " 0"
                        }
                        else -> {
                            jumlahSlm.text = item.size.toString()
                        }
                    }
                }
                it.updatertlticketu.equals("OUT_FL")
                -> {
                    item.add(it)
                    when {
                        item.isEmpty()
                        -> {
                            jumlahOut.text = "0"
                        }
                        else -> {
                            jumlahOut.text = item.size.toString()
                        }
                    }
                }
                it.updatertlticketu.equals("IN_FLM")
                -> {
                    item.add(it)
                    when {
                        item.isEmpty()
                        -> {
                            jumlahtIn.text = "0"
                        }
                        else -> {
                            jumlahtIn.text = item.size.toString()
                        }
                    }
                }
            }
        }
        waktuInsert.text = data[0].waktuinsertu
        jumlahKelolaan.text = data.size.toString()
    }

    override fun showCountIn(data: List<ItemCountIn>) {}
    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {
        swipeRefresh.isRefreshing = false
        //countKelolaan.text = "TK : " + data[0].jumlah_all_kelolaan
    }

    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {
        swipeRefresh.isRefreshing = false
        //countSlm.text = "S : " + data[0].jumlah_all_slm
    }

    override fun showCountAllOut(data: List<ItemCountAllOut>) {
        swipeRefresh.isRefreshing = false
        //countOut.text = "O : " + data[0].jumlah_all_out
    }

    override fun showCountAllIn(data: List<ItemCountAllIn>) {
        swipeRefresh.isRefreshing = false
        //countIn.text = "I  : " + data[0].jumlah_all_in
    }
}
