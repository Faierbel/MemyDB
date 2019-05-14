package io.github.memydb.data

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.github.memydb.data.api.ContentTypeAdapter
import io.github.memydb.data.api.LiveDataCallAdapterFactory
import io.github.memydb.data.api.services.*
import io.github.memydb.data.pojos.contents.Content
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
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

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(BASIC))
            .build()

        return Retrofit.Builder()
            .baseUrl("https://memesapi.herokuapp.com/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideDemotywatoryService(retrofit: Retrofit): DemotywatoryService {
        return retrofit.create(DemotywatoryService::class.java)
    }

    @Singleton
    @Provides
    fun provideKwejkService(retrofit: Retrofit): KwejkService {
        return retrofit.create(KwejkService::class.java)
    }

    @Singleton
    @Provides
    fun provideJbzdService(retrofit: Retrofit): JbzdService {
        return retrofit.create(JbzdService::class.java)
    }

    @Singleton
    @Provides
    fun provideNinegagService(retrofit: Retrofit): NinegagService {
        return retrofit.create(NinegagService::class.java)
    }

    @Singleton
    @Provides
    fun provideNinegagnsfw(retrofit: Retrofit): NinegagnsfwService {
        return retrofit.create(NinegagnsfwService::class.java)
    }

    @Singleton
    @Provides
    fun provideMistrzowieService(retrofit: Retrofit): MistrzowieService {
        return retrofit.create(MistrzowieService::class.java)
    }

    @Singleton
    @Provides
    fun provideAnonimoweService(retrofit: Retrofit): AnonimoweService {
        return retrofit.create(AnonimoweService::class.java)
    }

    @Singleton
    @Provides
    fun provideCodingLoveService(retrofit: Retrofit): CodingloveService {
        return retrofit.create(CodingloveService::class.java)
    }
}
