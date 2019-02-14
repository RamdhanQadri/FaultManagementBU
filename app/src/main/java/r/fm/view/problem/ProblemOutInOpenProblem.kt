package r.fm.view.problem

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
import r.fm.adapter.AdapterOpenProblem
import r.fm.api.Api
import r.fm.interfac.HomeViewOpenProblem
import r.fm.model.ItemDateHour
import r.fm.model.ItemOpenProblem
import r.fm.presenter.PresenterItemOpenProblem
import r.fm.utils.invisible
import r.fm.utils.visible
import r.fm.view.problem.detail.tab.DetailProblem

class ProblemOutInOpenProblem : Fragment(), AnkoComponent<Context>, HomeViewOpenProblem {
    private var item: MutableList<ItemOpenProblem> = mutableListOf()
    private var itemDate: MutableList<ItemDateHour> = mutableListOf()
    private lateinit var presenterOpenProblem: PresenterItemOpenProblem
    private lateinit var adapter: AdapterOpenProblem
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var namaSentra: String
    private lateinit var kodeSentra: String
    private lateinit var statusProblem: String
    private lateinit var jml: TextView
    private lateinit var wktInsert: TextView
    private lateinit var share: Button

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val spinnerItem = resources.getStringArray(R.array.sentra)
        val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, spinnerItem)
        spinner.adapter = spinnerAdapter

        adapter = AdapterOpenProblem(item) {
            requireContext().startActivity<DetailProblem>(
                "items" to it
            )
        }

        recyclerView.adapter = adapter

        val request = Api()
        val gson = Gson()
        presenterOpenProblem = PresenterItemOpenProblem(this, request, gson)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                namaSentra = spinner.selectedItem.toString()
                if (namaSentra.equals("SSI AMBON")) {
                    kodeSentra = "AMB"
                } else if (namaSentra.equals("SSI BALIKPAPAN")) {
                    kodeSentra = "BPP"
                } else if (namaSentra.equals("SSI BANDA ACEH")) {
                    kodeSentra = "BNA"
                } else if (namaSentra.equals("SSI BANJARBARU")) {
                    kodeSentra = "BJB"
                } else if (namaSentra.equals("SSI BANJARMASIN")) {
                    kodeSentra = "BJM"
                } else if (namaSentra.equals("SSI BANYUWANGI")) {
                    kodeSentra = "BWI"
                } else if (namaSentra.equals("SSI BATAM")) {
                    kodeSentra = "BTM"
                } else if (namaSentra.equals("SSI BEKASI")) {
                    kodeSentra = "BKS"
                } else if (namaSentra.equals("SSI BENGKULU")) {
                    kodeSentra = "BKL"
                } else if (namaSentra.equals("SSI BIMA")) {
                    kodeSentra = "BMA"
                } else if (namaSentra.equals("SSI BOGOR")) {
                    kodeSentra = "BGR"
                } else if (namaSentra.equals("SSI BOJONEGORO")) {
                    kodeSentra = "BRO"
                } else if (namaSentra.equals("SSI BSD")) {
                    kodeSentra = "BSD"
                } else if (namaSentra.equals("SSI CIBINONG")) {
                    kodeSentra = "CBI"
                } else if (namaSentra.equals("SSI CIKARANG")) {
                    kodeSentra = "CKR"
                } else if (namaSentra.equals("SSI DENPASAR")) {
                    kodeSentra = "DPS"
                } else if (namaSentra.equals("SSI DEPOK")) {
                    kodeSentra = "DPK"
                } else if (namaSentra.equals("SSI DUKUH BAWAH")) {
                    kodeSentra = "DKB"
                } else if (namaSentra.equals("SSI DUMAI")) {
                    kodeSentra = "DMI"
                } else if (namaSentra.equals("SSI DURI")) {
                    kodeSentra = "DRI"
                } else if (namaSentra.equals("SSI ENDE")) {
                    kodeSentra = "END"
                } else if (namaSentra.equals("SSI FATMAWATI")) {
                    kodeSentra = "FMI"
                } else if (namaSentra.equals("SSI GORONTALO")) {
                    kodeSentra = "GTO"
                } else if (namaSentra.equals("SSI HARMONI 1")) {
                    kodeSentra = "HMN"
                } else if (namaSentra.equals("SSI HARMONI 2")) {
                    kodeSentra = "HMN2"
                } else if (namaSentra.equals("SSI JAMBI")) {
                    kodeSentra = "JBI"
                } else if (namaSentra.equals("SSI JATIWARNA")) {
                    kodeSentra = "JTW"
                } else if (namaSentra.equals("SSI JAYAPURA")) {
                    kodeSentra = "JAP"
                } else if (namaSentra.equals("SSI KARAWANG")) {
                    kodeSentra = "KWG"
                } else if (namaSentra.equals("SSI KENDARI")) {
                    kodeSentra = "KDR"
                } else if (namaSentra.equals("SSI KUPANG")) {
                    kodeSentra = "KPA"
                } else if (namaSentra.equals("SSI LANGSA")) {
                    kodeSentra = "LGS"
                } else if (namaSentra.equals("SSI LHOKSEUMAWE")) {
                    kodeSentra = "LSW"
                } else if (namaSentra.equals("SSI LUWUK")) {
                    kodeSentra = "LWK"
                } else if (namaSentra.equals("SSI MANADO")) {
                    kodeSentra = "MDO"
                } else if (namaSentra.equals("SSI MATARAM")) {
                    kodeSentra = "MTR"
                } else if (namaSentra.equals("SSI MAUMERE")) {
                    kodeSentra = "MRE"
                } else if (namaSentra.equals("SSI MEDAN")) {
                    kodeSentra = "MDN"
                } else if (namaSentra.equals("SSI MEULABOH")) {
                    kodeSentra = "MBO"
                } else if (namaSentra.equals("SSI MUARA BUNGO")) {
                    kodeSentra = "MRB"
                } else if (namaSentra.equals("SSI PADANG")) {
                    kodeSentra = "PDG"
                } else if (namaSentra.equals("SSI PADANG SIDEMPUAN")) {
                    kodeSentra = "PSP"
                } else if (namaSentra.equals("SSI PALANGKARAYA")) {
                    kodeSentra = "PLK"
                } else if (namaSentra.equals("SSI PALOPO")) {
                    kodeSentra = "PLP"
                } else if (namaSentra.equals("SSI PALU")) {
                    kodeSentra = "PLU"
                } else if (namaSentra.equals("SSI PANGKALAN KERINCI")) {
                    kodeSentra = "PKR"
                } else if (namaSentra.equals("SSI PASURUAN")) {
                    kodeSentra = "PSN"
                } else if (namaSentra.equals("SSI PEKANBARU")) {
                    kodeSentra = "PKU"
                } else if (namaSentra.equals("SSI PEMATANG SIANTAR")) {
                    kodeSentra = "PMS"
                } else if (namaSentra.equals("SSI PONDOK BAMBU")) {
                    kodeSentra = "PDB"
                } else if (namaSentra.equals("SSI RANTAU PRAPAT")) {
                    kodeSentra = "RTP"
                } else if (namaSentra.equals("SSI RENGAT")) {
                    kodeSentra = "RGT"
                } else if (namaSentra.equals("SSI SAMARINDA")) {
                    kodeSentra = "SMD"
                } else if (namaSentra.equals("SSI SAMPIT")) {
                    kodeSentra = "SPT"
                } else if (namaSentra.equals("SSI SELONG")) {
                    kodeSentra = "SLG"
                } else if (namaSentra.equals("SSI SEMARANG")) {
                    kodeSentra = "SMG"
                } else if (namaSentra.equals("SSI SERANG")) {
                    kodeSentra = "SRG"
                } else if (namaSentra.equals("SSI SINGARAJA")) {
                    kodeSentra = "SGR"
                } else if (namaSentra.equals("SSI SORONG")) {
                    kodeSentra = "SON"
                } else if (namaSentra.equals("SSI SUMBAWA")) {
                    kodeSentra = "SBW"
                } else if (namaSentra.equals("SSI TANGERANG 1")) {
                    kodeSentra = "TRG"
                } else if (namaSentra.equals("SSI TANGERANG 2")) {
                    kodeSentra = "TRG2"
                } else if (namaSentra.equals("SSI TERNATE")) {
                    kodeSentra = "TNT"
                } else if (namaSentra.equals("SSI TJ. BALAI KARIMUN")) {
                    kodeSentra = "TBK"
                } else if (namaSentra.equals("SSI TJ. PINANG")) {
                    kodeSentra = "TJP"
                } else if (namaSentra.equals("SSI UJUNG BATU")) {
                    kodeSentra = "UBT"
                } else {
                    kodeSentra = ""
                }
                presenterOpenProblem.getAllOpenProblemOutIn()
                presenterOpenProblem.getAllDateHour()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        swipeRefresh.onRefresh {
            presenterOpenProblem.getAllOpenProblemOutIn()
            presenterOpenProblem.getAllDateHour()
        }
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
            spinner = spinner()
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

    override fun showOpenProblem(data: List<ItemOpenProblem>) {
        swipeRefresh.isRefreshing = false
        item.clear()
        data.forEach {
            if (it.pengelola.equals(kodeSentra)) {
                item.add(it)
            }
        }
        share.setOnClickListener {
            try {
                var myClipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                var copi: String? = "Problem ${namaSentra} : ${item.size} ATM. \n\n"
                for (problem in item) {
                    var problem1 = problem.problem?.toInt()
                    val detailproblem = problem.detailproblem?.toInt()
                    val subdetailproblem = problem.subdetailproblem?.toInt()
                    if (problem1 == 1) {
                        statusProblem = "Restocking"
                    } else if (problem1 == 2) {
                        statusProblem = "Maintenance"
                    } else if (problem1 == 3) {
                        statusProblem = "Cash Out"
                    } else if (problem1 == 4) {
                        statusProblem = ""
                        if (detailproblem == 1) {
                            statusProblem = "Journal"
                        } else if (detailproblem == 2) {
                            statusProblem = "Card Reader"
                        } else if (detailproblem == 3) {
                            statusProblem = "Receipt"
                        } else if (detailproblem == 4) {
                            statusProblem = "DF"
                            if (subdetailproblem == 1) {
                                statusProblem = " CO"
                            } else if (subdetailproblem == 1) {
                                statusProblem = " Cassete"
                            } else if (subdetailproblem == 2) {
                                statusProblem = ""
                            }
                        } else if (detailproblem == 5) {
                            statusProblem = "EPP"
                        } else if (detailproblem == 6) {
                            statusProblem = "Presenter Error"
                        }
                    } else if (problem1 == 5) {
                        statusProblem = "Down"
                    } else if (problem1 == 6) {
                        statusProblem = "Warning "
                        if (detailproblem == 1) {
                            statusProblem = "3 Cassette Failed"
                        } else if (detailproblem == 2) {
                            statusProblem = "Cash Low"
                        }
                    }
                    var detail = "Tid : " + problem.tid.toString() + "\n" +
                            "Lokasi : " + problem.lokasi + "\n" +
                            "Problem : " + statusProblem + "\n" +
                            "Status : " + problem.description + "\n" +
                            "Open Problem : " + problem.openproblem + "\n" +
                            "Downtime : " + problem.duration + "\n\n"
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
        adapter.notifyDataSetChanged()
        when {
            item.isEmpty()
            -> {
                jml.text = " 0"
            }
            else -> {
                jml.text = " " + item.size.toString()
            }
        }

    }

    override fun showDateHour(data: List<ItemDateHour>) {
        swipeRefresh.isRefreshing = false
        itemDate.clear()
        data.forEach {
            if (it.id.equals("2")) {
                itemDate.add(it)
            }
        }
        adapter.notifyDataSetChanged()
        wktInsert.text = " " + itemDate[0].tgl?.substring(0, 16)
    }
}