package io.github.memydb.ui.modules.ninegagnsfw

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.github.memydb.data.api.ApiResponse
import io.github.memydb.data.pojos.Meme
import io.github.memydb.data.repositories.NinegagnsfwRepsoitory
import javax.inject.Inject

class NinegagnsfwViewModel @Inject constructor(private val ninegagnsfwRepsoitory: NinegagnsfwRepsoitory) : ViewModel() {

    val ninegagnsfwMemes: LiveData<List<Meme>>
        get() = mutableNinegagnsfwMemes

    private val memesList = mutableListOf<Meme>()

    private var nextPage = ""

    private val mutableNinegagnsfwMemes = MediatorLiveData<List<Meme>>()

    fun initialize() {
        if (nextPage == "") downloadNextPage()
    }

    fun downloadNextPage() {
        val page = if (nextPage == "") {
            ninegagnsfwRepsoitory.getNinegagnsfwPage()
        } else {
            ninegagnsfwRepsoitory.getNinegagnsfwPage(nextPage)
        }

        mutableNinegagnsfwMemes.addSource(page) {
            if (it is ApiResponse.SuccessApiResponse) {
                memesList.addAll(it.value.memes)
                mutableNinegagnsfwMemes.value = memesList
                nextPage = it.value.nextPage.removePrefix("/9gagnsfw/page/")
            }
        }
        page.refresh()
    }
}
