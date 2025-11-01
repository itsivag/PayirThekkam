package com.kug.payirthekkam.repository

import Facility
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class FacilityRepository(private val client: HttpClient) {

    suspend fun getAllFacilities(): List<Facility> {
        return client.get("https://your-api-base-url.com/api/v1/facilities/").body()
    }
}