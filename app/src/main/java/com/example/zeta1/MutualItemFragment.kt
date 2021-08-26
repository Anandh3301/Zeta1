package com.example.zeta1

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeta1.repository.MutualFund2.Mutual2Item
import com.example.zeta1.repository.MutualFund2.deftype
import com.example.zeta1.repository.getMutual
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * A fragment representing a list of Items.
 */
class MutualItemFragment : Fragment() {
    var data =  mutableListOf<Mutual2Item>()

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("list", "list")
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        Log.d("oncreateview","oncreateview")
        // Set the adapter



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerlist.layoutManager = LinearLayoutManager(context)
        for (i in (1..10)) {
            data.add(Mutual2Item("test", "test", "test",
                    "test", "test", "test", "test",
                    0, "test"))
        }
        Log.d("launchttt",data.toString())
        val adapter= MyMutualItemRecyclerViewAdapter(data)
        Log.d("aaa",adapter.itemCount.toString())
        recyclerlist.adapter=adapter
        getMutual("Growth"){
            data= it as MutableList<Mutual2Item>
            adapter.setData(data)
            Log.d("datata",data.toString())
            adapter.notifyDataSetChanged()
        }


        // this creates a vertical layout Manager

        Log.d("oncreateview","onviewcreated")
        // ArrayList of class ItemsViewModel

    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MutualItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

}