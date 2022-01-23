import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { Mood } from 'src/app/models/mood';
import { Occurance } from 'src/app/models/occurance';
import { MoodService } from 'src/app/services/mood.service';
import { CalendarEvent } from 'angular-calendar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  viewDate: Date = new Date();
  events: CalendarEvent[] = [];

  constructor(private moods: MoodService) {}

  ngOnInit(): void {}
}
