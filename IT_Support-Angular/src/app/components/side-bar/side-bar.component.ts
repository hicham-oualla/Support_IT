import { Component, AfterViewInit } from '@angular/core';
import {Equipement} from "../../classes/equipement";

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent  {

  constructor() {}


  protected readonly Equipement = Equipement;
}
