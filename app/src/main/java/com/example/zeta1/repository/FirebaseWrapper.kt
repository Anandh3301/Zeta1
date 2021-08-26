package com.example.zeta1.repository

import android.util.Log
import com.example.zeta1.repository.MutualFund2.Mutual2Item
import com.example.zeta1.repository.MutualFund2.listofItems
import com.google.firebase.database.*
import org.json.JSONArray
import org.json.JSONObject
// parses the NAV data which is a string. Converts it to a MutableList<String> for further processing
fun parseNAV(jsonString : String) : MutableList<String> {
    val inputArray: JSONArray = JSONArray(jsonString)
    val arraylistofnav = mutableListOf<String>()
    for ( i in 0..inputArray.length()-1)
    {
        val jo: JSONObject = inputArray.getJSONObject(i)
        val date =  jo.getString("date")
        val nav=  jo.getString("nav")
        arraylistofnav.add(date+"@"+nav)
       // Log.d("parse",date+"@"+nav)
    }
    return arraylistofnav
}

fun getMutual(type: String, callbackfun: (List<Mutual2Item>) -> (Unit)) {
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef: DatabaseReference = database.getReference()
    for (i in 1..200)
    {   Log.d("test", i.toString())
        myRef.child("$i").
        addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                //
            }

            override fun onDataChange(snapshot: DataSnapshot) {
//                Log.d("snapshot", snapshot.getValue(String::class.java)!!)
                val isgrowth: String = snapshot.child("Growth_or_Dividend_or_IDCW").getValue(String::class.java)!!
                Log.d("ISGROWTH", isgrowth)
                /* when(isgrowth)
                {
                    "Growth" -> {
//                    Log.d("added","added :::: ${snapshot.toString()}")
                      val stuff=  snapshot.getValue(Mutual2Item::class.java)
                        if (stuff != null) {
                            Log.d("added","added :: ${stuff.Growth_
                            or_Dividend_or_IDCW}:: ${stuff.Scheme_code}")
                        }

                    }
                }*/

                      Log.d("istype","added :::: ${type}")

                    val stuff = snapshot.getValue(Mutual2Item::class.java)

                    if (stuff != null) {

                        stuff.navaslist=  parseNAV(stuff.NAV)
                        Log.d("added", "added :: ${stuff.Growth_or_Dividend_or_IDCW}:: ${stuff.Scheme_code}")
                        listofItems.add(stuff)

                    }


                /*  snapshot.children.forEach {
                    Log.d("plswork", it.toString())
                    Log.d("mutual", it.toString())
//                    val i = it.getValue(Mutual2Item::class.java)

                    //  if (i != null) {
                    //     Log.d("mapped",i.Growth_or_Dividend_or_IDCW)
                    //    listofItems.add(i)


                    //  }


                }*/

                callbackfun(listofItems)

            }


        })


    }
    Log.d("inmutual", "inmutual")
    //.orderByChild("Growth_or_Dividend_or_IDCW").equalTo("sf")
    //myRef.orderByChild("Fund_house").equalTo("BNP Paribas Mutual Fund").limitToFirst(10)
/*myRef.limitToFirst(10).addValueEventListener(object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            //
        }

        override fun onDataChange(snapshot: DataSnapshot) {


            snapshot.children.forEach {
                Log.d("plswork",it.toString())
                Log.d("mutual", it.toString())
                val i = it.getValue(Mutual2Item::class.java)

                if (i != null) {
                    Log.d("mapped",i.Growth_or_Dividend_or_IDCW)
                    listofItems.add(i)



            }


        }

          callbackfun(listofItems)

        }
    })
    /*    .addChildEventListener(object : ChildEventListener {
    override fun onChildAdded(dataSnapshot: DataSnapshot, prevChildKey: String?) {
       Log.d("plswork",dataSnapshot.toString())
    } // ...*/

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })*/



}
