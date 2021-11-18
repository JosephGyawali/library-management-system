import { Pipe, PipeTransform } from '@angular/core';
import { Book } from './book';

@Pipe({
  name: 'topicFilter'
})

export class TopicFilterPipe implements PipeTransform {

  transform(books: Book[], topic: any): Book[] {
    if(topic === undefined) return books;
    return books.filter(book =>
      book.topic.toLowerCase().indexOf(topic.toLowerCase()) !== -1);
  }

}
