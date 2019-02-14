package r.fm.adapter.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import r.fm.view.problem.ProblemOutInOpenProblem
import r.fm.view.problem.ProblemWarning

class ViewPagerAdapterProblem(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> {
                ProblemOutInOpenProblem()
            }
            else -> {
                ProblemWarning()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 ->
                "Problem"
            else -> {
                "Warning"
            }
        }
    }
}