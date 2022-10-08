package com.example.projectkotlin1.ui.fragments.noteapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectkotlin1.App
import com.example.projectkotlin1.R
import com.example.projectkotlin1.ui.adapter.NoteAppAdapter
import com.example.projectkotlin1.databinding.FragmentNoteAppBinding
import com.example.projectkotlin1.extensions.getBackStackData
import com.example.projectkotlin1.model.NoteModel
import com.example.projectkotlin1.ui.adapter.NoteAppAdapter.OnNoteClickListener

class NoteAppFragment : Fragment(),OnNoteClickListener {

     private lateinit var binding: FragmentNoteAppBinding

     private val list: ArrayList<NoteModel> = ArrayList()

     private val adapter = NoteAppAdapter(list,this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecycler()
        getData()
        setupListener()

    }

    private fun initializeRecycler() {
        binding.noteRecView.layoutManager = LinearLayoutManager(requireContext())
        binding.noteRecView.adapter = adapter
    }

    private fun setupListener() {
     binding.buttonAdd.setOnClickListener{
     findNavController().navigate(
         R.id.action_noteAppFragment_to_detailFragment)
        }
    }

    private fun getData() {
        App.getDataIntense()?.getNoteDao()?.getALLModels()?.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

    override fun onClick(model: NoteModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle("Удалить заметку")
            .setMessage("Вы подтверждаете удалить заметку?")
            .setPositiveButton("да", DialogInterface.OnClickListener(){dialogInterface, i ->dialogInterface
           App.getDataIntense()?.getNoteDao()?.delete(model)
            })
            .setNegativeButton("нет", DialogInterface.OnClickListener{dialogInterface, i ->dialogInterface

            }).create().show()
    }
}