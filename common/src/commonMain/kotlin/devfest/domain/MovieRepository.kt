package devfest.domain

import devfest.domain.model.MovieResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieRepository(private val movieApiService: MovieApiService) {

    /**
     * iOS doesn't support suspend functions yet so we have to offer a function that launch
     * the function in a given CoroutineScope and return the result in a Callback
     */
    fun discoverMovies(coroutineScope: CoroutineScope, callback: (List<MovieResult>) -> Unit) {
        coroutineScope.launch {
            val offerList = discoverMovies()
            callback(offerList)
        }
    }

    suspend fun discoverMovies(): List<MovieResult> = coroutineScope {
        movieApiService.discoverMovies().results
    }
}