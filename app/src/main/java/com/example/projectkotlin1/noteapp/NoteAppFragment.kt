package com.example.projectkotlin1.noteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectkotlin1.R
import com.example.projectkotlin1.adapter.NoteAppAdapter
import com.example.projectkotlin1.databinding.FragmentNoteAppBinding


class NoteAppFragment : Fragment() {
private lateinit var binding: FragmentNoteAppBinding
private val noteAppAdapter = NoteAppAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }


    private fun initialize() {
binding.noteRecView.apply {
    layoutManager = LinearLayoutManager(requireContext())
}
    }

    private fun setupListener() {
binding.noteFloateAction.setOnClickListener{
findNavController().navigate(R.id.action_noteAppFragment_to_detailFragment)
}
    }

}