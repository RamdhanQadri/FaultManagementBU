package r.fm.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import r.fm.R
import r.fm.view.kelolaan.KelolaanFragment
import r.fm.view.problem.tab.ProblemFragment
import r.fm.view.slm.SlmFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bri_bnv -> {
                    supportActionBar?.hide()
                    loadProblemFragment(savedInstanceState)
                }
                R.id.slm_bnv -> {
                    supportActionBar?.show()
                    loadSlmFragment(savedInstanceState)
                }
                R.id.kelolaan_bnv -> {
                    supportActionBar?.show()
                    loadKelolaanFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.bri_bnv
    }

    private fun loadProblemFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_fragment,
                    ProblemFragment(), ProblemFragment::class.java.simpleName
                )
                .commit()
        }
    }

    private fun loadSlmFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_fragment,
                    SlmFragment(), SlmFragment::class.java.simpleName
                )
                .commit()
        }

    }

    private fun loadKelolaanFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_fragment,
                    KelolaanFragment(), KelolaanFragment::class.java.simpleName
                )
                .commit()
        }
    }
}
