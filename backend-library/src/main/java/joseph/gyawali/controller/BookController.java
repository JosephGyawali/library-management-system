package joseph.gyawali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joseph.gyawali.model.Book;
import joseph.gyawali.repository.BookRepository;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

	@Autowired
	private BookRepository BookRepository;
	
	// get all books
	@GetMapping("/books")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> getAllItems(){
		return BookRepository.findAll();
	}
	
	// create book rest api
	@PostMapping("/books")
	@CrossOrigin(origins = "http://localhost:4200")
	public Book createBook(@RequestBody Book book) {
		return BookRepository.save(book);
	}
	
}
