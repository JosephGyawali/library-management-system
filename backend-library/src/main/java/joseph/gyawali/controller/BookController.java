package joseph.gyawali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joseph.gyawali.exception.ResourceNotFoundException;
import joseph.gyawali.model.Book;
import joseph.gyawali.model.BorrowedBooks;
import joseph.gyawali.model.WishList;
import joseph.gyawali.repository.BookRepository;
import joseph.gyawali.repository.BorrowedBooksRepository;
import joseph.gyawali.repository.WishListRepository;




import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

	@Autowired
	private BookRepository BookRepository;

	@Autowired
	private BorrowedBooksRepository BorrowedBooksRepository;
	
	@Autowired
	private WishListRepository WishListRepository;
	
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
	
	// delete book rest api
	@DeleteMapping("/books/{id}")
	@CrossOrigin(origins = "http://localhost:4200") 
	public ResponseEntity<Map<String, Boolean>>  deleteItem(@PathVariable Long id){
		Book book = BookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: ")); 
		
		BookRepository.delete(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	// get item by id rest api
	@GetMapping("/books/{id}")
	@CrossOrigin(origins = "http://localhost:4200") 
	public ResponseEntity<Book> getItemById(@PathVariable Long id) {
		Book book = BookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item not exist with id: ")); 
		
		return ResponseEntity.ok(book);
	}
	
	
	// get all books in borrowed books table
	@GetMapping("/borrowed-books")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<BorrowedBooks> getAllBorrowedBooks(){
		return BorrowedBooksRepository.findAll();
	}
	
	// create borrowed books rest api
	@PostMapping("/borrowed-books")
	@CrossOrigin(origins = "http://localhost:4200")
	public BorrowedBooks createBorrowedBook(@RequestBody BorrowedBooks BorrowedBooks) {
		return BorrowedBooksRepository.save(BorrowedBooks);
	}
	
	// get borrowed books by id rest api
	@GetMapping("/borrowed-books/{id}")
	@CrossOrigin(origins = "http://localhost:4200") 
	public ResponseEntity<BorrowedBooks> getBookById(@PathVariable Long id) {
		BorrowedBooks BorrowedBooks = BorrowedBooksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item not exist with id: ")); 
		
		return ResponseEntity.ok(BorrowedBooks);
	}
	
	// delete borrowed Books rest api
	@DeleteMapping("/borrowed-books/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String, Boolean>>  returnBook(@PathVariable Long id){
		BorrowedBooks BorrowedBooks = BorrowedBooksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: ")); 
		
		BorrowedBooksRepository.delete(BorrowedBooks);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	// wish list books rest api
	
	// get all books in wish list table
	@GetMapping("/wishlist-books")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<WishList> getAllWishListBooks(){
		return WishListRepository.findAll();
	}
	
	// create wishlist books rest api
	@PostMapping("/wishlist-books")
	@CrossOrigin(origins = "http://localhost:4200")
	public WishList createWishListBooks(@RequestBody WishList WishList) {
		return WishListRepository.save(WishList);
	}

	// get wishlist books by id rest api
	@GetMapping("/wishlist-books/{id}")
	@CrossOrigin(origins = "http://localhost:4200") 
	public ResponseEntity<WishList> getWishListBooksById(@PathVariable Long id) {
		WishList WishList = WishListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item not exist with id: ")); 
			
		return ResponseEntity.ok(WishList);
	}
	
	// delete wishlist Books rest api
	@DeleteMapping("/wishlist-books/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String, Boolean>>  returnWishListBook(@PathVariable Long id){
		WishList WishList = WishListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: ")); 
			
		WishListRepository.delete(WishList);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
			
		return ResponseEntity.ok(response);
	}
	
	
	
	
}
