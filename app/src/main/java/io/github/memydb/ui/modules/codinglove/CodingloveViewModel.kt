package io.github.memydb.ui.modules.codinglove

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.CodingloveRepository
import javax.inject.Inject

class CodingloveViewModel @Inject constructor(
    private val codingloveRepository: CodingloveRepository
) : ViewModel() {

    val codingloveMemes: LiveData<List<Meme>>
        get() = mutableCodingloveMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableCodingloveMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage == 0) downloadNextPage()
    }

    fun downloadNextPage() {
        currentPage++
        val page = codingloveRepository.getCodingLovePage(currentPage)
        mutableCodingloveMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableCodingloveMemes.value = memesList
            }
        }
        page.refresh()
    }
}
