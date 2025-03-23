package com.example.cinema.RedeCinemasApi.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidadeCompradores;
    private double valorIngresso;
    private LocalDateTime dataHoraCompra =  LocalDateTime.now().withNano(0);

    //getters e setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeCompradores() {
        return quantidadeCompradores;
    }
    public void setQuantidadeCompradores(int quantidadeCompradores) {
        this.quantidadeCompradores = quantidadeCompradores;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }
    public void setDataHoraCompra(LocalDateTime dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }
}