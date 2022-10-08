package com.example.projectkotlin1.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projectkotlin1.ui.fragments.onboard.main.MainOnBoardFragment

class OnBoardAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = MainOnBoardFragment().apply {
        arguments = Bundle().apply {
         putInt(MainOnBoardFragment.ARG_ONBOARD_PAGE_POSITION,position)
        }
    }
}