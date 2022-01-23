import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { Mood } from 'src/app/models/mood';
import { Occurance } from 'src/app/models/occurance';
import { MoodService } from 'src/app/services/mood.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  occurances: Occurance[] = [];
  moodsI: Mood[] = [];

  constructor(private moods: MoodService) {}

  ngOnInit(): void {
    this.moods.index().subscribe({
      next: (moods) => {
        console.log(moods);
        this.moodsI = moods;
      },

      error: (err) => {
        console.log(err);
        throwError(() => new Error(err));
      },
    });
  }
}
