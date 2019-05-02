package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.MistrzowieService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MistrzowieRepository @Inject constructor(private val mistrzowieService: MistrzowieService) {

    fun getMistrzowiePage(id: Int) = mistrzowieService.getPage(id)
}
