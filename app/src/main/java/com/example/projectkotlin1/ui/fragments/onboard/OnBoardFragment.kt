package com.example.projectkotlin1.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectkotlin1.App
import com.example.projectkotlin1.databinding.FragmentOnBoardBinding
import com.example.projectkotlin1.ui.adapter.OnBoardAdapter

class OnBoardFragment : Fragment() {

    private lateinit var bindindg: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindindg = FragmentOnBoardBinding.inflate(inflater,container,false)
        return bindindg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchingOnBoard()
        onBoardActivity()
    }

    private fun switchingOnBoard() {
        bindindg.viewPager.adapter = OnBoardAdapter(this@OnBoardFragment)
        bindindg.indicator.setViewPager(bindindg.viewPager)
    }

    private fun onBoardActivity() {
        App.preferenceHelper.putValue(true)

    }


}