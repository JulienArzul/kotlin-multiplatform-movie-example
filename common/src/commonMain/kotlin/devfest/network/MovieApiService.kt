package devfest.network

import devfest.network.models.ApiMovieListResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

class MovieApiService(private val baseUrl: String, private val apiKey: String) {

    companion object {
        internal const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
    }

    private val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict)
        }
    }

    internal suspend fun discoverMovies(): ApiMovieListResponse = coroutineScope {
        client.get<ApiMovieListResponse>("$baseUrl/discover/movie?api_key=$apiKey&sort_by=popularity.desc")
    }
}