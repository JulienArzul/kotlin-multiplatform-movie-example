package devfest.domain

import devfest.domain.model.MovieResult
import kotlinx.coroutines.coroutineScope

class MovieRepository(private val movieApiService: MovieApiService) {

    suspend fun discoverMovies(): List<MovieResult> = coroutineScope {
        movieApiService.discoverMovies().results
    }
}