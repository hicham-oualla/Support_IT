import {Component, OnInit} from '@angular/core';
import {Equipement} from "../../classes/equipement";
import {EquipementService} from "../../services/equipement.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-equipement',
  templateUrl: './equipement.component.html',
  styleUrls: ['./equipement.component.css']
})
export class EquipementComponent implements OnInit{

  equipments!: Equipement[];

  constructor(private equipmentService: EquipementService,
              private router: Router) { }

  ngOnInit(): void {
    this.getEquipments()
  }

  private getEquipments(){
    this.equipmentService.getEquipments().subscribe(
      data=>{
        this.equipments = data
        console.log(data)
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
