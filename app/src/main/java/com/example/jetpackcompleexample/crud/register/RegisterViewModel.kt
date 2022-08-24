package com.example.jetpackcompleexample.crud.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompleexample.crud.data.entities.City
import com.example.jetpackcompleexample.crud.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val dao: CityRepository) : ViewModel() {

    val nameState = mutableStateOf("")
    fun onChangeName(value: String) {
        nameState.value = value
    }

    val cepState = mutableStateOf("")
    fun onChangeCep(value: String) {
        cepState.value = value
    }

    val ufState = mutableStateOf("")
    fun onChangeUf(value: String) {
        ufState.value = value
    }

    val status: MutableLiveData<Boolean> = MutableLiveData()

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.addCity(
                    City(
                        name = nameState.value,
                        cep = cepState.value,
                        uf = ufState.value
                    )
                )
                status.postValue(true)
            }
        }
    }

}