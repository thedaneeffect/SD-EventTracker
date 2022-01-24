import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, NgModel } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-mood-control',
  templateUrl: './mood-control.component.html',
  styleUrls: ['./mood-control.component.css'],

})
export class MoodControlComponent implements OnInit {

  @Input("value") value: number = 2;
  
  mood = new FormControl();

  constructor() { }

  ngOnInit(): void {
  }

  onMoodChanged() {
    this.update.emit(this.mood.value);
  }

  onOk() {
    this.ok.emit();
  }

  @Output("ok") ok = new EventEmitter<void>();

  @Output("update") update = new EventEmitter<number>();
  
}
