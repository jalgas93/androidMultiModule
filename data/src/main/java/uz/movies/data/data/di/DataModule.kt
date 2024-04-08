package uz.movies.data.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.movies.data.data.api.CoinPaprikaApi
import uz.movies.data.data.repository.CoinRepositoryImpl
import uz.movies.domain.domain.common.Constants.BASE_URL
import uz.movies.domain.domain.repository.CoinRepository
import uz.movies.domain.domain.use_case.GetCoinsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api);
    }
/*
    @Provides
    @Singleton
    fun provideCoinsUseCase(coinRepository:CoinRepository):GetCoinsUseCase{
        return GetCoinsUseCase(repository = coinRepository);
    }*/
}