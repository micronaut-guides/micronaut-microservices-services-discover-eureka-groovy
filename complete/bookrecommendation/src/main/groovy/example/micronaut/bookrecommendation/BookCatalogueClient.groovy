//tag::packageandimports[]
package example.micronaut.bookrecommendation

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Recoverable
import io.reactivex.Flowable
//end::packageandimports[]

/*
//tag::harcoded[]
@Client("http://localhost:8081") // <1>
@Recoverable(api = BookCatalogueOperations.class)
//end::harcoded[]
*/
//tag::eureka[]
@Client(id = "bookcatalogue") // <1>
@Recoverable(api = BookCatalogueOperations.class)
//end::eureka[]
//tag::clazz[]
interface BookCatalogueClient extends BookCatalogueOperations {

    @Get("/books")
    Flowable<Book> findAll()
}
//end::clazz[]
