package devfest.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Float,
    val voteCount: Int,
    val posterUrl: String
)