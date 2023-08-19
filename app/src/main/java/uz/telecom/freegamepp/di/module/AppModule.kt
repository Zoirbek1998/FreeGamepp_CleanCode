package uz.telecom.freegamepp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.telecom.freegamepp.core.utils.Constants.BASE_URL
import uz.telecom.freegamepp.data.remote.FreeGameApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideFreeGameApi(retrofit: Retrofit): FreeGameApi =
        retrofit.create(FreeGameApi::class.java)
}