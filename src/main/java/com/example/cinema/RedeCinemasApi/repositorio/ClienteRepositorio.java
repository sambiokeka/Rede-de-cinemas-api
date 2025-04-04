package com.example.cinema.RedeCinemasApi.repositorio;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Cria o repositorio para a classe Cliente
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}