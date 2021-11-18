import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'topicDropDownFilter'
})
export class TopicDropDownFilterPipe implements PipeTransform {

  transform(books: any[], args: any[]): any {
    return null;
  }

}
