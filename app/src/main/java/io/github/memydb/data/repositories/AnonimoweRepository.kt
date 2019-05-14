package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.AnonimoweService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnonimoweRepository @Inject constructor(private val anonimoweService: AnonimoweService) {

    fun getAnonimowePage(id: Int) = anonimoweService.getPage(id)
}
