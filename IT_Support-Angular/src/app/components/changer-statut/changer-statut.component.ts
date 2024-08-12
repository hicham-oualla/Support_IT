import {Component, OnInit} from '@angular/core';
import {Equipement} from "../../classes/equipement";
import {EquipementService} from "../../services/equipement.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-changer-statut',
  templateUrl: './changer-statut.component.html',
  styleUrls: ['./changer-statut.component.css']
})
export class ChangerStatutComponent implements OnInit{

  id!: number;
  equipement: Equipement = new Equipement();
  constructor(private equipementService: EquipementService,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.equipementService.equipementById(this.id).subscribe(
      data =>{
        this.equipement = data;
      },error => console.log(error)
    );
  }

  onSubmit(){
    this.equipementService.changerStaut(this.id, this.equipement).subscribe(
      data=>{
        console.log(data)
        this.router.navigate(['equipements']);
      }
    )
  }

}
