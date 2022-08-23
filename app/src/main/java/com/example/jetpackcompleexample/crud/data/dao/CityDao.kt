package com.example.jetpackcompleexample.crud.data.dao

import androidx.room.*
import com.example.jetpackcompleexample.crud.data.entities.City
import kotlinx.coroutines.flow.Flow


@Dao
interface CityDao {
    @Insert
    suspend fun insert(city: City)

    @Update
    suspend fun update(city: City)

    @Delete
    suspend fun delete(city: City)

    @Query("Select * From Cities")
    fun getAll(): Flow<List<City>>
}