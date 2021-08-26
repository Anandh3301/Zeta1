package com.example.zeta1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zeta1.repository.parseNAV
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_graph.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GraphFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GraphFragment : Fragment() {
    private var x: MutableList<String>? = null

    // TODO: Rename and change types of parameters
    private var fund_name: String? = null
    private var scheme: String? = null
    private var nav : String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fund_name = it.getString("fund_house")
            scheme = it.getString("fund_scheme")
            nav = it.getString("nav")
            x= nav?.let { it1 -> parseNAV(it1) }
            Log.d("graph", fund_name + "@" + scheme + "@" + nav)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graph, container, false)

    }
    var entryList= mutableListOf<Entry>()

    var lineData: LineData? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("porsed",x.toString())
        x?.reverse()

        for (i in (x!!.size-10)..x!!.size-1)
        { val num=  x!![i].split('@')[1].toFloat()
            entryList.add(Entry(i.toFloat(), num))
        }
        val lineDataSet = LineDataSet(entryList, "country")
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.fillAlpha = 110
        lineData = LineData(lineDataSet)
        lineChart.setData(lineData)
        lineChart.setVisibleXRangeMaximum(10F)
        lineChart.invalidate()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GraphFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GraphFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}