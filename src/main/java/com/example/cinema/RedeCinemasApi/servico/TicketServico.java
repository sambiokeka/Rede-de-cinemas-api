package com.example.cinema.RedeCinemasApi.servico;

import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public record TicketServico(TicketRepositorio ticketRepositorio) {

    public Ticket salvar(Ticket ticket) {
        return ticketRepositorio.save(ticket);
    }

}