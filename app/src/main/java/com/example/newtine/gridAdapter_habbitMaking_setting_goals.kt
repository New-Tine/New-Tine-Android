package com.example.new_tine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class gridAdapter_habbitMaking_setting_goals(private val context: Context, private val data:Array<String>):BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view=convertView

        if (view == null) {
            // GridView의 항목 레이아웃을 inflate하여 새로운 View로 생성합니다.
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.gv_habbit_making_setting_goals, null)
        }

        val textView=view!!.findViewById<TextView>(R.id.goal)
        textView.text=data[position]

        return view
    }

}