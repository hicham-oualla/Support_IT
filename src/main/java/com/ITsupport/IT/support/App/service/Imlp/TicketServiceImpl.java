package com.ITsupport.IT.support.App.service.Imlp;

import com.ITsupport.IT.support.App.model.Technicien;
import com.ITsupport.IT.support.App.model.Ticket;
import com.ITsupport.IT.support.App.model.Utilisateur;
import com.ITsupport.IT.support.App.repository.PersonneRepository;
import com.ITsupport.IT.support.App.repository.TicketRepository;
import com.ITsupport.IT.support.App.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);

    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }



    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        if (ticketRepository.existsById(id)) {
            ticket.setTicketId(id);
            return ticketRepository.save(ticket);
        }
        return null;
    }
        @Override
    public List<Ticket> getTicketsByTechnicien(Long id) {
        Technicien technicien = (Technicien) personneRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Technicien not found"));
        List<Ticket> tickets = ticketRepository.findByTechnicien(technicien);
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByUtilisateur(Long id) {
        Utilisateur utilisateur = (Utilisateur) personneRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Utilisateur not found"));
        List<Ticket> tickets = ticketRepository.findByUtilisateur(utilisateur);
        return tickets;
    }



}
