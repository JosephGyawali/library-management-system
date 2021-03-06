import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { BorrowedBookListComponent } from './borrowed-book-list/borrowed-book-list.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { WishListComponent } from './wish-list/wish-list.component';

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'create-book', component: CreateBookComponent},
  {path: 'borrowed-books', component: BorrowedBookListComponent},
  {path: 'wishlist-books', component: WishListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
