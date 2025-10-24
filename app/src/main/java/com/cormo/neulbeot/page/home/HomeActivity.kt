package com.cormo.neulbeot.page.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cormo.neulbeot.R
import com.cormo.neulbeot.page.home.tabs.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager2
    private lateinit var bottom: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pager = findViewById(R.id.homePager)
        bottom = findViewById(R.id.homeBottomNav)

        pager.isUserInputEnabled = false // 스와이프 이동 막고 탭으로만 전환
        pager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5
            override fun createFragment(position: Int) = when (position) {
                0 -> HomeFragment()
                1 -> ChallengeFragment()
                2 -> ReportFragment()
                3 -> CommunityFragment()
                else -> ProfileFragment()
            }
        }

        bottom.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tab_home -> pager.setCurrentItem(0, false)
                R.id.tab_challenge -> pager.setCurrentItem(1, false)
                R.id.tab_report -> pager.setCurrentItem(2, false)
                R.id.tab_market -> pager.setCurrentItem(3, false)
                R.id.tab_profile -> pager.setCurrentItem(4, false)
            }
            true
        }
        bottom.selectedItemId = R.id.tab_home
    }
}
