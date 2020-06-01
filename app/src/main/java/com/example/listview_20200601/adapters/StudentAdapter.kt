package com.example.listview_20200601.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview_20200601.R
import com.example.listview_20200601.datas.Student

class StudentAdapter(context: Context, resId: Int, list : List<Student>) : ArrayAdapter<Student>(context,resId,list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
            //inflate는 xml을 실제로 그려서 객체로 만드는 것
        }
        val row = tempRow!! // !! -> null이 절대 아니다 란 뜻.

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        val data = mList.get(position)
        nameAndAgeTxt.text =data.name


        //이름과 나이를 실제로 출력
        // 조경진, 1988년 -> 조경진(33세)
        // 나이 구하기 2020-출생연도+1

        if (data.isMale) {
            genderTxt.text ="남성"
        }
        else {
            genderTxt.text = "여성"
        }


        return row

    }

}