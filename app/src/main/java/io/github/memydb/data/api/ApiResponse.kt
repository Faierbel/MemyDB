package io.github.memydb.data.api

import retrofit2.Response
import java.io.IOException

sealed class ApiResponse<T> {

    companion object {

        fun <T> create(error: Throwable) = ErrorApiResponse<T>(error)

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                response.body().let {
                    if (it == null || response.code() == 204) EmptyApiResponse<T>()
                    else SuccessApiResponse(it)
                }
            } else {
                val message = response.errorBody()?.string().let {
                    if (it.isNullOrBlank()) response.message()
                    else it
                }
                ErrorApiResponse(IOException(message))
            }
        }
    }

    class EmptyApiResponse<T> : ApiResponse<T>()

    data class SuccessApiResponse<T>(val value: T) : ApiResponse<T>()

    data class ErrorApiResponse<T>(val error: Throwable) : ApiResponse<T>()
}
