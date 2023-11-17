package com.example.grahaksewa.di

import android.app.Application
import androidx.room.Room
import com.example.grahaksewa.domain.data.GrahakDatabase
import com.example.grahaksewa.domain.repository.GrahakRepository
import com.example.grahaksewa.domain.repository.GrahakRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGrahakDatabase(app: Application): GrahakDatabase {
        return Room.databaseBuilder(
            app,
            GrahakDatabase::class.java,
            "grahak_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideGrahakRepository(db: GrahakDatabase) : GrahakRepository{
        return GrahakRepositoryImpl(db.dao)
    }

}