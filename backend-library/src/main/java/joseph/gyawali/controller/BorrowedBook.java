//package joseph.gyawali.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import joseph.gyawali.repository.BorrowedBooksRepository;
//
//@RestController
//@RequestMapping("/api/v1/")
//public class BorrowedBook {
//
//	@Autowired
//	private BorrowedBooksRepository BorrowedBooksRepository;
//	
//	// get all books
//	@GetMapping("/books")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public List<BorrowedBook> getAllItems(){
//			return BorrowedBooksRepository.findAll();
//	}
//	
//}
