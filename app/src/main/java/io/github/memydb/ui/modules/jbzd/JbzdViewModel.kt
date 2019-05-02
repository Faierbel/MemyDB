package io.github.memydb.ui.modules.jbzd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.JbzdRepository
import javax.inject.Inject

class JbzdViewModel @Inject constructor(private val jbzdRepository: JbzdRepository) : ViewModel() {

    val jbzdMemes: LiveData<List<Meme>>
        get() = mutableJbzdMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableJbzdMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage == 0) downloadNextPage()
    }

    fun downloadNextPage() {
        currentPage++
        val page = jbzdRepository.getJbzdPage(currentPage)
        mutableJbzdMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableJbzdMemes.value = memesList
            }
        }
        page.refresh()
    }
}
