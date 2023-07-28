package com.example.newtine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.example.newtine.databinding.ActivityHabbitMakingBinding

class Habbit_MakingActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHabbitMakingBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //grid adapter
        val weekdays= arrayOf("월","화","수","목","금","토","일")
        val gv=binding.gridviewDays
        val gv_adapter_days=gridAdapter_habbitMaking_days(this,weekdays)
        gv.adapter=gv_adapter_days
        
        //time picker (알림 시간 설정)
        val tp:TimePicker=binding.timePicker
        tp.setOnTimeChangedListener { view, hourOfDay, minute ->
            //db에 시간 저장하는 코드 추가
        }

        //초기화
        tp.hour=10
        tp.minute=0

        //루틴 목표 세우기
        val goals_list= arrayOf("하루에 기사 갯수 정하기","하루 뉴틴에 머무는 시간 정하기"
        ,"하루 기사에 의견 남기기 갯수 정하기","하루 실시간 라이브 토론 참여하기"
        )
        val gv2=binding.gridviewGoals
        val gv_adapter_goals=gridAdapter_habbitMaking_setting_goals(this,goals_list)
        gv2.adapter=gv_adapter_goals



    }
}