package com.example.newtine

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtine.databinding.FragmentHomeSearch2Binding
import java.time.LocalDate

class home_search2 : Fragment() {

    private var _binding:FragmentHomeSearch2Binding?=null
    private val binding get()= _binding!!
    val historyList=ArrayList<article>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for(i in 1..5){
            historyList.add(article("뉴스 제목 $i","언론사 $i", LocalDate.of(2023,7,21) ))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSearch2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSearchHistory.adapter=rv_adapter_search_histroy(historyList)
        binding.rvSearchHistory.layoutManager=LinearLayoutManager(requireContext())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null

    }

}