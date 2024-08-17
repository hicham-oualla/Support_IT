import {Component, OnInit} from '@angular/core';
import {Equipement} from "../../classes/equipement";
import {EquipementService} from "../../services/equipement.service";
import {Router} from "@angular/router";
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-equipement',
  templateUrl: './equipement.component.html',
  styleUrls: ['./equipement.component.css']
})
export class EquipementComponent implements OnInit{

  equipments: Equipement[]=[];

  constructor(private equipmentService: EquipementService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEquipments()
  }

   getEquipments(){
    this.equipmentService.getEquipments().subscribe(
        (data)=>{
          console.log(data)
          this.equipments = data;
      }
    )
  }

  updateEquipement(id: Number) {
  this.router.navigate(['updateEquipement', id])
  }

  changerEquipement(id: Number) {
    this.router.navigate(['statut', id])
  }
  addequipment () {
    this.router.navigate(['addEquipement'])
  }


  deleteEquipement(id: Number){
    this.equipmentService.deleteEquipement(id).subscribe(
      data=>{
        console.log(data)
        this.getEquipments()
      }
    )
  }


}
