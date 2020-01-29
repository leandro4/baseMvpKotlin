package base.project.api

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    var api: Api

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(UtilUrl.BASE_URL)
                .client(createOkHttpClientInterceptor())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        api = retrofit.create(Api::class.java)
    }

    private fun createOkHttpClientInterceptor(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(interceptor)
        return okHttpClient.build()
    }

    fun exampleService(): Observable<Void> {
        return api.exampleService()
    }
}