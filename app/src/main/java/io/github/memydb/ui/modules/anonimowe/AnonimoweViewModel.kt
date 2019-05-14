package io.github.memydb.ui.modules.anonimowe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.AnonimoweRepository
import javax.inject.Inject

class AnonimoweViewModel @Inject constructor(
    private val anonimoweRepository: AnonimoweRepository
) : ViewModel() {

    val anonimoweMemes: LiveData<List<Meme>>
        get() = mutableAnonimoweMemes

    private val memesList = mutableListOf<Meme>()

    private var currentPage = 0

    private val mutableAnonimoweMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (currentPage == 0) downloadNextPage()
    }

    fun downloadNextPage() {
        currentPage++
        val page = anonimoweRepository.getAnonimowePage(currentPage)
        mutableAnonimoweMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableAnonimoweMemes.value = memesList
            }
        }
        page.refresh()
    }

}
