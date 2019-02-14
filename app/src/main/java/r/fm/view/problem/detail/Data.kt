package r.fm.view.problem.detail

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.support.v4.nestedScrollView
import r.fm.R
import r.fm.api.Api
import r.fm.interfac.HomeViewDamper
import r.fm.model.*
import r.fm.presenter.PresenterItemDamper
import r.fm.view.problem.detail.tab.DetailProblem

class Data : Fragment(), AnkoComponent<Context>, HomeViewDamper {
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var kanwil: TextView
    private lateinit var kc: TextView
    private lateinit var pengelola: TextView
    private lateinit var pengelolakode: TextView

    private lateinit var merkatm: TextView
    private lateinit var denom: TextView

    private lateinit var pagudinamis: TextView
    private lateinit var pagulembar: TextView
    private lateinit var pagudays: TextView

    private lateinit var latitude: TextView
    private lateinit var longitude: TextView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val frag = activity as DetailProblem
        val request = Api()
        val gson = Gson()
        presenterDamper = PresenterItemDamper(this, request, gson)
        presenterDamper.getKelolaanSearch(frag.passing().tidu)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(requireContext().let { AnkoContext.create(it) })
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.VERTICAL
            backgroundResource = R.mipmap.ic_s_round

            nestedScrollView {
                isVerticalScrollBarEnabled = false
                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    lparams(matchParent, wrapContent)

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.kanwil
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kanwil = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.kc
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kc = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.pengelola
                                    textSize = 15f
                                    typeface = Typeface.DEFAULT_BOLD
                                }

                                pengelola = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.pengelolakode
                                    textSize = 15f
                                    typeface = Typeface.DEFAULT_BOLD
                                }

                                pengelolakode = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }
                        }
                    }

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.merkatm
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                merkatm = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.denom
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                denom = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }
                        }
                    }

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.pagudinamis
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                pagudinamis = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.pagulembar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                pagulembar = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.pagudays
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                pagudays = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }
                        }
                    }

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.latitude
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                latitude = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.longitude
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                longitude = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun showProb(data: List<ItemDamper>) {
        kanwil.text = " " + data[0].kanwilu
        kc.text = " " + data[0].kcspvu
        pengelola.text = " " + data[0].pengelolau
        pengelolakode.text = " " + data[0].pengelolakodeu
        merkatm.text = " " + data[0].merkatmu
        denom.text = " " + data[0].denomu
        pagudinamis.text = " " + data[0].pagudinamisu
        pagulembar.text = " " + data[0].pagulembaru
        pagudays.text = " " + data[0].pagudaysu
        latitude.text = " " + data[0].latitudeu
        longitude.text = " " + data[0].longitudeu
    }

    override fun showCountIn(data: List<ItemCountIn>) {}

    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {}
    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {}
    override fun showCountAllOut(data: List<ItemCountAllOut>) {}
    override fun showCountAllIn(data: List<ItemCountAllIn>) {}
}