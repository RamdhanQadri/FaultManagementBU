package r.fm.view.problem.detail.tab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import r.fm.R
import r.fm.adapter.viewpager.ViewPagerAdapterProblemDetail
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.model.*
import r.fm.presenter.PresenterItemDamper

class DetailProblem : AppCompatActivity(), HomeViewDamper {
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var items: ItemDamper

    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        items = intent.getParcelableExtra("items")

        toolbarTeam.setNavigationIcon(R.drawable.abc_ic_ab_back_material)
        menuItem = toolbarTeam.menu

        toolbarTeam.setNavigationOnClickListener {
            finish()
        }

        val req = Api()
        val gson = Gson()
        presenterDamper = PresenterItemDamper(this, req, gson)
        presenterDamper.getKelolaanSearch(items.tidu)

        val fragAdapter = ViewPagerAdapterProblemDetail(supportFragmentManager)
        pagerTeam.adapter = fragAdapter
        tabLayoutTeam.setupWithViewPager(pagerTeam)

    }

    fun passing() = items

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun showProb(data: List<ItemDamper>) {
        tv_tid.text = data[0].tidu.toString()
        tv_lokasi.text = data[0].lokasiu
        tv_problem.text = data[0].problemu
        tv_status.text = data[0].updatertlticketu
        tv_cpc.text = data[0].pengelolacpcu
    }

    override fun showCountIn(data: List<ItemCountIn>) {}
    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {}
    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {}
    override fun showCountAllOut(data: List<ItemCountAllOut>) {}
    override fun showCountAllIn(data: List<ItemCountAllIn>) {}
}