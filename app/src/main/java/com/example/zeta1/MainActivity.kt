package com.example.zeta1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zeta1.repository.MutualFund2.deftype
import com.example.zeta1.repository.getMutual
import kotlinx.android.synthetic.main.activity_main.*
// 01:19
val MY_PREFS_NAME = "TYPE"
var type = "Growth"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMutual("Growth"){

        }
        Log.d("main", "main")

    }
/*
    fun GROWTH(view: View) {
        Toast.makeText(this, "showing growth", Toast.LENGTH_LONG).show()
        deftype="Growth"

        val editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
        editor.putString("type", "Growth")
        editor.apply()
        recreate()
    }
    fun IDCW(view: View) {
        Toast.makeText(this, "showing IDCW", Toast.LENGTH_LONG).show()
        deftype="IDCW"
        val editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
        editor.putString("type", "IDCW")
        editor.apply()
        recreate()
    }
    fun DIV(view: View) {
        Toast.makeText(this, "showing DIV", Toast.LENGTH_LONG).show()
        deftype="Dividend"
        val editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
        editor.putString("type", "Dividend")
        editor.apply()
        recreate()
    }

*/

}