package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.KwejkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KwejkRepository @Inject constructor(private val kwejkService: KwejkService) {

    fun getKwejkPage(id: Int) = kwejkService.getPage(id)

    fun getKwejkPage() = kwejkService.getPage()
}
