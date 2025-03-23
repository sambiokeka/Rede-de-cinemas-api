package com.example.cinema.RedeCinemasApi.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidadePessoas;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Cliente> clientes;
    private LocalDateTime dataHoraCompra = LocalDateTime.now().withNano(0);
    private double valorTotalTicket;

    public Ticket() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarClientes(List<Cliente> clientes) {
        if (clientes.size() != this.quantidadePessoas) {
            throw new IllegalArgumentException();
        }
        this.clientes = new ArrayList<>(clientes);
        calcularValorTotalTicket();
    }

    private void calcularValorTotalTicket() {
        valorTotalTicket = 0;
        for (Cliente cliente : clientes) {
            valorTotalTicket += cliente.getValorIngresso();
        }
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }


    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        if (clientes.size() != this.quantidadePessoas) {
            throw new IllegalArgumentException();
        }
        this.clientes = clientes;
        calcularValorTotalTicket();
    }


    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }


    public double getValorTotalTicket() {
        return valorTotalTicket;
    }
    public void setValorTotalTicket(double valorTotalTicket) {
        this.valorTotalTicket = valorTotalTicket;
    }
}