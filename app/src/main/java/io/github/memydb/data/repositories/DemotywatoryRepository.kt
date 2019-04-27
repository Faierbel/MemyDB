package io.github.memydb.data.repositories

import io.github.memydb.data.api.services.DemotywatoryService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DemotywatoryRepository @Inject constructor(private val demotywatoryService: DemotywatoryService) {

    fun getDemotywatoryPage(pageId: Int) = demotywatoryService.getPage(pageId)
}
