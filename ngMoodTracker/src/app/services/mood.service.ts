import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Mood } from '../models/mood';
import { Occurance } from '../models/occurance';

const API_URL = 'http://localhost:8080/api/moods';

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  constructor(private http: HttpClient) { }

  index() {
    return this.http.get<Mood[]>(API_URL);
  }
}
