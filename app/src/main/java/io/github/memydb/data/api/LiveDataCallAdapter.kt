package io.github.memydb.data.api

import io.github.memydb.utils.RefreshLiveData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class LiveDataCallAdapter<R>(private val type: Type) : CallAdapter<R, RefreshLiveData<ApiResponse<R>>> {

    override fun responseType() = type

    override fun adapt(call: Call<R>): RefreshLiveData<ApiResponse<R>> {
        return RefreshLiveData { callback ->
            try {
                call.clone().enqueue(object : Callback<R> {
                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        callback(ApiResponse.create(response))
                    }

                    override fun onFailure(call: Call<R>, t: Throwable) {
                        callback(ApiResponse.create(t))
                    }
                })
            } catch (t: Throwable) {
                callback(ApiResponse.create(t))
            }
        }
    }
}
