package io.github.memydb.ui.modules.demotywatory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.DemotywatoryRepository
import javax.inject.Inject

class DemotywatoryViewModel @Inject constructor(
    private val demotywatoryRepository: DemotywatoryRepository
) : ViewModel() {

    val demotywatoryMemes: LiveData<List<Meme>>
        get() = mutableDemotywatoryMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableDemotywatoryMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage == 0) downloadNextPage()
    }

    fun downloadNextPage() {
        currentPage++
        val page = demotywatoryRepository.getDemotywatoryPage(currentPage)
        mutableDemotywatoryMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableDemotywatoryMemes.value = memesList
            }
        }
        page.refresh()
    }
}