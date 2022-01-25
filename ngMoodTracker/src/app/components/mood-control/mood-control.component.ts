import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Mood } from 'src/app/models/mood';

@Component({
  selector: 'app-mood-control',
  templateUrl: './mood-control.component.html',
  styleUrls: ['./mood-control.component.css'],

})
export class MoodControlComponent implements OnInit {

  @Input("mood") mood!: Mood;
  @Output("moodChange") moodChange= new EventEmitter<Mood>();

  constructor() { }

  ngOnInit(): void {
  }

  
}