package r.fm.layoutUi

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class LayoutKelolaan : AnkoComponent<ViewGroup> {
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
                                textSize = 18f
                            }.lparams(wrapContent, wrapContent)
                        }

                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            gravity = Gravity.CENTER

                            textView {
                                id = tvProblem
                                gravity = Gravity.CENTER
                                typeface = Typeface.DEFAULT_BOLD
                                textSize = 18f
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
        const val tvPengelola_cpc = 2
        const val tvProblem = 3
    }
}