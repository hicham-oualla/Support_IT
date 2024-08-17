import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {Route, Router} from "@angular/router";
import {Technicien} from "../classes/technicien";

@Component({
  selector: 'app-registre-tech',
  templateUrl: './registre-tech.component.html',
  styleUrls: ['./registre-tech.component.css']
})
export class RegistreTechComponent implements OnInit{
  techniecien: Technicien = new Technicien();

  constructor(private service: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  addTech(){
    this.service.registertech(this.techniecien).subscribe(
      data=> {
        console.log(data)
      }
    )
  }

  onSubmit(){
    this.addTech()
    this.router.navigate( ['techniciens'])
  }

}
