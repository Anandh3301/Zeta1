package com.example.zeta1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zeta1.repository.MutualFund2.Mutual2Item
import java.lang.Exception


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMutualItemRecyclerViewAdapter(
        private var values: List<Mutual2Item>
) : RecyclerView.Adapter<MyMutualItemRecyclerViewAdapter.ViewHolder>() {
    fun setData(items: List<Mutual2Item>) {
        values = items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_mutual2item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
            var schemename=item.Scheme_name
            if(schemename.length>40)
            schemename=schemename.substring(40)+"..."


        holder.idSName.text = schemename
//        val obj = JSONObject(item.NAV)
        holder.idFName.text=  item.Fund_house
        holder.growth_div_idcw.text=item.Growth_or_Dividend_or_IDCW
       try {
           val today: Double = item.navaslist[0].split('@')[1].toDouble()
           val yesterday: Double = item.navaslist[7].split('@')[1].toDouble()
           var percent = ((today - yesterday) * 100.0 / today).toString()
           if (percent.length > 5)
               percent = percent.substring(0, 4)
           holder.idPercent.text = percent.toString() + "%"
           //Log.d("binder",.toString())
           holder.idPrice.text = "₹ " + item.navaslist[0].split('@')[1]

           holder.iddate.text = item.navaslist[0].split('@')[0]

           holder.detailsB.setOnClickListener {

               val bundle = Bundle()
               bundle.putString("fund_house", item.Fund_house)
               bundle.putString("fund_scheme", item.Scheme_name)
               bundle.putString("nav", item.NAV)
               //bundle.putString("image", item.image)

               holder.detailsB.findNavController()
                       .navigate(R.id.action_mutualItemFragment_to_graphFragment, bundle)
           }
       }
       catch (e : Exception
       )
       {

       }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idSName: TextView = view.findViewById(R.id.nameT)
        val idFName: TextView = view.findViewById(R.id.house)
        val idPrice: TextView = view.findViewById(R.id.price)
        val idPercent : TextView= view.findViewById(R.id.percent)
        val iddate : TextView= view.findViewById(R.id.date)
        val detailsB = view.findViewById<Button>(R.id.detailB)
        val growth_div_idcw : TextView= view.findViewById(R.id.growth_div_idcw)

        override fun toString(): String {
            return super.toString()
        }
    }
}
