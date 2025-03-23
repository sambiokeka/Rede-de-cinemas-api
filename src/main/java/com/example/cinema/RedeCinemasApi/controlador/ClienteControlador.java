package com.example.cinema.RedeCinemasApi.controlador;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.repositorio.ClienteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteControlador(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepositorio.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
}