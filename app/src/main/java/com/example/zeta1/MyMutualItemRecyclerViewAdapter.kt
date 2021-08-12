package com.example.zeta1

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.zeta1.dummy.DummyContent.DummyItem
import com.example.zeta1.repository.MutualFund2.Mutual2Item

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMutualItemRecyclerViewAdapter(
    private val values: List<Mutual2Item>
) : RecyclerView.Adapter<MyMutualItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_mutual2item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
      //  holder.idName.text = item.id
        //holder.idPrice.text = item.
        //holder.idPercent.text="" set percent
        //holder.iddate.text= // set date
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idName: TextView = view.findViewById(R.id.nameT)
        val idPrice: TextView = view.findViewById(R.id.content)
        val idPercent : TextView= view.findViewById(R.id.percent)
        val iddate : TextView= view.findViewById(R.id.date)

        override fun toString(): String {
            return super.toString()
        }
    }
}