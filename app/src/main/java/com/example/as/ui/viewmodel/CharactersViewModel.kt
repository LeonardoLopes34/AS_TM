package com.example.`as`.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.`as`.commons.utils.Resultado
import com.example.`as`.data.models.Character
import com.example.`as`.data.repositories.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersRepository: CharactersRepository) :
    ViewModel() {
    fun fetchCharacters(): LiveData<Resultado<List<Character>>> {
        val liveData = MutableLiveData<Resultado<List<Character>>>()

        liveData.postValue(Resultado.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = charactersRepository.fetchCharacters()
                liveData.postValue(Resultado.Sucess(result))
            }catch (e: Exception) {
                liveData.postValue(Resultado.Error(e))
            }

        }
        return liveData
    }

}