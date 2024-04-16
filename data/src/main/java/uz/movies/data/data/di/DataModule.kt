package uz.movies.data.data.di


import android.content.Context
import android.util.Log.VERBOSE
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.movies.data.data.api.TheMovieApi
import uz.movies.data.data.repository.MovieRepositoryImpl
import uz.movies.domain.domain.common.Constants.BASE_URL_MOVIE
import uz.movies.domain.domain.repository.MovieRepository
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideLoggingIntercerpter() = LoggingInterceptor.Builder()
        .setLevel(Level.BASIC)
        .log(VERBOSE)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: LoggingInterceptor) = OkHttpClient.Builder().apply {
        this.addInterceptor(loggingInterceptor)
            // time out setting
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)

    }.build()

    @Provides
    @Singleton
    fun providePaprikaApi(okHttpClient: OkHttpClient): TheMovieApi {
        return Retrofit.Builder().baseUrl(BASE_URL_MOVIE)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create() )).build()
            .create(TheMovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: TheMovieApi): MovieRepository {
        return MovieRepositoryImpl(api);
    }
}