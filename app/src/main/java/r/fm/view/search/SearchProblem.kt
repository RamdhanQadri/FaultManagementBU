package r.fm.view.search

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.SearchView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import r.fm.R
import r.fm.adapter.AdapterProblem
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.model.*
import r.fm.presenter.PresenterItemDamper
import r.fm.view.problem.detail.tab.DetailProblem

class SearchProblem : AppCompatActivity(), HomeViewDamper {

    private var items: MutableList<ItemDamper> = mutableListOf()
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var adapter: AdapterProblem
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private var tid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val request = Api()
        val gson = Gson()
        presenterDamper = PresenterItemDamper(this, request, gson)

        adapter = AdapterProblem(items) {
            startActivity<DetailProblem>(
                "items" to it
            )
        }

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)
            backgroundResource = R.mipmap.ic_s_round

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(
                    R.color.colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
                )

                recyclerView = recyclerView {
                    id = R.id.recyclerViewId
                    lparams(matchParent, wrapContent)
                    layoutManager = LinearLayoutManager(context!!)
                }
            }.lparams(matchParent, matchParent)
        }

        recyclerView.adapter = adapter

        swipeRefresh.onRefresh {
            presenterDamper.getKelolaanSearch(tid)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_search, menu)
        val searchItem = menu.findItem(R.id.action_se)
        val searchView = searchItem.actionView as SearchView
        searchView.setIconifiedByDefault(false)
        searchView.isIconified = false
        searchView.requestFocusFromTouch()
        searchViewListen(searchView)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showProb(data: List<ItemDamper>) {
        hideLoading()
        items.clear()
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun showCountIn(data: List<ItemCountIn>) {}
    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {}
    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {}
    override fun showCountAllOut(data: List<ItemCountAllOut>) {}
    override fun showCountAllIn(data: List<ItemCountAllIn>) {}

    private fun searchViewListen(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                if (query.length > 1) {
                    try {
                        tid = query.toInt()
                        presenterDamper.getKelolaanSearch(tid)
                    } catch (e: NumberFormatException) {
                        e.printStackTrace()
                    }
                }
                return false
            }
        })
    }
}