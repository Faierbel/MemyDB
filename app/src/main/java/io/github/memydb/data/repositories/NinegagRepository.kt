package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.NinegagService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NinegagRepository @Inject constructor(private val ninegagService: NinegagService) {

    fun getNinegagPage() = ninegagService.getPage()

    fun getNinegagPage(id: String) = ninegagService.getPage(id)
}
