import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { TopicFilterPipe } from './topic-filter.pipe';
import { TopicDropDownFilterPipe } from './topic-drop-down-filter.pipe';
import { BorrowedBookListComponent } from './borrowed-book-list/borrowed-book-list.component';


@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    CreateBookComponent,
    TopicFilterPipe,
    TopicDropDownFilterPipe,
    BorrowedBookListComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
