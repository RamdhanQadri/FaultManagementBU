package r.fm.view.kelolaan

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.*
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import r.fm.R
import r.fm.R.id.monitor
import r.fm.R.id.search_me
import r.fm.adapter.AdapterKelolaan
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.model.*
import r.fm.presenter.PresenterItemDamper
import r.fm.utils.invisible
import r.fm.utils.visible
import r.fm.view.monitor.HomeActivityMo
import r.fm.view.problem.detail.tab.DetailProblem
import r.fm.view.search.SearchProblem

class KelolaanFragment : Fragment(), AnkoComponent<Context>, HomeViewDamper {
    private var item: MutableList<ItemDamper> = mutableListOf()
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var adapter: AdapterKelolaan
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var namaSentra: String
    private lateinit var jml: TextView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val spinnerItem = resources.getStringArray(R.array.sentra)
        val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, spinnerItem)
        spinner.adapter = spinnerAdapter

        adapter = AdapterKelolaan(item) {
            requireContext().startActivity<DetailProblem>(
                "items" to it
            )
        }

        recyclerView.adapter = adapter

        val request = Api()
        val gson = Gson()
        presenterDamper = PresenterItemDamper(this, request, gson)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                namaSentra = spinner.selectedItem.toString()
                presenterDamper.getKelolaanSentra(namaSentra)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        swipeRefresh.onRefresh {
            presenterDamper.getKelolaanSentra(namaSentra)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return createView(requireContext().let { AnkoContext.create(it) })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu.findItem(search_me)
        searchItem.setOnMenuItemClickListener {
            when (it.itemId) {
                search_me -> {
                    requireContext().startActivity<SearchProblem>()
                }
                monitor -> {
                    requireContext().startActivity<HomeActivityMo>()
                }
            }
            true
        }
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
                    lparams(width = matchParent, height = wrapContent)
                    gravity = Gravity.CENTER
                    jml = textView {
                        typeface = Typeface.DEFAULT_BOLD
                        textSize = 24f
                        textColorResource = R.color.colorAccent
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams(wrapContent, wrapContent)
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
        when {
            data.isEmpty()
            -> {
                jml.text = "0"
            }
            else -> {
                jml.text = " " + data.size.toString()
            }
        }
        swipeRefresh.isRefreshing = false
        item.clear()
        item.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showCountIn(data: List<ItemCountIn>) {}
    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {}
    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {}
    override fun showCountAllOut(data: List<ItemCountAllOut>) {}
    override fun showCountAllIn(data: List<ItemCountAllIn>) {}
}