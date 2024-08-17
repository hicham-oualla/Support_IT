import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../classes/ticket";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private url="http://localhost:9095/api/v1/auth/ticket/"

  constructor(private http: HttpClient) { }

  getTickets():Observable<Ticket[]>{
    return this.http.get<Ticket[]>(this.url+'getAll');
  }
}
