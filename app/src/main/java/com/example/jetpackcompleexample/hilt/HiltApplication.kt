package com.example.jetpackcompleexample.hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.jetpackcompleexample.crud.data.database.AppDb
import com.example.jetpackcompleexample.retrofit.api.DigimonApi
import com.example.jetpackcompleexample.retrofit.api.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDigimonRepository(api: DigimonApi) = DigimonRepository(api)

    @Singleton
    @Provides
    fun provideDigimonApi(): DigimonApi {
       return Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl("https://digimon-api.vercel.app/api/")
           .build().create(DigimonApi::class.java)
    }

}