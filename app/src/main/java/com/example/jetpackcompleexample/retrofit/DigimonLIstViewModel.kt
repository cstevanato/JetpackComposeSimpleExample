package com.example.jetpackcompleexample.retrofit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompleexample.retrofit.api.DigimonRepository
import com.example.jetpackcompleexample.retrofit.response.Digimon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigimonLIstViewModel @Inject constructor(
    private val repository: DigimonRepository
) : ViewModel() {
    var digimonList = mutableStateOf<List<Digimon>>(listOf())

    init {
        loadDigimons()
    }

    fun loadDigimons() {
        viewModelScope.launch(Dispatchers.IO) {
            digimonList.value = repository.getDigimon()
        }
    }
}