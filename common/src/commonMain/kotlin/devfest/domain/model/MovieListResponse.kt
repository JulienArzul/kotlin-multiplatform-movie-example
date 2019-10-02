package devfest.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val results: List<MovieResult>
)

@Serializable
data class MovieResult(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("vote_count")
    val voteCount: Int,
    val poster_path: String
)
