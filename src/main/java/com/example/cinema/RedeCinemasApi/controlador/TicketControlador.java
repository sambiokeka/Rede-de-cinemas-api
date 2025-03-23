package com.example.cinema.RedeCinemasApi.controlador;

import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.servico.TicketServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public record TicketControlador(TicketServico ticketServico) {
    @PostMapping
    public Ticket salvar(@RequestBody Ticket ticket){
        return ticketServico.salvar(ticket);
    }
}
