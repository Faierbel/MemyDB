package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.NinegagnsfwService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NinegagnsfwRepsoitory @Inject constructor(private val ninegagnsfwService: NinegagnsfwService) {

    fun getNinegagnsfwPage() = ninegagnsfwService.getPage()

    fun getNinegagnsfwPage(id: String) = ninegagnsfwService.getPage(id)
}
