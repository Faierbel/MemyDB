package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.CodingloveService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CodingloveRepository @Inject constructor(private val codingloveService: CodingloveService) {

    fun getCodingLovePage(id: Int) = codingloveService.getPage(id)
}
