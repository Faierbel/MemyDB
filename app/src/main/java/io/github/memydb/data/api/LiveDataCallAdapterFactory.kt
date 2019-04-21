package io.github.memydb.data.api

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java) return null

        return getParameterUpperBound(0, returnType as ParameterizedType).let {
            if (getRawType(it) != ApiResponse::class.java) throw IllegalArgumentException("Type must be a ApiResponse")
            if (it !is ParameterizedType) throw IllegalArgumentException("ApiResponse must be parameterized")
            LiveDataCallAdapter<Any>(getParameterUpperBound(0, it))
        }
    }
}
