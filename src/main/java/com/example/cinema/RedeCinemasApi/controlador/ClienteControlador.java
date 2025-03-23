package com.example.cinema.RedeCinemasApi.controlador;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.ClienteRepositorio;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    private final ClienteRepositorio clienteRepositorio;
    private final TicketRepositorio ticketRepositorio;

    public ClienteControlador(ClienteRepositorio clienteRepositorio, TicketRepositorio ticketRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.ticketRepositorio = ticketRepositorio;
    }

    //Atualiza um cliente
    @PutMapping("/{num}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long num, @RequestBody Cliente novosDadosCliente) {
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(num);
        if (!clienteExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Cliente cliente = clienteExistente.get();
        cliente.setNome(novosDadosCliente.getNome());
        cliente.setIdade(novosDadosCliente.getIdade());
        cliente.setCpf(novosDadosCliente.getCpf());
        cliente.setValorIngresso(novosDadosCliente.getValorIngresso());

        Cliente clienteAtualizado = clienteRepositorio.save(cliente);

        // Recalcular o valor total do ingresso do ticket associado
        Ticket ticket = cliente.getTicket();
        if (ticket != null) {
            ticket.setValorTotalTicket(ticket.getClientes().stream()
                    .mapToDouble(Cliente::getValorIngresso)
                    .sum());
            ticketRepositorio.save(ticket);
        }

        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
    }

    //Busca um cliente
    @GetMapping("/{num}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long num) {
        Optional<Cliente> cliente = clienteRepositorio.findById(num);
        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
    }

    //Mostra todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepositorio.findAll();
    }

    //Deleta um cliente
    @DeleteMapping("/{num}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long num) {
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(num);
        if (!clienteExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Cliente cliente = clienteExistente.get();
        Ticket ticket = cliente.getTicket();

        if (ticket != null) {
            ticket.getClientes().remove(cliente);
            ticket.setQuantidadePessoas(ticket.getQuantidadePessoas() - 1);
            ticket.setValorTotalTicket(ticket.getValorTotalTicket() - cliente.getValorIngresso());
            ticketRepositorio.save(ticket);
        }

        clienteRepositorio.delete(cliente);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}