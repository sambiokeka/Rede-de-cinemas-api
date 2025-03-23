package com.example.cinema.RedeCinemasApi.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int quantidadePessoas;
    private List<String> nomesClientes;
    private List<Integer> idadesClientes;
    private List<Double> valoresIngressos;
    private LocalDateTime dataHoraCompra = LocalDateTime.now().withNano(0);
    private double valorTotalIngresso;

    public Ticket() {
        this.nomesClientes = new ArrayList<>();
        this.idadesClientes = new ArrayList<>();
        this.valoresIngressos = new ArrayList<>();
    }

    public void adicionarNome(List<String> nomes) {
        this.nomesClientes = new ArrayList<>(nomes);
    }

    public void adicionarIdade(List<Integer> idades) {
        this.idadesClientes = new ArrayList<>(idades);
    }

    private void calcularValoresIngressos() {
        this.valoresIngressos.clear();
        for (int idade : this.idadesClientes) {
            this.valoresIngressos.add(calcularValorIngresso(idade));
        }
        calcularValorTotalIngresso();
    }

    private double calcularValorIngresso(int idade) {
        double precoBase = 80.0;
        if (idade <= 11) {
            return precoBase * 0.5;
        } else if (idade <= 17) {
            return precoBase * 0.6;
        } else if (idade <= 59) {
            return precoBase * 0.7;
        } else {
            return precoBase * 0.3;
        }
    }

    private void calcularValorTotalIngresso() {
        valorTotalIngresso = 0;
        for (double valor : valoresIngressos) {
            valorTotalIngresso += valor;
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

    public List<String> getNomesClientes() {
        return nomesClientes;
    }

    public void setNomesClientes(List<String> nomesClientes) {
        if (nomesClientes.size() != this.quantidadePessoas) {
            throw new IllegalArgumentException();
        }
        this.nomesClientes = nomesClientes;
    }

    public List<Integer> getIdadesClientes() {
        return idadesClientes;
    }

    public void setIdadesClientes(List<Integer> idadesClientes) {
        if (idadesClientes.size() != this.quantidadePessoas) {
            throw new IllegalArgumentException();
        }
        this.idadesClientes = idadesClientes;
        calcularValoresIngressos();
    }

    public List<Double> getValoresIngressos() {
        return valoresIngressos;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public double getValorTotalIngresso() {
        return valorTotalIngresso;
    }
}