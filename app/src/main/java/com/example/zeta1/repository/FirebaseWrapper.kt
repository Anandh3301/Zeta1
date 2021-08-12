package com.example.zeta1.repository

import android.util.Log
import com.example.zeta1.repository.MutualFund2.Mutual2Item
import com.example.zeta1.repository.MutualFund2.listofItems
import com.google.firebase.database.*


fun getMutual(callbackfun: (List<Mutual2Item>) -> (Unit)) {
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef: DatabaseReference = database.getReference()

    Log.d("inmutual", "inmutual")
    //.orderByChild("Growth_or_Dividend_or_IDCW").equalTo("sf")
    //myRef.orderByChild("Fund_house").equalTo("BNP Paribas Mutual Fund").limitToFirst(10)
myRef.orderByChild("Growth_or_Dividend_or_IDCW").equalTo("Growth").limitToFirst(30)
.addValueEventListener(object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            //
        }

        override fun onDataChange(snapshot: DataSnapshot) {


            snapshot.children.forEach {
                Log.d("plswork",it.toString())
                Log.d("menu", it.toString())
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
    } // ...

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
