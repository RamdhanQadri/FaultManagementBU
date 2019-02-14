package r.fm.layoutUi

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import r.fm.R

class LayoutProblemNT6 : AnkoComponent<ViewGroup> {
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
                                textResource = R.string.no_trx
                                gravity = Gravity.CENTER
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 20f
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
                            gravity = Gravity.LEFT

                            textView {
                                id = tvPengelola_cpc
                                gravity = Gravity.LEFT
                                textSize = 7f
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
        const val tvLastTransaksi = 3
        const val tvPengelola_cpc = 6
    }
}