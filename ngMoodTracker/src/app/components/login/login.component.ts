import { AfterContentInit, AfterViewInit, Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MoodService } from 'src/app/services/mood.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @ViewChild('loginModalTemplate', { read: TemplateRef })
  loginModalTemplate!: TemplateRef<any>;

  username!:string;
  password!:string;
  passwordRepeated!:string;
  registering=false;

  constructor(private service : MoodService, private router : Router) { }

  login() {
    this.service.login({name:this.username, password:this.password}).subscribe({
      next: (id) => {
        if (id === -1) {
          alert("Invalid username or password.");
        } else {
          this.service.id = id;
          this.router.navigateByUrl("/home");
        }
      },
      error: (err) => {
        alert("Invalid username or password.");
      }
    })
  }

  register() {
    if (this.password !== this.passwordRepeated) {
      alert("Please make sure both passwords match.");
      return;
    }
  

    this.service.register(this.username, this.password).subscribe({
      next: () => {
        this.login();
      },
      error: (response) =>{
        console.log(response);
        alert(response.error.message);
      }
    })
  }

}
