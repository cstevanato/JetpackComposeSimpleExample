package com.example.jetpackcompleexample.crud.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcompleexample.crud.data.dao.CityDao
import com.example.jetpackcompleexample.crud.data.entities.City

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {
    abstract fun cityDao(): CityDao
}