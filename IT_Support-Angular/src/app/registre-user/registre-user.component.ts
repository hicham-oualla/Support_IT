import {Component, OnInit} from '@angular/core';
import {User} from "../classes/user";
import {Roles} from "../roles";
import {UserService} from "../services/user.service";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registre-user',
  templateUrl: './registre-user.component.html',
  styleUrls: ['./registre-user.component.css']
})
export class RegistreUserComponent implements OnInit{
  newUser: User = new User(); // Default role is USER

  constructor(private userService: UserService, private route: Router) { }

  registerUser() {
    this.userService.registerUser(this.newUser).subscribe(response => {
      this.route.navigateByUrl("/user_liste")
      console.log('User registered:', response);
    }, error => {
      console.error('Registration error:', error);
    });
  }

  ngOnInit() {
    console.log(this.newUser.nom)
    console.log(this.newUser.email)
    console.log(this.newUser.password)
  }


}
