package com.example.przewodnikturystyczny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var topAppBar: MaterialToolbar
    lateinit var fragmentList: List<Fragment>
    private var currentFragmentIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentList = listOf(
            MainFragment(),
            InformationFragment(),
            KebabFragment(),
            EndFragment()
        )

        topAppBar = findViewById(R.id.topAppBar);

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragmentList[currentFragmentIndex])
                .commit()
        }

        topAppBar.setNavigationOnClickListener {
            currentFragmentIndex = goBack(fragmentList, currentFragmentIndex)
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out )
                .replace(R.id.fragment_container_view, fragmentList[currentFragmentIndex])
                .commit()
        }
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.forward -> {
                    currentFragmentIndex = goForward(fragmentList, currentFragmentIndex)
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.fade_out,
                            R.anim.fade_in,
                            R.anim.slide_out )
                        .replace(R.id.fragment_container_view, fragmentList[currentFragmentIndex])
                        .commit()
                    true
                }
                else ->{
                    false
                }
            }
        }



    }
    fun goBack(list: List<Fragment>, index: Int): Int {
        var value = 0

        if(index == 0){
            value = list.size - 1
        }
        else{
            value = index - 1
        }

        return value
    }

    fun goForward(list: List<Fragment>, index: Int): Int{
        var value = 0

        if(index == list.size - 1){
            value = 0
        }
        else{
            value = index + 1
        }

        return value
    }
}