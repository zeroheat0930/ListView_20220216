package com.zeroheat.listview_20220216.datas

class StudentData (val name: String, val birthYear: Int, val address: String) {

    fun getKoreaAge(year : Int) : Int{
        var koreanAge = year - this.birthYear +1
        return koreanAge
    }

}