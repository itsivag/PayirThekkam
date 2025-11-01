package com.kug.payirthekkam.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.kug.payirthekkam.ViewModel.BookingViewModel
import com.kug.payirthekkam.ViewModel.FacilityViewModel
import com.kug.payirthekkam.di.AppModule

@Composable
fun HomeScreen(onNextButtonClicked: () -> Unit) {
     val bookingVm = AppModule.bookingViewModel
     val facilityVm = AppModule.facilityViewModel
    LaunchedEffect(Unit) {
       print( bookingVm.loadBooking(id = "1234", token = "jwt_token_here"))
      print(  facilityVm.loadFacilities())
    }
    Column {
        Text("Home Screen")
        Button(onClick = onNextButtonClicked) {
            Text("navigate to feature")
        }
    }
}
