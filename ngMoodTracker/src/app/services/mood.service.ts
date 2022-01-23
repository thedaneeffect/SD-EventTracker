import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Occurance } from '../models/occurance';

const API_URL = 'http://localhost:8080/api/';

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  constructor(private http: HttpClient) { }

  index(): Occurance[] {
    return [];
  }
}
