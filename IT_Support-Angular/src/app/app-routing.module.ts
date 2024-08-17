import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EquipementComponent} from "./components/equipement/equipement.component";
import {AddEquipementComponent} from "./components/add-equipement/add-equipement.component";
import {AppComponent} from "./app.component";
import {UpdateEquipementComponent} from "./components/update-equipement/update-equipement.component";
import {CreatePanneComponent} from "./components/create-panne/create-panne.component";
import {PannesComponent} from "./components/pannes/pannes.component";
import {ChangerStatutComponent} from "./components/changer-statut/changer-statut.component";
import {UpdatePanneComponent} from "./components/update-panne/update-panne.component";
import {RegistreUserComponent} from "./registre-user/registre-user.component";
import {UserListComponent} from "./user-list/user-list.component";
import {TechListeComponent} from "./tech-liste/tech-liste.component";
import {RegistreTechComponent} from "./registre-tech/registre-tech.component";
import {TicketsComponent} from "./components/tickets/tickets.component";
import {LoginComponent} from "./components/login/login.component";
import {guardGuard} from "./guards/guard.guard";

const routes: Routes = [
  {path:'', component: AppComponent},
  {path:'login', component: LoginComponent},
  {path:'addEquipement', component:AddEquipementComponent, canActivate:[guardGuard]},
  {path:'equipements', component: EquipementComponent, canActivate:[guardGuard]},
  {path:'regqitreuser', component: RegistreUserComponent, canActivate:[guardGuard]},
  {path:'updateEquipement/:id', component: UpdateEquipementComponent, canActivate:[guardGuard]},
  {path:'addPanne', component: CreatePanneComponent, canActivate:[guardGuard]},
  {path:'pannes', component: PannesComponent, canActivate:[guardGuard]},
  {path:'statut/:id', component:ChangerStatutComponent, canActivate:[guardGuard]},
  {path:'updatePanne/:id', component: UpdatePanneComponent, canActivate:[guardGuard]},
  {path:'user_liste', component: UserListComponent, canActivate:[guardGuard]},
  {path:'add', component: RegistreUserComponent, canActivate:[guardGuard]},
  {path:'techniciens', component: TechListeComponent, canActivate:[guardGuard]},
  {path:'techniciens/addtech', component:RegistreTechComponent, canActivate:[guardGuard]},
  {path:"tickets", component: TicketsComponent, canActivate:[guardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
