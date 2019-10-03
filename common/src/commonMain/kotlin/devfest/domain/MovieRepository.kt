package devfest.domain

import devfest.domain.model.Movie
import devfest.network.MovieApiService
import devfest.network.models.ApiMovieLight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieRepository(private val movieApiService: MovieApiService) {

    /**
     * iOS doesn't support suspend functions yet so we have to offer a function that launch
     * the function in a given CoroutineScope and return the result in a Callback
     */
    fun discoverMovies(coroutineScope: CoroutineScope, callback: (List<Movie>) -> Unit) {
        coroutineScope.launch {
            val offerList = discoverMovies()
            callback(offerList)
        }
    }

    suspend fun discoverMovies(): List<Movie> = coroutineScope {
        movieApiService.discoverMovies().results.map {
            it.mapToMovie()
        }
    }
}

private fun ApiMovieLight.mapToMovie(): Movie {
    return Movie(
        id,
        title,
        overview,
        releaseDate,
        voteAverage,
        voteCount,
        posterPath
    )
}