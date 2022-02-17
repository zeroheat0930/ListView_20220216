package com.zeroheat.listview_20220216.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.zeroheat.listview_20220216.R
import com.zeroheat.listview_20220216.datas.StudentData

class StudentAdapter(
    val mContext: Context, val resId: Int, val mList: ArrayList<StudentData>
    ) : ArrayAdapter<StudentData>(mContext,resId,mList) {

    // 데이터 변수 : getView함수의 재료중, position 활용.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //tempRow라는 var변수를 생성후 convertview값을 넣어줌
        var tempRow = convertView
        //만약 tempRow가 값이 없을때는
        if (tempRow == null) {
        //tempRow에 값을 넣어줌 (xml에서 채워온다)
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.student_list_item, null)

        }

        // 진짜 변수 row 를 만들어서 tempRow값을 넣어준다.
        val row = tempRow!!


        //------------------------------------------------------------------------

        // 1) 데이터 변수 : getView함수의 재료중, position 활용.
        val data = mList[position]


        // 2) 반영할 UI : row 변수의 내부 태그들을 가져오기.
       val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)


        val txtAge = row.findViewById<TextView>(R.id.txtAge)


        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        //--------------------------------------------------------------
        // 3) data변수의 하위정보 / 함수 등을 이용해서, 반영할 UI의 값으로 세팅.
        txtStudentName.text = data.name
        txtAddress.text = data.address

        txtAge.text = "(${data.getKoreaAge(2022)}세)"


        //get view 함수의 값을 로우로 반환함
        return row
    }
}