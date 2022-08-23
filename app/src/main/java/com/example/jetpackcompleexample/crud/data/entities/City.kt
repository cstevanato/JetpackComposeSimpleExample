package com.example.jetpackcompleexample.crud.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Cities")
@Parcelize
data class City(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var cep: String? = null,
    var uf: String? = null
) : Parcelable
