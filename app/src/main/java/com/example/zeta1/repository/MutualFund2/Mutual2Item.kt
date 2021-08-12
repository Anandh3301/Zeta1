package com.example.zeta1.repository.MutualFund2
val listofItems = mutableListOf<Mutual2Item>()
data class Mutual2Item(
    val Fund_house: String="",
    val Growth_or_Dividend_or_IDCW: String="",
    val Last_updated: String="",
    val NAV: String="",
    val Regular_or_Direct: String="",
    val Scheme_Category: String="",
    val Scheme_Subcategory: String="",
    val Scheme_code: Int=0,
    val Scheme_name: String=""
)