package io.github.memydb.data

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.github.memydb.data.api.ContentTypeAdapter
import io.github.memydb.data.api.LiveDataCallAdapterFactory
import io.github.memydb.data.api.services.DemotywatoryService
import io.github.memydb.data.pojos.contents.Content
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class RepositoryModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(Content::class.java, ContentTypeAdapter())
            .create()

        return Retrofit.Builder()
            .baseUrl("https://memesapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideDemotywatoryService(retrofit: Retrofit): DemotywatoryService {
        return retrofit.create(DemotywatoryService::class.java)
    }
}