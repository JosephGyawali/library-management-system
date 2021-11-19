import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-wish-list',
  templateUrl: './wish-list.component.html',
  styleUrls: ['./wish-list.component.css']
})
export class WishListComponent implements OnInit {

  books: Book[];

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    this.bookService.getWishList().subscribe(data => {
      this.books = data;
    })
  }

  returnBook(id: number){
    this.bookService.returnWishListBook(id).subscribe(data => {
      console.log(data)
    })
    this.router.navigate(['/books']);

  }

}
