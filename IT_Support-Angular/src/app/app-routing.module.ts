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

const routes: Routes = [
  {path:'', component: AppComponent},
  {path:'addEquipement', component:AddEquipementComponent},
  {path:'equipements', component: EquipementComponent},
  {path:'regqitreuser', component: RegistreUserComponent},
  {path:'updateEquipement/:id', component: UpdateEquipementComponent},
  {path:'addPanne', component: CreatePanneComponent},
  {path:'pannes', component: PannesComponent},
  {path:'statut/:id', component:ChangerStatutComponent},
  {path:'updatePanne/:id', component: UpdatePanneComponent},
  {path:'user_liste', component: UserListComponent},
  {path:'add', component: RegistreUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
