package com.example.projectkotlin1.ui.fragments.noteapp.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectkotlin1.App
import com.example.projectkotlin1.R
import com.example.projectkotlin1.databinding.FragmentDetailBinding
import com.example.projectkotlin1.extensions.setBackStackData
import com.example.projectkotlin1.model.NoteModel
import java.text.SimpleDateFormat
import java.util.*


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        goToModel()
        goToMainFRagments()
    }

    private fun setupListener() {
        binding.textConfirmNote.setOnClickListener {
            val title = binding.detailEt.text.toString()
            val description = binding.directions.text.toString()
            val date = getData()
            val time = getTime()

            App.getDataIntense()?.getNoteDao()?.insert(
                NoteModel(title,description,date,time)
            )
            findNavController().navigate(
                 R.id.action_detailFragment_to_noteAppFragment
            )

            val newNote:NoteModel = NoteModel(title,description,"12.03.22","12:00")
            setBackStackData("newNote",newNote,true)
        }
    }

    private fun goToModel() {
     binding.back.setOnClickListener{
         findNavController().navigate(
             R.id.action_detailFragment_to_noteAppFragment

         )
     }
    }

    private fun goToMainFRagments() {
        binding.data.text = getData()
        binding.time.text = getTime()
    }

   @SuppressLint("SimpleDateFormat")
    private  fun getData(): String{
        val dataFormat = SimpleDateFormat("d MMMM")
        val data = dataFormat.format(Calendar.getInstance().time)
        return data
    }

    @SuppressLint("SimpleDataFormat")
    private fun getTime(): String{
    val timeFormat= SimpleDateFormat("HH:mm")
    val time = timeFormat.format(Calendar.getInstance().time)
    return time
    }

}



