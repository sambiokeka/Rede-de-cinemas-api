package com.example.cinema.RedeCinemasApi.repositorio;

import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

//Cria o repositorio para a classe Ticket
public interface TicketRepositorio extends JpaRepository<Ticket, Long> {

}