package devfest.domain.model

import com.soywiz.klock.DateTime

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: DateTime,
    val voteAverage: Float,
    val voteCount: Int,
    val posterUrl: String
)