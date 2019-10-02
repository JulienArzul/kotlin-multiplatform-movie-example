package devfest.domain

import devfest.domain.model.MovieListResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

class MovieApiService {

    private val apiKey = "2d9bf24d8ab4e7f5ab94f25fa24aef3a"
    private val baseUrl = "https://api.themoviedb.org/3"

    private val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict)
        }
    }

    suspend fun discoverMovies(): MovieListResponse = coroutineScope {
        client.get<MovieListResponse>("$baseUrl/discover/movie?api_key=$apiKey&sort_by=popularity.desc")
    }
}