package com.example.projectkotlin1.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projectkotlin1.R

import com.example.projectkotlin1.databinding.ItemNoteBinding
import com.example.projectkotlin1.model.NoteModel
import com.example.projectkotlin1.ui.fragments.noteapp.detail.DetailFragmentDirections

class NoteAppAdapter(

    private var list: List<NoteModel>,
    private val onNoteClick: OnNoteClickListener
) : RecyclerView.Adapter<NoteAppAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemNoteBinding.bind(item)

        fun onBind(model: NoteModel, listener: OnNoteClickListener) {
            binding.itemCard.setCardBackgroundColor(Color.parseColor(model.color))
            binding.itemNoteTxt.text = model.title
            binding.itemDescription.text = model.description
            binding.itemData.text = model.date
            binding.itemTime.text = model.time

            itemView.setOnLongClickListener {
                listener.onClick(model)
                return@setOnLongClickListener true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], onNoteClick)
    }

    override fun getItemCount(): Int = list.size

    interface OnNoteClickListener {
        fun onClick(model: NoteModel)
    }


}