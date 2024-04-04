import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import kotlinx.serialization.json.*

/**Asynchronously fetches a random useless fact from the uselessfacts.jsph.pl API
 * @return a [RandomFact] object representing a unique fact*/
fun getRandomFact(): RandomFact{
    //use Java's http library to request a random fact from the API
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("https://uselessfacts.jsph.pl/api/v2/facts/random"))
        .build()
    //clean response and deserialize to object
    return client.sendAsync(request, BodyHandlers.ofString())
        .thenApply { response: HttpResponse<*> -> response.body() }
        .thenApply { body -> body.toString()}
        .thenApply { json -> Json.decodeFromString<RandomFact>(json) }
        .join()
}

/**Prints a random fact from the uselessfacts.jsph.pl API*/
fun main() {
    println(getRandomFact().text)
}