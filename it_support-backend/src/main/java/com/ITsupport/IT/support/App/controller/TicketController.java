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
@RequestMapping("api/v1/auth/ticket/")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("add")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.saveTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
        return updatedTicket != null ? ResponseEntity.ok(updatedTicket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("delet/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.getTicketById(id).isPresent()) {
            ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();



    }

    @GetMapping("ticketBytech/{id}")
    public ResponseEntity<List<Ticket>> getTicketsByTechnicien(@PathVariable Long id) {
        List<Ticket> tickets = ticketService.getTicketsByTechnicien(id);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("ticketByUser/{id}")
    public ResponseEntity<List<Ticket>> getTicketsByUtilisateur(@PathVariable Long id) {
        List<Ticket> tickets = ticketService.getTicketsByUtilisateur(id);
        return ResponseEntity.ok(tickets);
    }
    @PutMapping("/assigner/{id}")
    public Ticket assignerTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        return ticketService.assignerTicket(id, ticket);
    }
    @PutMapping("/statut/{id}")
    public Ticket changetStatut(@PathVariable Long id, @RequestBody Ticket ticket){
        return ticketService.changerStatut(id, ticket);
    }



}
