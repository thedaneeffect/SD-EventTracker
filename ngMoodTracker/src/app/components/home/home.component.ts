import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { Mood } from 'src/app/models/mood';
import { MoodService } from 'src/app/services/mood.service';
import { ChangeDetectionStrategy } from '@angular/core';
import {
  CalendarMonthViewBeforeRenderEvent,
  CalendarView,
} from 'angular-calendar';
import { MonthViewDay } from 'calendar-utils';
import { formatDate } from '@angular/common';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
})
export class HomeComponent implements OnInit {
  view: CalendarView = CalendarView.Month;
  viewDate: Date = new Date();

  refresh = new Subject<void>();

  popupDate: string = '';
  popupVisible = false;
  popupX = 0;
  popupY = 0;
  popupValue = 2;

  moods: Mood[] = [];

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

  open(content: any) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          console.log(`Closed with: ${result}`);
        },
        (reason) => {
          console.log(`Dismissed ${this.getDismissReason(reason)}`);
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  preCalendarRender(event: CalendarMonthViewBeforeRenderEvent) {
    for (let day of event.body) {
      let key = formatDate(day.date, 'yyyy-MM-dd', 'en-US');
      let mood = this.moods.find((m) => m.id === key);
      if (mood) {
        day.backgroundColor = MoodColor[mood.value];
      }
    }
  }

  dayClicked(click: {
    day: MonthViewDay;
    sourceEvent: MouseEvent | KeyboardEvent;
  }): void {
    let event = click.sourceEvent as MouseEvent;

    this.popupVisible = true;
    this.popupX = event.clientX;
    this.popupY = event.clientY;
    this.popupDate = formatDate(click.day.date, 'yyyy-MM-dd', 'en-US');
    let mood = this.moods.find((m) => m.id === this.popupDate);

    if (mood) {
      this.popupValue = mood.value;
    } else {
      this.popupValue = 2;
    }
  }

  onMoodChanged(newValue: number) {
    let mood = this.moods.find((m) => m.id === this.popupDate);

    if (!mood) {
      mood = new Mood(this.popupDate, newValue);
      this.moods.push(mood);
    } else {
      mood.value = newValue;
    }

    this.service.save(mood);
    this.refresh.next();
  }

  onMoodOk() {
    this.popupVisible = false;
  }
}
