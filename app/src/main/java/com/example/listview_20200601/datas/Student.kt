package com.example.listview_20200601.datas

class Student(val name: String,val birthYear: Int, val isMale:Boolean) {
////
//    val nowAge = 2020 - birthYear + 1
//    val nameWithAge = "${name} (${nowAge}세)"

    fun getKoreanAge(year:Int) : Int {

        return year - this.birthYear + 1

    }

}