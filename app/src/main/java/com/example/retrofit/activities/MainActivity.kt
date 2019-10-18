package com.example.retrofit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.R
import com.example.retrofit.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        tab_home.addTab(tab_home.newTab().setText("Now Playing"))
        tab_home.addTab(tab_home.newTab().setText("UpComing"))

        var adapter = TabAdapter(supportFragmentManager)

        vp_tabs.adapter = adapter

        vp_tabs.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_home))

        tab_home.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                vp_tabs.currentItem = tab?.position!!
            }

        })

    }
}
