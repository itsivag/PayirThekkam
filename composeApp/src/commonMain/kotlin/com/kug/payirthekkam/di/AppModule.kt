package com.kug.payirthekkam.di

import BookingRepository
import com.kug.payirthekkam.Network.NetworkModule
import com.kug.payirthekkam.ViewModel.BookingViewModel
import com.kug.payirthekkam.ViewModel.FacilityViewModel
import com.kug.payirthekkam.repository.FacilityRepository

object AppModule {
    private val client = NetworkModule.httpClient

    val bookingRepository = BookingRepository(client)
    val facilityRepository = FacilityRepository(client)

    val bookingViewModel = BookingViewModel(bookingRepository)
    val facilityViewModel = FacilityViewModel(facilityRepository)
}