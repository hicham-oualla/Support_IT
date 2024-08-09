package com.ITsupport.IT.support.App.controller;

import com.ITsupport.IT.support.App.model.Ticket;
import com.ITsupport.IT.support.App.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("utilisateur/tickets/add")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.saveTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("utilisateur/tickets/getAll")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
        return updatedTicket != null ? ResponseEntity.ok(updatedTicket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("tickets/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.getTicketById(id).isPresent()) {
            ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();



    }

    @GetMapping("Admin/ticketBytech{id}")
    public ResponseEntity<List<Ticket>> getTicketsByTechnicien(@PathVariable Long id) {
        List<Ticket> tickets = ticketService.getTicketsByTechnicien(id);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("Admin/ticketByUser{id}")
    public ResponseEntity<List<Ticket>> getTicketsByUtilisateur(@PathVariable Long id) {
        List<Ticket> tickets = ticketService.getTicketsByUtilisateur(id);
        return ResponseEntity.ok(tickets);
    }


}
