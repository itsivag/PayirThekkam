import kotlinx.datetime.LocalDate

data class Booking(
    val id: String, // UUID as String for KMP compatibility
    val farmerId: String?, // Foreign key to farmers.id
    val facilityId: String?, // Foreign key to facilities.id
    val cropType: String,
    val quantitySacks: Int,
    val status: BookingStatus = BookingStatus.PENDING,
    val pricePerSack: Double? = null,
    val priceTotal: Double? = null,
    val startDate: LocalDate,
    val endDate: LocalDate? = null,
    val notes: String? = null
)

enum class BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED
}