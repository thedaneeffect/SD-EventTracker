import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mood } from '../models/mood';

const API_URL = 'http://localhost:8080/api/moods';

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  constructor(private http: HttpClient) { }

  index() {
    return this.http.get<Mood[]>(API_URL);
  }

  save(mood: Mood) {
    return this.http.put<void>(API_URL, JSON.stringify(mood), {
      headers: {
        "Content-Type": "application/json"
      }
    });
  }
}
