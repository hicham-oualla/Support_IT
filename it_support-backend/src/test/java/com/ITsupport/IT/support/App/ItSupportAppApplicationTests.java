package com.ITsupport.IT.support.App;


import com.ITsupport.IT.support.App.model.Ticket;
import com.ITsupport.IT.support.App.model.Utilisateur;
import com.ITsupport.IT.support.App.model.Technicien;
import com.ITsupport.IT.support.App.model.Equipment;
import com.ITsupport.IT.support.App.model.Panne;
import com.ITsupport.IT.support.App.model.enums.EtatTicket;
import com.ITsupport.IT.support.App.repository.TicketRepository;
import com.ITsupport.IT.support.App.service.Imlp.TicketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketServiceImplTest {

	@Mock
	private TicketRepository ticketRepository;

	@InjectMocks
	private TicketServiceImpl ticketService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void saveTicket() {
		Ticket ticket = createTestTicket();
		when(ticketRepository.save(ticket)).thenReturn(ticket);

		Ticket savedTicket = ticketService.saveTicket(ticket);

		assertNotNull(savedTicket);
		assertEquals(ticket.getTicketId(), savedTicket.getTicketId());
		verify(ticketRepository, times(1)).save(ticket);
	}

	@Test
	void getTicketById() {
		Ticket ticket = createTestTicket();
		when(ticketRepository.findById(ticket.getTicketId())).thenReturn(Optional.of(ticket));

		Optional<Ticket> foundTicket = ticketService.getTicketById(ticket.getTicketId());

		assertTrue(foundTicket.isPresent());
		assertEquals(ticket.getTicketId(), foundTicket.get().getTicketId());
		verify(ticketRepository, times(1)).findById(ticket.getTicketId());
	}

	@Test
	void getAllTickets() {
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(createTestTicket());
		tickets.add(createTestTicket());
		when(ticketRepository.findAll()).thenReturn(tickets);

		List<Ticket> allTickets = ticketService.getAllTickets();

		assertNotNull(allTickets);
		assertEquals(2, allTickets.size());
		verify(ticketRepository, times(1)).findAll();
	}

	@Test
	void deleteTicket() {
		doNothing().when(ticketRepository).deleteById(1L);

		ticketService.deleteTicket(1L);

		verify(ticketRepository, times(1)).deleteById(1L);
	}

	@Test
	void updateTicket() {
		Ticket ticket = createTestTicket();
		when(ticketRepository.existsById(ticket.getTicketId())).thenReturn(true);
		when(ticketRepository.save(ticket)).thenReturn(ticket);

		Ticket updatedTicket = ticketService.updateTicket(ticket.getTicketId(), ticket);

		assertNotNull(updatedTicket);
		assertEquals(ticket.getTicketId(), updatedTicket.getTicketId());
		verify(ticketRepository, times(1)).save(ticket);
	}

	@Test
	void updateTicketWhenNotExists() {
		Ticket ticket = createTestTicket();
		when(ticketRepository.existsById(ticket.getTicketId())).thenReturn(false);

		Ticket updatedTicket = ticketService.updateTicket(ticket.getTicketId(), ticket);

		assertNull(updatedTicket);
		verify(ticketRepository, times(0)).save(ticket);
	}

	private Ticket createTestTicket() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1L);
		ticket.setDescription("Test Ticket");
		ticket.setStatut(EtatTicket.ENCOURS);
		ticket.setUtilisateur(new Utilisateur());
		ticket.setTechnicien(new Technicien());
		ticket.setEquipment(new Equipment());
		ticket.setPanne(new Panne());
		return ticket;
	}
}
