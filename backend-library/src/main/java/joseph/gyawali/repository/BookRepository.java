package joseph.gyawali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import joseph.gyawali.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
