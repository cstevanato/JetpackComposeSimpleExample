package com.example.jetpackcompleexample.crud.data.repository

import com.example.jetpackcompleexample.crud.data.database.AppDb
import com.example.jetpackcompleexample.crud.data.entities.City
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class CityRepository @Inject constructor(appDb: AppDb) {

    private val dao = appDb.cityDao()

    val getAll: Flow<List<City>> = dao.getAll()

    suspend fun addCity(city: City) {
        dao.insert(city)
    }

    suspend fun updateCity(city: City) {
        dao.update(city)
    }

    suspend fun removeCity(city: City) {
        dao.delete(city)
    }

}