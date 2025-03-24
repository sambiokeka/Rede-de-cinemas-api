package com.example.cinema.RedeCinemasApi.controlador;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        return ticketRepositorio.findById(id)
                .map(ticket -> ResponseEntity.ok().body(ticket))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepositorio.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> atualizarTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Optional<Ticket> optionalTicket = ticketRepositorio.findById(id);

        if (!optionalTicket.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Ticket ticket = optionalTicket.get();

        if (ticketDetails.getClientes() != null) {
            if (ticketDetails.getClientes().size() != ticketDetails.getQuantidadePessoas()) {
                return ResponseEntity.badRequest().build();
            }
            ticket.getClientes().clear();
            for (Cliente cliente : ticketDetails.getClientes()) {
                cliente.setTicket(ticket);
                ticket.getClientes().add(cliente);
            }
        }

        ticket.setQuantidadePessoas(ticketDetails.getQuantidadePessoas());
        ticket.calcularValorTotalTicket(); 
        Ticket updatedTicket = ticketRepositorio.save(ticket);

        return ResponseEntity.ok().body(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTicket(@PathVariable Long id) {
        return ticketRepositorio.findById(id)
                .map(ticket -> {
                    ticketRepositorio.delete(ticket);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
