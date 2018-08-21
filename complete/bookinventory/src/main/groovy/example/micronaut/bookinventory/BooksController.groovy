package example.micronaut.bookinventory

import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.validation.Validated
import javax.validation.constraints.NotBlank

@CompileStatic
@Validated // <1>
@Controller("/books") // <2>
class BooksController {

    @Produces(MediaType.TEXT_PLAIN) // <3>
    @Get("/stock/{isbn}") // <4>
    Boolean stock(@NotBlank String isbn) {
        bookInventoryByIsbn(isbn).map { bi -> bi.getStock() > 0 }.orElse(null)
    }

    private Optional<BookInventory> bookInventoryByIsbn(String isbn) {
        if(isbn == "1491950358") {
            return Optional.of(new BookInventory(isbn, 4))

        } else if(isbn == "1680502395") {
            return Optional.of(new BookInventory(isbn, 0))
        }
        Optional.empty()
    }
}
