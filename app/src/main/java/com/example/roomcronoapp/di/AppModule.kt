package com.example.roomcronoapp.di

import android.content.Context
import androidx.room.Room
import com.example.roomcronoapp.room.CronosDatabase
import com.example.roomcronoapp.room.CronosDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// se genera e instancia una sola vez y se envia a las distitas clases donde lo necesitemos
@Module
@InstallIn(SingletonComponent::class) //esto porque la inyeccion de dep utiliza el patron singleton
object AppModule {

    @Singleton
    @Provides
    fun providesCronosDao(cronoDatabase: CronosDatabase): CronosDatabaseDao {
        return cronoDatabase.cronosDao()
    }

    @Singleton
    @Provides
    fun providesCronosDatabase(@ApplicationContext context: Context): CronosDatabase {
        return Room.databaseBuilder(
            context,
            CronosDatabase::class.java,
            "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}