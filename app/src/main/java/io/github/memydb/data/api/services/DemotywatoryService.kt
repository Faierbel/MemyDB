package io.github.memydb.data.api.services

import androidx.lifecycle.LiveData
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Page
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface DemotywatoryService {

    @GET("/demotywatory")
    fun getPage(): LiveData<ApiResponse<Page>>
}
