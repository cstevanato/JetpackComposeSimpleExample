package com.example.jetpackcompleexample.crud.hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.jetpackcompleexample.crud.data.database.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class HiltApplication : Application()

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, "BdRoomCrud")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun cityRepository(db: AppDb) = db.cityDao()


}