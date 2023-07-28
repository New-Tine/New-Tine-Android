package com.example.newtine

import MainNews_Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.new_tine.NewTechFragment
import com.example.newtine.R
import com.example.newtine.databinding.MainActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHabbitMaking.setOnClickListener {
            val intent=Intent(this, Habbit_MakingActivity::class.java)
            startActivity(intent)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, MainNews_Fragment())
            .commitAllowingStateLoss()

        Toast.makeText(this,"why",Toast.LENGTH_SHORT).show()


        binding.bottomNav.run {
            setOnItemReselectedListener {
                when(it.itemId){
                    R.id.menu_home->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainer.id,MainNews_Fragment())
                            .commitAllowingStateLoss()

                        Toast.makeText(context,"home fragment",Toast.LENGTH_SHORT).show()

                    }

                    R.id.menu_new_tech->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainer.id, NewTechFragment())
                            .commitAllowingStateLoss()
                        Toast.makeText(context,"new tech fragment",Toast.LENGTH_SHORT).show()
                    }

                    R.id.menu_scrap->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.fragmentContainer.id,HomeFragment())
                            .commitAllowingStateLoss()
                        Toast.makeText(context,"new scrap fragment",Toast.LENGTH_SHORT).show()

                    }


                }
                true
            }
            selectedItemId=R.id.menu_home

        }
    }





    //tab layout, viewpager2
//        val adapter=viewPager_adapter(this)
//        binding.viewPager.adapter=adapter
//
//        val tabtitleArray= arrayOf(
//            "HOME","NEW-TECH",
//        )
//        TabLayoutMediator(binding.bottomNav,binding.viewPager){
//            tab,position->tab.text=tabtitleArray[position]
//        }.attach()


}
