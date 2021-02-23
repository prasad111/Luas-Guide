package employee.luas.network


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

import employee.luas.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideLuasApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()
}

fun provideLuasApi(retrofit: Retrofit): LuasApi = retrofit.create(LuasApi::class.java)