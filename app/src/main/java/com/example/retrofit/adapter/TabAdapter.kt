package com.example.retrofit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.retrofit.fragments.NowPlayingFragment
import com.example.retrofit.fragments.UpcomingFragment

class TabAdapter(fm: FragmentManager?): FragmentStatePagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
       if (position == 0){
           return NowPlayingFragment()
       }else{
           return UpcomingFragment()
       }
    }

    override fun getCount(): Int {
        return 2
    }

}