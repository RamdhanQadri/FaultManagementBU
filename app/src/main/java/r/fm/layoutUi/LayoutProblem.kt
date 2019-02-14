package r.fm.layoutUi

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import r.fm.R

class LayoutProblem : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.VERTICAL

                cardView {
                    linearLayout {
                        padding = dip(3)
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.CENTER_HORIZONTAL

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                id = tvTid
                                gravity = Gravity.CENTER
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 18f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                id = tvLokasi
                                gravity = Gravity.CENTER
                                textSize = 12f
                            }.lparams(matchParent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                id = tvProblem
                                gravity = Gravity.CENTER
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 20f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                id = tvUpdate_rtl_ticket
                                gravity = Gravity.CENTER
                                textSize = 12f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                textResource = R.string.last_trx
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)

                            textView {
                                id = tvLastTransaksi
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                textResource = R.string.downtime
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)

                            textView {
                                id = tvDowntime
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)

                            textView {
                                textResource = R.string.downtimehari
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)

                            textView {
                                id = tvDownhari
                                gravity = Gravity.CENTER
                                textSize = 14f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.LEFT

                            textView {
                                id = tvPengelola_cpc
                                gravity = Gravity.LEFT
                                textSize = 7f
                                typeface = Typeface.SANS_SERIF
                            }.lparams(wrapContent, wrapContent)
                        }
                    }
                }.lparams(matchParent, matchParent) {
                    setMargins(dip(2), dip(3), dip(2), dip(3))
                }
            }
        }
    }

    companion object Id {
        const val tvTid = 1
        const val tvLokasi = 2
        const val tvProblem = 3
        const val tvUpdate_rtl_ticket = 4
        const val tvLastTransaksi = 5
        const val tvDowntime = 6
        const val tvDownhari = 7
        const val tvPengelola_cpc = 8
    }
}