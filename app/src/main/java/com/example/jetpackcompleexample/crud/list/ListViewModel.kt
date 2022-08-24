package com.example.jetpackcompleexample.crud.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpackcompleexample.crud.data.dao.CityDao
import com.example.jetpackcompleexample.crud.data.entities.City
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val dao: CityDao) : ViewModel() {
    val cities: LiveData<List<City>> = dao.getAll().asLiveData()
}