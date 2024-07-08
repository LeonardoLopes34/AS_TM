package com.example.`as`

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.`as`.commons.utils.Resultado
import com.example.`as`.databinding.ActivityMainBinding
import com.example.`as`.ui.adapters.CharacterAdapter
import com.example.`as`.ui.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val charactersViewModel: CharactersViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configureRecycler()
        observer()

    }
    private fun configureRecycler() {
        adapter = CharacterAdapter()
        binding.recyclerViewCharacters.adapter = adapter
    }

    private fun observer() {
        charactersViewModel.fetchCharacters().observe(this) { result ->
            when(result) {
                is Resultado.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resultado.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setUpCharacters(result.data)
                }
                is Resultado.Error -> {
                    binding.progressBar.visibility = View.GONE

                }
            }
        }
    }
}