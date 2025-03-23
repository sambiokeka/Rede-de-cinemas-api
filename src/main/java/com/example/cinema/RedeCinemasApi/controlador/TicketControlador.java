package com.example.cinema.RedeCinemasApi.controlador;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketControlador {

    private final TicketRepositorio ticketRepositorio;

    public TicketControlador(TicketRepositorio ticketRepositorio) {
        this.ticketRepositorio = ticketRepositorio;
    }

    @PostMapping
    public ResponseEntity<Ticket> criarTicket(@RequestBody Ticket ticket) {
        if (ticket.getClientes() != null) {
            for (Cliente cliente : ticket.getClientes()) {
                cliente.setTicket(ticket);
            }
        }

        Ticket ticketSalvo = ticketRepositorio.save(ticket);

        return ResponseEntity.status(HttpStatus.CREATED).body(ticketSalvo);
    }
}