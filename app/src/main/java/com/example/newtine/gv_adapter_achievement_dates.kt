package com.example.newtine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.jsoup.Connection.Base
import org.w3c.dom.Text

class gv_adapter_achievement_dates(private val context:Context,private val weekMap:MutableMap<String,String>):BaseAdapter() {
    private val dates=weekMap.keys.toTypedArray()
    private val days=weekMap.values.toTypedArray()

    override fun getCount(): Int {
        return days.size
    }

    override fun getItem(position: Int): Any {
        return days[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view=convertView

        if(view==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view=inflater.inflate(R.layout.gv_achievement_dates,null)
        }

        val dayText=view!!.findViewById<TextView>(R.id.achievement_day)
        dayText.text=days[position]
        val dateText=view!!.findViewById<TextView>(R.id.achievement_date)
        dateText.text=dates[position]

        return view
    }

}