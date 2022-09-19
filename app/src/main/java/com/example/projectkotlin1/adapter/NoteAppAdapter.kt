package com.example.projectkotlin1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.projectkotlin1.databinding.ItemNoteBinding

class NoteAppAdapter: RecyclerView.Adapter<NoteAppAdapter.ViewHolder>() {

    private var list: ArrayList<String> = ArrayList()

    fun setList(list: ArrayList<String> ) {
        this.list= list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(s: String) {
         binding.itemNoteTxt.text = s
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(
                parent.context
            ),parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}