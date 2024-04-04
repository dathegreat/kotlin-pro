import kotlinx.serialization.Serializable

/**
 * Used to deserialize responses from uselessfacts.jsph.pl into an object
 */
@Serializable
data class RandomFact(
    val id: String,
    val text: String,
    val language: String,
    val source: String,
    val source_url: String,
    val permalink: String
)