package com.example.new_tine

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newtine.AchievementActivity
import com.example.newtine.R
import com.example.newtine.databinding.FragmentNewTechBinding

class NewTechFragment : Fragment() {
    private lateinit var binding:FragmentNewTechBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNewTechBinding.inflate(layoutInflater,container,false)

        binding.btnHabbitState.setOnClickListener {
            val intent = Intent(requireContext(), AchievementActivity::class.java)
            startActivity(intent)

        }

        return binding.root
    }

    companion object {

    }
}