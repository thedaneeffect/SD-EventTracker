import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Mood } from '../models/mood';

const BASE_URL = environment.baseUrl;
const API_URL = `${BASE_URL}api/moods`;

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  constructor(private http: HttpClient) { }

  index() {
    return this.http.get<Mood[]>(API_URL);
  }

  get(id:string) {
    return this.http.get<Mood>(`${API_URL}/${id}`);
  }

  save(mood: Mood) {
    return this.http.put<void>(API_URL, JSON.stringify(mood), {
      headers: {
        "Content-Type": "application/json"
      }
    });
  }
}
