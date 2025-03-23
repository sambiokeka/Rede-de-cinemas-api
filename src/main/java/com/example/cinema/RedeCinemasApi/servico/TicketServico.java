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
    private double desconto(int idade) {
        double preco = 80.0;
        if (idade <= 11) {
            return preco * 0.5;
        } else if (idade <= 17) {
            return preco * 0.6;
        } else if (idade <= 59) {
            return preco * 0.7;
        } else {
            return preco * 0.3;
        }
    }
}