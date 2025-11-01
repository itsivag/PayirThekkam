package com.kug.payirthekkam.ViewModel

import Facility
import com.kug.payirthekkam.repository.FacilityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FacilityViewModel(
    private val repository: FacilityRepository
) {
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _facilities = MutableStateFlow<List<Facility>>(emptyList())
    val facilities = _facilities.asStateFlow()

    fun loadFacilities() {
        viewModelScope.launch {
            try {
                _facilities.value = repository.getAllFacilities()
            } catch (e: Exception) {
                println("Error fetching facilities: ${e.message}")
            }
        }
    }
}