import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { EquipementComponent } from './components/equipement/equipement.component';
import { AddEquipementComponent } from './components/add-equipement/add-equipement.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UpdateEquipementComponent } from './components/update-equipement/update-equipement.component';
import { CreatePanneComponent } from './components/create-panne/create-panne.component';
import { PannesComponent } from './components/pannes/pannes.component';
import { ChangerStatutComponent } from './components/changer-statut/changer-statut.component';
import { UpdatePanneComponent } from './components/update-panne/update-panne.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { UserListComponent } from './user-list/user-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistreUserComponent } from './registre-user/registre-user.component';
import { TechListeComponent } from './tech-liste/tech-liste.component';
import { RegistreTechComponent } from './registre-tech/registre-tech.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { LoginComponent } from './components/login/login.component';
import { MaxpanneComponent } from './maxpanne/maxpanne.component';

@NgModule({
  declarations: [
    AppComponent,
    EquipementComponent,
    AddEquipementComponent,
    UpdateEquipementComponent,
    CreatePanneComponent,
    PannesComponent,
    ChangerStatutComponent,
    UpdatePanneComponent,
    SideBarComponent,
    UserListComponent,
    RegistreUserComponent,
    TechListeComponent,
    RegistreTechComponent,
    TicketsComponent,
    LoginComponent,
    MaxpanneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
