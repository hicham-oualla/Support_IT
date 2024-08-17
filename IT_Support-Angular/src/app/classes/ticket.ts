import {StatutTicket} from "./statut-ticket";
import {EtatTicket} from "../roles";
import {User} from "./user";
import {Equipement} from "./equipement";
import {Panne} from "./panne";
import {Technicien} from "./technicien";

export class Ticket {
  ticketId!:number;
  description!:string;
  etatTicket!:EtatTicket;
  user!:User;
  equipement!:Equipement;
  dateDeCreation!:Date;
  panne!:Panne;
  technicien!:Technicien;
}
