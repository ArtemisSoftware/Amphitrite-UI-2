package com.artemissoftware.amphitriteui2.bottomsheet.models

data class Country(
    val name: String,
    val flag: String,
    var like: Int = 0,
)

object CountriesExamples{
    val all = mutableListOf<Country>(
        Country(
            name = "United States",
            flag = "\uD83C\uDDFA\uD83C\uDDF8",
            like = 0,
        ),
        Country(
            name = "Canada",
            flag = "\uD83C\uDDE8\uD83C\uDDE6",
            like = 0,
        ),
        Country(
            name = "India",
            flag = "\uD83C\uDDEE\uD83C\uDDF3",
            like = 0,
        ),
    )
}

/*
val countries = listOf(
    Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
    Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
    Pair("India", "\uD83C\uDDEE\uD83C\uDDF3"),
    Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
    Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
    Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
    Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
    Pair("Brazil", "\uD83C\uDDE7\uD83C\uDDF7"),
    Pair("Australia", "\uD83C\uDDE6\uD83C\uDDFA"),
    Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
    Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
)
*/
