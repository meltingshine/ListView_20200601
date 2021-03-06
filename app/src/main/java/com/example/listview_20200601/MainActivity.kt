package com.example.listview_20200601

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listview_20200601.adapters.StudentAdapter
import com.example.listview_20200601.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    val students = ArrayList<Student>()
    lateinit var studentAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        //parent는 당장 안씀,
        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = students.get(position)
            Toast.makeText(mContext,clickedStudent.name,Toast.LENGTH_SHORT).show()

        }

        //position이 뜻하는건 n번째임
        studentListView.setOnItemLongClickListener { parent, view, position, id ->
//
//            val clickedStudent = students[position]
//            Toast.makeText(mContext,"${clickedStudent.name}을 오래 누름",Toast.LENGTH_SHORT).show()
            studentAdapter.notifyDataSetChanged()
            students.removeAt(position)
            return@setOnItemLongClickListener true
            // true -> 롱클릭만 // false -> 클릭도 같이 한...다지만 걍 true임


        }

    }

    override fun setValues() {

        students.add(Student("조경진",1988,true))
        students.add(Student("김미영",2010,false))
        students.add(Student("김성우",1982,true))
        students.add(Student("김형근",1989,true))
        students.add(Student("이용희",1992,true))
        students.add(Student("이지수",1984,false))

        studentAdapter = StudentAdapter(mContext,R.layout.student_list_item,students)
        studentListView.adapter = studentAdapter


    }
}
