package devfest.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiMovieListResponse(
    val results: List<ApiMovieLight>
)

@Serializable
internal data class ApiMovieLight(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("vote_count")
    val voteCount: Int,
    @SerialName("poster_path")
    val posterPath: String
)
