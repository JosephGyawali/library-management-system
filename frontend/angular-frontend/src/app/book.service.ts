import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from './book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1/books";

  private borrwedBookUrl = "http://localhost:8080/api/v1/borrowed-books";

  private wishListUrl="http://localhost:8080/api/v1/wishlist-books";

  constructor(private HttpClient: HttpClient) { }

  getBooksList(): Observable<Book[]>{
    return this.HttpClient.get<Book[]>(`${this.baseUrl}`);
  }

  createBook(book: Book): Observable<Object> {
    return this.HttpClient.post<Object>(`${this.baseUrl}`, book);
  }

  getBookById(id: number): Observable<Book>{
    return this.HttpClient.get<Book>(`${this.baseUrl}/${id}`);
  }

  deleteBook(id: number): Observable<Object>{
    return this.HttpClient.delete(`${this.baseUrl}/${id}`);
  }

  // borrowed books api calls
  addToBorrowedList(book: Book): Observable<Object>{
    return this.HttpClient.post<Object>(`${this.borrwedBookUrl}`, book);
  }

  getBorrowedBookList(): Observable<Book[]>{
    return this.HttpClient.get<Book[]>(`${this.borrwedBookUrl}`);
  }

  getBorrwedBookById(id: number): Observable<Book>{
    return this.HttpClient.get<Book>(`${this.borrwedBookUrl}/${id}`);
  }

  returnBook(id: number): Observable<Object>{
    return this.HttpClient.delete(`${this.borrwedBookUrl}/${id}`);
  }

  // wish list api calls
  addToWishList(book: Book): Observable<Object>{
    return this.HttpClient.post<Object>(`${this.wishListUrl}`, book);
  }

  getWishList(): Observable<Book[]>{
    return this.HttpClient.get<Book[]>(`${this.wishListUrl}`);
  }

  getWishListBookById(id: number): Observable<Book>{
    return this.HttpClient.get<Book>(`${this.wishListUrl}/${id}`);
  }

  returnWishListBook(id: number): Observable<Object>{
    return this.HttpClient.delete(`${this.wishListUrl}/${id}`);
  }
}
