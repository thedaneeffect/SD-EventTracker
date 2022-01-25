import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Subject, throwError } from 'rxjs';
import { Mood } from 'src/app/models/mood';
import { MoodService } from 'src/app/services/mood.service';
import { ChangeDetectionStrategy } from '@angular/core';
import {
  CalendarDateFormatter,
  CalendarMonthViewBeforeRenderEvent,
  CalendarView,
} from 'angular-calendar';
import { MonthViewDay } from 'calendar-utils';
import { formatDate } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CustomDateFormatter } from './custom-date-formatter.provider';

const MoodColor = [
  '#FF00007F',
  '#FFFF007F',
  '#AAAAAA7F',
  '#00FF007F',
  '#0000FF7F',
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [
    {
      provide: CalendarDateFormatter,
      useClass: CustomDateFormatter,
    }
  ]
})
export class HomeComponent implements OnInit {
  view: CalendarView = CalendarView.Month;
  viewDate: Date = new Date();
  refresh = new Subject<void>();

  moods: Mood[] = [];

  @ViewChild('moodModalTemplate', { read: TemplateRef })
  moodModalTemplate!: TemplateRef<any>;
  
  modalValue: Mood = {
    id: '',
    value: 2,
    description: '',
  };

  constructor(private service: MoodService, private modalService: NgbModal) {}

  ngOnInit(): void {
    this.service.index().subscribe({
      next: (moods) => {
        this.moods = moods;
        this.refresh.next();
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  preCalendarRender(event: CalendarMonthViewBeforeRenderEvent) {
    event.body.forEach((day) => {
      let key = formatDate(day.date, 'yyyy-MM-dd', 'en-US');
      let mood = this.moods.find((m) => m.id === key);
      if (mood) {
        day.meta = mood;
        day.backgroundColor = MoodColor[mood.value];
      }
    });
  }

  dayClicked(click: {
    day: MonthViewDay;
    sourceEvent: MouseEvent | KeyboardEvent;
  }): void {
    let id = formatDate(click.day.date, 'yyyy-MM-dd', 'en-US');
    let mood = this.moods.find((m) => m.id === id);

    if (mood) {
      this.modalValue = {
        id: mood.id,
        value: mood.value,
        description: mood.description
      };
    } else {
      this.modalValue = {
        id: id,
        value: 2,
        description: '',
      };
    }

    this.modalService.open(this.moodModalTemplate).result.then(
      (accept) => { 
        this.saveMood(this.modalValue);
      },
      (reject) => {
      }
    );
  }

  saveMood(next: Mood) {
    let mood = this.moods.find((m) => m.id === next.id);

    if (!mood) {
      mood = next;
      this.moods.push(mood);
    } else {
      mood.value = next.value;
      mood.description = next.description;
    }

    this.service.save(mood).subscribe({
      error: (error) => {
        console.log(error);
        return throwError(() => new Error(`Failed to save: ${error}`));
      },
    });

    this.refresh.next();
  }
}
