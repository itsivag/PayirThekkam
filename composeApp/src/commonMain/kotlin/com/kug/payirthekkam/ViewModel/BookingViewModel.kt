package com.kug.payirthekkam.ViewModel

import Booking
import BookingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class BookingViewModel(
    private val repository: BookingRepository
) {
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _booking = MutableStateFlow<Booking?>(null)
    val booking = _booking.asStateFlow()

    fun loadBooking(id: String, token: String) {
        viewModelScope.launch {
            try {
                _booking.value = repository.getBookingById(id, token)
            } catch (e: Exception) {
                println("Error fetching booking: ${e.message}")
            }
        }
    }
}