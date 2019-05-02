package io.github.memydb.ui.modules.mistrzowie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.MistrzowieRepository
import javax.inject.Inject

class MistrzowieViewModel @Inject constructor(private val mistrzowieRepository: MistrzowieRepository) : ViewModel() {

    val mistrzowieMemes: LiveData<List<Meme>>
        get() = mutableMistrzowieMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableMistrzowieMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage == 0) downloadNextPage()
    }

    fun downloadNextPage() {
        currentPage++
        val page = mistrzowieRepository.getMistrzowiePage(currentPage)
        mutableMistrzowieMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableMistrzowieMemes.value = memesList
            }
        }
        page.refresh()
    }
}
