package ee.karl.books.controller;

import ee.karl.books.service.BookService;
import ee.karl.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //curl -X GET http://localhost:8080/books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    // curl -X GET http://localhost:8080/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
//cmd:  curl -X POST http://localhost:8080/books ^
//  -H "Content-Type: application/json" ^
//  -d "{\"title\":\"Lõvikuningas\",\"author\":\"A.C.Doyle\",\"isbn\":\"123-44444455\"}"

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.save(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // curl -X PUT http://localhost:8080/books/2 ^
    //  -H "Content-Type: application/json" ^
    //  -d "{\"title\":\"L6vikuningas\",\"author\":\"Updated A.C.Toyle\",\"isbn\":\"123-4566660123\"}"
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        final Book updatedBook = bookService.save(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }
// curl -X DELETE http://localhost:8080/books/1
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
