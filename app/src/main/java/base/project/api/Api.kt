package base.project.api

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    @GET(UtilUrl.SOME_RESOURCE)
    fun exampleService() : Observable<Void>

}