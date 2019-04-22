package io.github.memydb.ui.modules.main

import androidx.lifecycle.ViewModel
import io.github.memydb.data.repositories.DemotywatoryRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(private val demotywatoryRepository: DemotywatoryRepository) : ViewModel() {

    val demotywatoryPage = demotywatoryRepository.getDemotywatoryPage()

}