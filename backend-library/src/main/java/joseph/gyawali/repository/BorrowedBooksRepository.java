package joseph.gyawali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import joseph.gyawali.model.BorrowedBooks;

public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Long>{

}
