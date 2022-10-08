package com.example.projectkotlin1.ui.fragments.onboard.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin1.R
import com.example.projectkotlin1.data.locale.PreferenceHelper
import com.example.projectkotlin1.databinding.FragmentMainOnBoardBinding
import com.example.projectkotlin1.ui.fragments.onboard.OnBoardFragmentDirections


class MainOnBoardFragment : Fragment() {

    private lateinit var binding: FragmentMainOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inshalize()
        visibilityTextStartWork()
    }

    private fun inshalize() {
        when(requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)) {
            0 -> {
                binding.pagerCodImage.setAnimation("anim.technology.phone.json")
                binding.pagerText.text = "Очень удобный функционал"
            }
            1 -> {
                binding.pagerCodImage.setAnimation("anim.technology.json")
                binding.pagerText.text = "Быстрый, качественный продукт"
            }
            2 -> {
                binding.pagerCodImage.setAnimation("android.anim.json")
                binding.pagerText.text = "Куча функций и интересных фишек"
                binding.pagerText1.text = "Начать работу"
            }
        }
    }
    @SuppressLint("ResourceType")
    private fun visibilityTextStartWork() {
        val statusFragment = requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)

        if(statusFragment == 2) {
            binding.textBack.visibility = View.GONE
            binding.pagerText1.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                   goNavGrahpFragment()
                }
            }
        }else{
            binding.textBack.visibility = View.VISIBLE
            binding.pagerText1.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                   goNavGrahpFragment()
                }
            }
        }
    }

    private fun goNavGrahpFragment() {
        findNavController().navigate(
            OnBoardFragmentDirections.actionOnBoardFragment2ToNoteAppFragment()
        )
    }

    companion object {
        const val ARG_ONBOARD_PAGE_POSITION = "onboarding_page_position"
    }

}