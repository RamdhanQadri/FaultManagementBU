package r.fm.view.monitor.problem

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import r.fm.R
import r.fm.adapter.AdapterProblemNT24
import r.fm.api.Api
import r.fm.interfac.HomeViewMonitor
import r.fm.model.ItemDamper
import r.fm.presenter.PresenterItemMonitor
import r.fm.utils.invisible
import r.fm.utils.visible
import r.fm.view.problem.detail.tab.DetailProblem

class ProblemNT24: Fragment(), AnkoComponent<Context>, HomeViewMonitor {
    private var item: MutableList<ItemDamper> = mutableListOf()
    private lateinit var presenter: PresenterItemMonitor
    private lateinit var adapter: AdapterProblemNT24
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var wktInsert: TextView
    private lateinit var jml: TextView
    private lateinit var share: Button

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = AdapterProblemNT24(item) {
            requireContext().startActivity<DetailProblem>(
                "items" to it
            )
        }

        recyclerView.adapter = adapter

        val request = Api()
        val gson = Gson()
        presenter = PresenterItemMonitor(this, request, gson)

        swipeRefresh.onRefresh {
            presenter.getProblemNt24SSI()
        }
        presenter.getProblemNt24SSI()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(requireContext().let { AnkoContext.create(it) })
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(8)
            leftPadding = dip(8)
            rightPadding = dip(8)
            backgroundResource = R.mipmap.ic_s_round
            cardView {
                backgroundColorResource = R.color.colorPrimary
                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER_HORIZONTAL

                        textView {
                            textResource = R.string.wktInsert
                            textSize = 10f
                            gravity = Gravity.CENTER_HORIZONTAL
                        }.lparams(wrapContent, wrapContent)

                        wktInsert = textView {
                            textSize = 10f
                            gravity = Gravity.CENTER_HORIZONTAL
                        }.lparams(wrapContent, wrapContent)
                    }.lparams(matchParent, wrapContent) {
                        weight = 1F
                        padding = dip(5)
                    }
                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                textResource = R.string.total
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 18f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(wrapContent, wrapContent)

                            jml = textView {
                                textSize = 18f
                                gravity = Gravity.CENTER_HORIZONTAL
                            }.lparams(wrapContent, wrapContent)
                        }.lparams(wrapContent, wrapContent) {
                            weight = 1F
                            padding = dip(5)
                        }
                    }
                    share = button {
                        text = "Share"
                    }.lparams(matchParent, wrapContent)
                }
            }.lparams(matchParent, wrapContent) {
                setMargins(dip(2), dip(3), dip(2), dip(3))
            }
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(
                    R.color.colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
                )
                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)
                    recyclerView = recyclerView {
                        id = R.id.recyclerViewId
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                    progressBar = progressBar {
                    }.lparams {
                        centerHorizontally()
                    }
                }
            }
        }
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showProb(data: List<ItemDamper>) {
        swipeRefresh.isRefreshing = false
        item.clear()
        data.forEach {
            when {
                it.haurdowntimetunaiu!! >= 24.toString()
                -> {
                    item.add(it)
                    when {
                        item.isEmpty()
                        -> {
                            jml.text = "0"
                        }
                        else -> {
                            jml.text = " " + item.size.toString()
                        }
                    }
                    share.setOnClickListener {
                        try {
                            var myClipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            var copi: String? = "Problem No Trx > 1 Hari : ${item.size} ATM. Waktu Insert : ${item[0].waktuinsertu}   \n\n"
                            for (problem in item) {
                                var detail = "Tid : " + problem.tidu.toString() + "\n" +
                                        "Lokasi : " + problem.lokasiu + "\n" +
                                        "Problem : No Trx > 1 Hari " + "\n" +
                                        "Last Tunai : " + problem.lastsuksesu + "\n"  +
                                        "DownTime Tunai : " + problem.haurdowntimetunaiu + " Hari" + "\n" +
                                        "Sentra : " + problem.pengelolacpcu + "\n\n"
                                copi += detail
                            }

                            var myClip = ClipData.newPlainText(null, copi)
                            myClipboard.primaryClip = myClip
                            Toast.makeText(requireContext(), "Copied to Clipboard", Toast.LENGTH_LONG).show()

                            var shareIntent = Intent(Intent.ACTION_SEND_MULTIPLE)
                            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                .putExtra(Intent.EXTRA_SUBJECT, "Problem")
                                .putExtra(Intent.EXTRA_TEXT, copi).type = "text/html"
                            startActivity(shareIntent)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
        adapter.notifyDataSetChanged()
        wktInsert.text = data[0].waktuinsertu
    }
}