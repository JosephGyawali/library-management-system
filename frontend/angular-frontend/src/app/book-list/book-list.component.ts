import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[];

  borrowedBook: Book = new Book();
  borrowedBooksList: Book[];

  topics: any;

  constructor(private bookService: BookService, private router: Router) {
    console.log( "HI " +this.topics);
   }

  ngOnInit(): void {
    this.getBooks();
    // console.log(this.topics);
  }

  private getBooks(){
    console.log("Hitting this");
    this.bookService.getBooksList().subscribe(data => {
      console.log(`${data}`);
      this.books = data;
    })
  }

  execute(){
    console.log(this.topics);
    this.appendBookTopics();
  }

  appendBookTopics(){
    // this.books.map(book => book.topic)
    // .filter((value, index, self) => self.indexOf(value) === index);

    // this.books = this.books.filter((val,ind,arr)=>
    //    ind === ((t) => (
    //      t.topic == val.topic
    //    ));


    console.log(this.books);
  }



  borrowBook(id: number){
   
    this.bookService.getBookById(id).subscribe(data => {
      
      this.bookService.addToBorrowedList(data).subscribe(data => {
        console.log(data);
      });
    })

    // this.saveBookToBorrowedList(newBook);
    this.bookService.deleteBook(id).subscribe(data => {
      console.log(data);
      this.getBooks();
    })
  }


}
