import kotlinx.serialization.Serializable
import kotlinx.datetime.Instant
import com.benasher44.uuid.Uuid
import kotlinx.serialization.Contextual
import kotlin.time.ExperimentalTime

@Serializable
data class Facility @OptIn(ExperimentalTime::class) constructor(
    @Contextual val id: Uuid,
    val name: String,
    val type: String,
    val district: String,
    val taluk: String,
    val village: String,
    val address: String? = null,
    val totalCapacitySacks: Int,
    val availableCapacitySacks: Int,
    val contactPhone: String? = null,
    val ownerType: String? = null,
    val isActive: Boolean = true,
    val createdAt: Instant,
    val updatedAt: Instant,
    @Contextual val createdBy: Uuid,
    @Contextual val updatedBy: Uuid
)