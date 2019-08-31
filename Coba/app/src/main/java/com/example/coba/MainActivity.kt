package com.example.coba

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.coba.HOME.fragmentlogin
import com.example.coba.HOME.fragmentprofil
import com.example.coba.HOME.homefragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : FragmentActivity() {

    private lateinit var mPager: ViewPager2
    val NUM_PAGES = 3
    val name_tab = arrayOf("Home", "login", "Profil")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val tabLayoutMediator = TabLayoutMediator(tab, viewPager, true,
            TabLayoutMediator.OnConfigureTabCallback { tab, position ->

            })
        tabLayoutMediator.attach();

        for (i in 0..2) {
            tab.getTabAt(i)!!.setText(name_tab.get(i));
        }
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = mPager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return fragmentlogin()
            } else if (position == 1) {
                return fragmentprofil()
            } else {
                return homefragment()
            }
        }

        override fun getItemCount(): Int = NUM_PAGES
    }

}