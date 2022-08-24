package com.example.jetpackcompleexample.crud.update

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
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
class DetailsViewModel @Inject constructor(private val dao: CityRepository) : ViewModel() {

    var id by mutableStateOf(0)

    private var nameCityLv = MutableLiveData<String>()
    val nameCity: LiveData<String> = nameCityLv

    private var cepCityLv = MutableLiveData<String>()
    val cepCity: LiveData<String> = cepCityLv

    private var ufCityLv = MutableLiveData<String>()
    val ufCity: LiveData<String> = ufCityLv

    val status: MutableLiveData<Boolean> = MutableLiveData()

    fun onChangeCity(value: String) {
        nameCityLv.value = value
    }

    fun onChangeCep(value: String) {
        cepCityLv.value = value
    }

    fun onChangeUf(value: String) {
        ufCityLv.value = value
    }


    fun update() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.updateCity(
                    City(
                        id = id,
                        name = nameCity.value,
                        uf = ufCity.value,
                        cep = cepCity.value
                    )
                )
                status.postValue(true)
            }
        }
    }

    fun remove() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.removeCity(
                    City(
                        id = id,
                        name = nameCity.value,
                        uf = ufCity.value,
                        cep = cepCity.value
                    )
                )
                status.postValue(true)
            }
        }
    }

}