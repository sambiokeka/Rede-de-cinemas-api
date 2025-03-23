package com.example.cinema.RedeCinemasApi.modelo;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String nome;
    private int idade;
    private String cpf;
    private double valorIngresso;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;


    public Cliente() {
    }

    public Cliente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.valorIngresso = calcularValorIngresso(idade);
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

    // Getters e setters

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
        this.valorIngresso = calcularValorIngresso(idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}