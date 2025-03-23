package com.example.cinema.RedeCinemasApi.modelo;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;
    private LocalDateTime dataHoraCompra = LocalDateTime.now().withNano(0);
    private double valorTotalIngresso;

    public Ticket() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarClientes(List<Cliente> clientes) {
        if (clientes.size() != this.quantidadePessoas) {
            throw new IllegalArgumentException();
        }
        this.clientes = new ArrayList<>(clientes);
        calcularValorTotalIngresso();
    }

    private void calcularValorTotalIngresso() {
        valorTotalIngresso = 0;
        for (Cliente cliente : clientes) {
            valorTotalIngresso += cliente.getValorIngresso();
        }
    }

    // Getters e setters

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
        calcularValorTotalIngresso();
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public double getValorTotalIngresso() {
        return valorTotalIngresso;
    }
}