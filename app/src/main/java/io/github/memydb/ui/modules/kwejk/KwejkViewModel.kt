package io.github.memydb.ui.modules.kwejk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.KwejkRepository
import javax.inject.Inject

class KwejkViewModel @Inject constructor(private val kwejkRepository: KwejkRepository) : ViewModel() {

    val kwejkMemes: LiveData<List<Meme>>
        get() = mutableKwejkMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableKwejkMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage != 0) return

        val page = kwejkRepository.getKwejkPage()
        mutableKwejkMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableKwejkMemes.value = memesList
                currentPage = it.value.nextPage.removePrefix("/kwejk/page/").toInt()
            }
        }
        page.refresh()
    }

    fun downloadNextPage() {
        currentPage--
        val page = kwejkRepository.getKwejkPage(currentPage)
        mutableKwejkMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableKwejkMemes.value = memesList
            }
        }
        page.refresh()
    }
}
