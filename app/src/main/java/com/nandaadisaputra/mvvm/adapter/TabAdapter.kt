package com.nandaadisaputra.mvvm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nandaadisaputra.mvvm.ui.fragment.MovieFragment

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val pages = listOf(
        MovieFragment(),
        Fragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "MOVIE"
            1 -> "TV"
            else -> "NO DATA"
        }
    }

}
