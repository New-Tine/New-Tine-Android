package com.example.newtine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.newtine.databinding.ActivityAchievementBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class AchievementActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAchievementBinding.inflate(layoutInflater)
    }

    //날짜
    val currentDate=LocalDate.now()
    val formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val dateString=currentDate.format(formatter)

//    val day=currentDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
//    val weekdays= arrayOf("월요일","화요일","수요일","목요일","금요일","토요일","일요일")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //grid adapter
        val gv=binding.gridviewDaysAndDates

        val weekMap=getThisWeekMap()
        val gv_adapter=gv_adapter_achievement_dates(this,weekMap)
        gv.adapter=gv_adapter

        //today-date
        binding.todayDate.text="<"+dateString+">"

        //mission gridview adapter
        val goals_list= arrayOf("하루에 기사 갯수 정하기","하루 뉴틴에 머무는 시간 정하기"
            ,"하루 기사에 의견 남기기 갯수 정하기","하루 실시간 라이브 토론 참여하기"
        )
        val gv2=binding.gridviewMission
        val gv_adapter_goals=gridAdapter_habbitMaking_setting_goals(this,goals_list)
        gv2.adapter=gv_adapter_goals


    }

    fun getThisWeekMap():MutableMap<String,String>{
        val currentDate=LocalDate.now()
        val formatter=DateTimeFormatter.ofPattern("dd")

        val monday=currentDate.with(DayOfWeek.MONDAY)
        val weekMap= mutableMapOf<String,String>()

        for (i in 0 until 7){
            val date=monday.plusDays(i.toLong())
            val dateString=date.format(formatter)
            val dayOfWeek=date.dayOfWeek.getDisplayName(TextStyle.FULL,Locale.KOREA)

            weekMap.put(dateString,dayOfWeek.substring(0,1))
        }
        return weekMap
    }


    //내가 했다가 장렬히 전사,,

    fun getIndex(weekdays:Array<String>,day:String):Int{
        var index=0
        for(i in 0..weekdays.size-1){
            if(weekdays[i].equals(day)) index=i
        }
        return index
    }

    fun getWeekMap(weekdays:Array<String>,date:String,day:String):MutableMap<String,String>{
        var index=getIndex(weekdays,day)
        //val weekMap= mutableMapOf(date to weekdays[index])
        val weekMap:MutableMap<String,String> = mutableMapOf()


        var date=date.toInt()
        //오늘 date 보다 앞쪽
        date-=index
        for(i in 0 until index){
            weekMap.put(date.toString(),weekdays[i].substring(0,1))
            date+=1
        }

        //오늘 date
        date+=index
        weekMap.put(date.toString(),day.substring(0,1))

        //오늘 date보다 뒤쪽
        for(i in index+1 until weekdays.size){
            date+=1
            weekMap.put(date.toString(),weekdays[i].substring(0,1))
        }

        return weekMap
    }




    }