import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-borrowed-book-list',
  templateUrl: './borrowed-book-list.component.html',
  styleUrls: ['./borrowed-book-list.component.css']
})
export class BorrowedBookListComponent implements OnInit {


  books: Book[];

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    console.log("Hitting this");
    this.bookService.getBorrowedBookList().subscribe(data => {
      console.log(`${data}`);
      this.books = data;
    })
  }

  returnBook(id: number){
    this.bookService.getBorrwedBookById(id).subscribe(data => {
      console.log("1: "+data);
      this.bookService.createBook(data).subscribe(data => {
        console.log("2: "+data);
      })
    })

    // delete it
    this.bookService.returnBook(id).subscribe(data => {
      console.log(data);
      this.getBooks();
    })

    // this.router.navigate(['/borrowed-books']);
  }

}
