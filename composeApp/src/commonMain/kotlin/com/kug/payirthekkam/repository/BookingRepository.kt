import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class BookingRepository(private val client: HttpClient) {

    suspend fun getBookingById(id: String, token: String): Booking {
        return client.get("https://your-api-base-url.com/api/v1/bookings/$id") {
            header(HttpHeaders.Authorization, "Bearer $token")
        }.body()
    }
}