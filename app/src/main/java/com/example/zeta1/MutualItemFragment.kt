package com.example.zeta1

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zeta1.repository.MutualFund2.Mutual2Item
import com.example.zeta1.repository.MutualFund2.deftype
import com.example.zeta1.repository.MutualFund2.listofItems
import com.example.zeta1.repository.getMutual
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * A fragment representing a list of Items.
 */
class MutualItemFragment : Fragment() {
    private lateinit var adapter: MyMutualItemRecyclerViewAdapter
    var data =  mutableListOf<Mutual2Item>()

    private var columnCount = 1
var createcount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createcount++
        Log.d("oncreate", "oncreate : $createcount")
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


        radioGrowth.setOnClickListener {
            Toast.makeText(activity,"Growth clicked",Toast.LENGTH_SHORT).show()
            updatedata("Growth")
        }
        radioIDCW.setOnClickListener {
            Toast.makeText(activity,"IDCW clicked",Toast.LENGTH_SHORT).show()
            updatedata("IDCW")
        }
        radioDIV.setOnClickListener {
            Toast.makeText(activity,"DIV clicked",Toast.LENGTH_SHORT).show()
            updatedata("Dividend")
        }
        recyclerlist.layoutManager = LinearLayoutManager(context)
        for (i in (1..10)) {
            data.add(Mutual2Item("test", "test", "test",
                    "test", "test", "test", "test",
                    0, "test"))
        }
        Log.d("launchttt",data.toString())
   // updatedata("Growth")

         adapter= MyMutualItemRecyclerViewAdapter(data)
        Log.d("aaa",adapter.itemCount.toString())

        recyclerlist.adapter=adapter

            Log.d("datata",data.toString())
        updatedata("Growth")
            adapter.notifyDataSetChanged()

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
    fun updatedata(  str : String)
    {

        Log.d("aaa",adapter.itemCount.toString())
        Log.d("aaa",str)


            data= listofItems.filter { it.Growth_or_Dividend_or_IDCW.equals(str) } as MutableList<Mutual2Item>
            adapter.setData(data)
            Log.d("datata",data.toString())
            adapter.notifyDataSetChanged()

    }
}