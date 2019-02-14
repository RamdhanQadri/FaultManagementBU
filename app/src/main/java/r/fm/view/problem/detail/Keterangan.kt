package r.fm.view.problem.detail

import android.content.Context
import android.graphics.Color
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

class Keterangan : Fragment(), AnkoComponent<Context>, HomeViewDamper {
    private lateinit var presenterDamper: PresenterItemDamper
    private lateinit var dtHari: TextView
    private lateinit var dtJam: TextView
    private lateinit var tglProblem: TextView
    private lateinit var wktInsert: TextView
    private lateinit var lastTunai: TextView
    private lateinit var kaset1: TextView
    private lateinit var kaset2: TextView
    private lateinit var kaset3: TextView
    private lateinit var kaset4: TextView
    private lateinit var lembar1: TextView
    private lateinit var lembar2: TextView
    private lateinit var lembar3: TextView
    private lateinit var lembar4: TextView
    private lateinit var pagu: TextView
    private lateinit var lembar: TextView
    private lateinit var sisasaldo: TextView
    private lateinit var ket: TextView

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
                                    textResource = R.string.downtime
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                dtHari = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)

                                textView {
                                    textResource = R.string.downtimehari
                                    textSize = 15f
                                }

                                dtJam = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.tglProblem
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                tglProblem = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.wktInsert
                                    textSize = 15f
                                    typeface = Typeface.DEFAULT_BOLD
                                }

                                wktInsert = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.last_trx
                                    textSize = 15f
                                    typeface = Typeface.DEFAULT_BOLD
                                }

                                lastTunai = textView {
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
                                    textResource = R.string.kaset1
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kaset1 = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.lembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                lembar1 = textView {
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
                                    textResource = R.string.kaset2
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kaset2 = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.lembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                lembar2 = textView {
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
                                    textResource = R.string.kaset3
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kaset3 = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.lembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                lembar3 = textView {
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
                                    textResource = R.string.kaset4
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                kaset4 = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.lembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                lembar4 = textView {
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
                                    textResource = R.string.pagu
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                pagu = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.totalLembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                lembar = textView {
                                    textSize = 15f
                                }.lparams(wrapContent, wrapContent)
                            }

                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.sisaLembarKeluar
                                    typeface = Typeface.DEFAULT_BOLD
                                    textColor = Color.GREEN
                                    textSize = 20f
                                }

                                sisasaldo = textView {
                                    textSize = 20f
                                    typeface = Typeface.DEFAULT_BOLD
                                    textColor = Color.GREEN
                                }.lparams(wrapContent, wrapContent)
                            }
                        }
                    }

                    cardView {
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            linearLayout {
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.LEFT
                                padding = dip(3)

                                textView {
                                    textResource = R.string.ket
                                    typeface = Typeface.DEFAULT_BOLD
                                    textSize = 15f
                                }

                                ket = textView {
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
        dtHari.text = " " + data[0].downtimehariu + " "
        dtJam.text = " " + data[0].downtimejamu
        tglProblem.text = " " + data[0].tglproblemu
        wktInsert.text = " " + data[0].waktuinsertu
        lastTunai.text = " " + data[0].lastsuksesu
        kaset1.text = " " + data[0].disp1u
        lembar1.text = " " + data[0].lembar1u
        kaset2.text = " " + data[0].disp2u
        lembar2.text = " " + data[0].lembar2u
        kaset3.text = " " + data[0].disp3u
        lembar3.text = " " + data[0].lembar3u
        kaset4.text = " " + data[0].disp4u
        lembar4.text = " " + data[0].lembar4u
        lembar.text = " " + data[0].lembaru
        pagu.text = " " + data[0].paguu
        sisasaldo.text = " " + data[0].sisasaldou
        ket.text = data[0].rtlketeranganu
    }

    override fun showCountIn(data: List<ItemCountIn>) {}
    override fun showCountOut(data: List<ItemCountOut>) {}

    override fun showCountAllkelolaan(data: List<ItemCountAllKelolaan>) {}
    override fun showCountAllSlm(data: List<ItemCountAllSlm>) {}
    override fun showCountAllOut(data: List<ItemCountAllOut>) {}
    override fun showCountAllIn(data: List<ItemCountAllIn>) {}
}