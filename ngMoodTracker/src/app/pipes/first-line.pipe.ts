import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'firstLine'
})
export class FirstLinePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    return value.split("\n")[0];
  }

}
