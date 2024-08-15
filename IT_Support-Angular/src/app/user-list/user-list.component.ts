import {Component, OnInit} from '@angular/core';
import {User} from "../classes/user";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit{

  User!: User[];

  constructor(private service:UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.getUsers()
  }

  getUsers(){
    this.service.getUsers().subscribe(
      data=>{
        console.log(data);
        this.User= data;
      }
    )
  }



}
