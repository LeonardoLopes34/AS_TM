package com.example.`as`.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.`as`.data.models.Character
import com.example.`as`.databinding.CharacterItemBinding

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    private lateinit var context: Context
    private lateinit var binding: CharacterItemBinding
    private var listCharacters: List<Character> = emptyList()

    fun setUpCharacters(characters: List<Character>) {
        this.listCharacters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = CharacterItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listCharacters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        binding.executePendingBindings()
    }

    inner class ViewHolder(val bindingHolder: CharacterItemBinding): RecyclerView.ViewHolder(bindingHolder.root) {
        fun bind(character: Character) {
            bindingHolder.character = character
        }
    }

}