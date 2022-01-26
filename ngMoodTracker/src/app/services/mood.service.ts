import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Mood } from '../models/mood';

const BASE_URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  authorization: string = "";
  id: number = -1;

  constructor(private http: HttpClient) { }

  getRequestOptions() {
    return {
      headers: {
        "Authorization": `Basic ${this.authorization}`,
        "Content-Type": "application/json",
      }
    }
  }

  loggedIn() {
    return this.id !== -1;
  }

  getURI() {
    return `${BASE_URL}api/users/${this.id}/moods`
  }

  auth(): Subject<boolean> | undefined {
    let auth = localStorage.getItem("auth");
    if (auth) {
      let success = new Subject<boolean>();

      this.login({auth: auth}).subscribe({
        next: (id) => {
          if (id == -1) {
            success.next(false);
          } else {
            this.id = id;
            success.next(true);
          }
        }
      });
      return success;
    }
    return
  }

  /**
   * 
   * @param data 
   * @returns 
   */
  login(data:{name?:string, password?: string, auth?:string}) {
    if (!data.auth) {
      this.authorization = btoa(`${data.name}:${data.password}`);
      localStorage.setItem("auth", this.authorization);
    } else {
      this.authorization = data.auth;
    }
    return this.http.get<number>(`${BASE_URL}login`, this.getRequestOptions());
  }

  register(name:string, password: string){
    return this.http.post<any>(`${BASE_URL}register`, {
      name: name,
      password: password
    })
  }

  index() {
    return this.http.get<Mood[]>(this.getURI(), this.getRequestOptions());
  }

  save(mood: Mood) {
    return this.http.put<void>(this.getURI(), JSON.stringify(mood), this.getRequestOptions());
  }
}
