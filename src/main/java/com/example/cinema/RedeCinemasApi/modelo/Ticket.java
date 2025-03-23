package com.example.cinema.RedeCinemasApi.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private int idadeCliente;
    private double valorIngresso;

    //getters e setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdadeCliente() {
        return idadeCliente;
    }
    public void setIdadeCliente(int idadeCliente) {
        this.idadeCliente = idadeCliente;
        calcularValorIngresso();
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void calcularValorIngresso() {
        double precoBase = 80.0;
        if (idadeCliente <= 11) {
            this.valorIngresso = precoBase * 0.5;
        } else if (idadeCliente <= 17) {
            this.valorIngresso = precoBase * 0.6;
        } else if (idadeCliente <= 59) {
            this.valorIngresso = precoBase * 0.7;
        } else {
            this.valorIngresso = precoBase * 0.3;
        }
    }

}