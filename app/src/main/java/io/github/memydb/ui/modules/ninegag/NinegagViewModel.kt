package io.github.memydb.ui.modules.ninegag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.NinegagRepository
import javax.inject.Inject

class NinegagViewModel @Inject constructor(private val ninegagRepository: NinegagRepository) : ViewModel() {

    val ninegagMemes: LiveData<List<Meme>>
        get() = mutableNinegagMemes

    private val memesList = mutableListOf<Meme>()

    private var nextPage = ""

    private val mutableNinegagMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (nextPage == "") downloadNextPage()
    }

    fun downloadNextPage() {
        val page = if (nextPage == "") ninegagRepository.getNinegagPage() else ninegagRepository.getNinegagPage(nextPage)
        mutableNinegagMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableNinegagMemes.value = memesList
                nextPage = it.value.nextPage.removePrefix("/9gag/page/")
            }
        }
        page.refresh()
    }
}
