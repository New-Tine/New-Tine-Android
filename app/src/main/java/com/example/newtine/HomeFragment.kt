package com.example.new_tine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.new_tine.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        binding.searchBtn.setOnClickListener {
            navigateToHomeSearch2()
        }
        return binding.root
    }

    private fun navigateToHomeSearch2(){
        val homeSearch2Fragment=home_search2()

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeSearch2Fragment)
            .addToBackStack(null)
            .commit()
    }

}