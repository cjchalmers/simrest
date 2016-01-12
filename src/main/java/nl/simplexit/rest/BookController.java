package nl.simplexit.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by colin on 30-12-15.
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){

    //    Book book = new Book();

        Book book = new Book(bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()));

        bookRepository.save(book);

        Map<String, Object> response = new LinkedHashMap<String, Object>();

        response.put("message", "Book created successfully");

        response.put("book", book);

        return response;

    }

    @ApiOperation(value = "Find book based on identifier", response= Book.class)
    @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
    public Book getBookDetails(@PathVariable("bookId") String bookId){

        Book tst = bookRepository.findOne(bookId);

        Book book = new Book();
        book.setId("1");
        book.setName("collie");
        book.setIsbn("1234567889");
        book.setAuthor("mannerism");

        return tst;
    }

    @RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
    public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
                                        @RequestBody Map<String, Object> bookMap){
        Book book = new Book(bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()));
        book.setId(bookId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book Updated successfully");
        response.put("book", bookRepository.save(book));
        return response;
    }


    @RequestMapping(method = RequestMethod.DELETE, value="/{bookId}")
    public Map<String, String> deleteBook(@PathVariable("bookId") String bookId){
        bookRepository.delete(bookId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Book deleted successfully");

        return response;
    }

}
