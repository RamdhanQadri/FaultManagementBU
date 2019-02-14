package r.fm.view.problem.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_fragment.*
import org.jetbrains.anko.startActivity
import r.fm.R
import r.fm.R.id.monitor
import r.fm.R.id.search_me
import r.fm.adapter.viewpager.ViewPagerAdapterProblem
import r.fm.view.monitor.HomeActivityMo
import r.fm.view.search.SearchProblem

class ProblemFragment: Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragAdapter = ViewPagerAdapterProblem(childFragmentManager)
        pager.adapter = fragAdapter
        tabLayout.setupWithViewPager(pager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.inflateMenu(R.menu.search_menu)
        toolbar.setOnMenuItemClickListener {
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
}