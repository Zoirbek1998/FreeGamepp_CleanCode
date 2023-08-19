package uz.telecom.freegamepp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.telecom.freegamepp.data.remote.FreeGameApi
import uz.telecom.freegamepp.data.repository.FreeGameRepositoryImpl
import uz.telecom.freegamepp.domain.repository.FreeGameRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFreeGameRepository(freeGameApi: FreeGameApi):FreeGameRepository{
        return  FreeGameRepositoryImpl(freeGameApi)
    }
}