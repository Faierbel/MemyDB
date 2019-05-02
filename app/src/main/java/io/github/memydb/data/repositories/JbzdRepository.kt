package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.JbzdService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JbzdRepository @Inject constructor(private val jbzdService: JbzdService) {

    fun getJbzdPage(id: Int) = jbzdService.getPage(id)
}
