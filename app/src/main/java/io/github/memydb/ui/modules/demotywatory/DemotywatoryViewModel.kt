package io.github.memydb.ui.modules.demotywatory

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Page
import io.github.memydb.data.repositories.DemotywatoryRepository
import javax.inject.Inject

class DemotywatoryViewModel @Inject constructor(
    private val demotywatoryRepository: DemotywatoryRepository
) : ViewModel() {

    val demotywatoryPage = MediatorLiveData<ApiResponse<Page>>()

    fun downloadPage(pageId: Int) {
        val page = demotywatoryRepository.getDemotywatoryPage(pageId)
        demotywatoryPage.addSource(page) { demotywatoryPage.value = it }
        page.refresh()
    }

}