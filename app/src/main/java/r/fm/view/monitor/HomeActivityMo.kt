package r.fm.view.monitor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_mo.*
import r.fm.R
import r.fm.view.monitor.problem.tab.ProblemFragmentMo
import r.fm.view.monitor.slm.tab.SlmFragmentMo

class HomeActivityMo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_mo)

        bottom_navigation_monitor.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bri_bnv_monitor -> {
                    supportActionBar?.hide()
                    loadProblemFragmentMonitor(savedInstanceState)
                }
                R.id.slm_bnv_monitor -> {
                    supportActionBar?.hide()
                    loadSlmFragmentMonitor(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation_monitor.selectedItemId = R.id.bri_bnv_monitor
    }

    private fun loadProblemFragmentMonitor(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_fragment_monitor,
                    ProblemFragmentMo(), ProblemFragmentMo::class.java.simpleName
                )
                .commit()
        }
    }

    private fun loadSlmFragmentMonitor(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_fragment_monitor,
                    SlmFragmentMo(), SlmFragmentMo::class.java.simpleName
                )
                .commit()
        }

    }
}
