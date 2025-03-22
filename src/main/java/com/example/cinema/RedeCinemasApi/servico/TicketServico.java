package com.example.cinema.RedeCinemasApi.servico;

import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServico {

    @Autowired
    private TicketRepositorio ticketRepositorio;

    public List<Ticket> getAllTickets() {
        return ticketRepositorio.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepositorio.findById(id).orElse(null);
    }

    public Ticket saveTicket(Ticket ticket) {
        ticket.setValorIngresso(desconto(ticket.getIdadeCliente()));
        return ticketRepositorio.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = ticketRepositorio.findById(id).orElse(null);
        if (ticket != null) {
            ticket.setNomeCliente(ticketDetails.getNomeCliente());
            ticket.setIdadeCliente(ticketDetails.getIdadeCliente());
            ticket.setValorIngresso(desconto(ticketDetails.getIdadeCliente()));
            return ticketRepositorio.save(ticket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepositorio.deleteById(id);
    }

    private double desconto(int idade) {
        double basePrice = 80.0;
        if (idade <= 11) {
            return basePrice * 0.5;
        } else if (idade <= 17) {
            return basePrice * 0.6;
        } else if (idade <= 59) {
            return basePrice * 0.7;
        } else {
            return basePrice * 0.3;
        }
    }
}