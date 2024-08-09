package com.ITsupport.IT.support.App.service;

import com.ITsupport.IT.support.App.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);
    Optional<Ticket> getTicketById(Long id);
    List<Ticket> getAllTickets();
    void deleteTicket(Long id);
    Ticket updateTicket(Long id, Ticket ticket);
}
