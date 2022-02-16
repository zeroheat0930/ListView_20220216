package com.zeroheat.listview_20220216

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zeroheat.listview_20220216.adapters.StudentAdapter
import com.zeroheat.listview_20220216.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //studentAdapter.kt에서 생성한 class를 가져옴
    //그뒤에 var변수로 madapter 생성
    lateinit var mAdapter : StudentAdapter

    //데이터 목록을 담을 그릇 : ArrayList를 멤버변수 mStudentList로 만들어두자.
    val mStudentList = ArrayList<StudentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //arraylist = mstudentlist -> .add(studentData.kt의 .string .int .string 값을 arraylist에 넣어줌)
        mStudentList.add(StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("고재천", 1988, "서울시 중랑구"))
        mStudentList.add(StudentData("방우진", 1983, "경기도 고양시"))
        mStudentList.add(StudentData("서정민", 1984, "경기도 광명시"))
        mStudentList.add(StudentData("이승민", 1994, "경기도 안양시"))
        mStudentList.add(StudentData("이영종", 1991, "경기도 고양시"))
        mStudentList.add(StudentData("이윤주", 1989, "서울시 강서구"))
        mStudentList.add(StudentData("이진실", 1994, "서울시 송파구"))
        mStudentList.add(StudentData("정동준", 1992, "경기도 남양주시"))
        mStudentList.add(StudentData("최재훈", 1994, "경기도 수원시"))
        mStudentList.add(StudentData("이성노", 1988, "경기도 남양주시"))


        //어댑터변수 = 어댑터클래스( 필요한재료들 ) 로 객체화 진행.
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        //화면에 배치된 리스트뷰의 어댑터로 = 우리가 만든 어댑터 변수를 대입.
        studentListView.adapter = mAdapter

        //----------------------------------------------------------------

        studentListView.setOnItemClickListener { adapterView, view, position, l ->


            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name}학생 클릭됨", Toast.LENGTH_SHORT).show()
        }


        //------------------------------------------------------------------

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val longClickedStudent = mStudentList[position]
            
           val alert = AlertDialog.Builder(this)
                .setTitle("학생 삭제")
                .setMessage("정말 ${longClickedStudent.name} 학생을 삭제하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

                    mStudentList.remove(longClickedStudent)

                    mAdapter.notifyDataSetChanged()

                }
                )



                .setNegativeButton("취소", null)
                .show()



            return@setOnItemLongClickListener true




        }

        //-----------------------------------------------------
    }
}