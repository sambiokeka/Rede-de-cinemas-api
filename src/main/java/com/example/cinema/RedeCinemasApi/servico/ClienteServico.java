package com.example.cinema.RedeCinemasApi.servico;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

@Service
public record ClienteServico(ClienteRepositorio clienteRepositorio) {

    public Cliente salvar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

}