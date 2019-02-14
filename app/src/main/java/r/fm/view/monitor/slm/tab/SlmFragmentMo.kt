package r.fm.view.monitor.slm.tab

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_fragment.*
import r.fm.R
import r.fm.adapter.viewpager.ViewPagerAdapterSlm

class SlmFragmentMo : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragAdapter = ViewPagerAdapterSlm(childFragmentManager)
        pager.adapter = fragAdapter
        tabLayout.setupWithViewPager(pager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_fragment, container, false)
    }
}