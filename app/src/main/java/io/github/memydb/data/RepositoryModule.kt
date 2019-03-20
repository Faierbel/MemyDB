package io.github.memydb.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class RepositoryModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://memesapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}