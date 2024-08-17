import {Component, OnInit} from '@angular/core';
import {Ticket} from "../../classes/ticket";
import {TicketService} from "../../services/ticket.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit{

  Tickets!: Ticket[];

  constructor(private service: TicketService, private router: Router) {
  }

  ngOnInit(): void {
    this.getTickets();
    this.router.navigate(['tickets'])
  }

  getTickets(){
    this.service.getTickets().subscribe(
      data=>{
        console.log(data);
        this.Tickets=data;
      }
    )
  }

  protected readonly Ticket = Ticket;
}
