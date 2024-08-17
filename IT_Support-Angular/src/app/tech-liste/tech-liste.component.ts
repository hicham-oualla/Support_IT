import {Component, OnInit} from '@angular/core';
import {Technicien} from "../classes/technicien";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tech-liste',
  templateUrl: './tech-liste.component.html',
  styleUrls: ['./tech-liste.component.css']
})
export class TechListeComponent implements OnInit{

  Techniciens!:Technicien[];

  constructor(private service: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.getTechniciens()
  }

  getTechniciens(){
    this.service.getTechs().subscribe(
      data=>{
        console.log(data);
        this.Techniciens=data;
      }
    )
  }

}
