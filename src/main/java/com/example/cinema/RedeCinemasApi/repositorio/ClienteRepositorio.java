package com.example.cinema.RedeCinemasApi.repositorio;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}