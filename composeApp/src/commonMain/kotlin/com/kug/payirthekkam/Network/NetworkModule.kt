package com.kug.payirthekkam.Network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.* // for Android
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object NetworkModule {

    // Lazy initialization — only when first used
    val httpClient: HttpClient by lazy {
        HttpClient(OkHttp) { // ✅ specify engine
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }

        }
    }
}