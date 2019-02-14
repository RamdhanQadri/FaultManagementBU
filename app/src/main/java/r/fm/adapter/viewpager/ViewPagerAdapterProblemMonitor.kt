package r.fm.adapter.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import r.fm.view.monitor.problem.Kategori
import r.fm.view.monitor.problem.ProblemNT24
import r.fm.view.monitor.problem.ProblemOutInMo

class ViewPagerAdapterProblemMonitor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> {
                ProblemOutInMo()
            }
            1 -> {
                ProblemNT24()
            }
            else -> {
                Kategori()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 ->
                "Problem"
            1 -> {
                "Problem NT"
            }
            else -> {
                "Kategori"
            }
        }
    }
}