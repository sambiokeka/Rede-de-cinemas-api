package com.example.cinema.RedeCinemasApi.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//Transforma a classe em uma entidade, para ser usada no banco de dados h2
@Entity
public class Cliente {

    //Cria um identificador para cada cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    //Nome do cliente
    private String nome;

    //Idade do cliente
    private int idade;

    //CPF do cliente
    private String cpf;

    //Valor do ingresso de cada cliente
    private double valorIngresso;

    //Cria uma relação entre a classe Cliente e Ticket
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonBackReference
    private Ticket ticket;

    //Construtor padrão
    public Cliente() {
    }

    //Contrutor com argumentos
    public Cliente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = idade <= 11 ? null : cpf;
        this.valorIngresso = calcularValorIngresso(idade);
    }

    //Calcula o valor do ingresso de cada cliente
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

    //Getters e setters

    //Getter e Setter dos identificadores do cliente
    public Long getNum() {
        return num;
    }
    public void setNum(Long num) {
        this.num = num;
    }

    //Getter e Setter do nome do cliente
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter e Setter da idade do cliente
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
        this.valorIngresso = calcularValorIngresso(idade);
        if (idade <= 11) {
            this.cpf = null;
        }
    }

    //Getter e Setter do CPF de um cliente, se o cliente for menor de 11 anos o CPF dele pode receber o valor null, caso não seja e receba o valor de null não será aceito
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (this.idade > 11 && cpf == null) {
            throw new IllegalArgumentException("CPF cannot be null for clients older than 11 years");
        }
        this.cpf = cpf;
    }

    //Getter e Setter do valor de ingresso de cada cliente
    public double getValorIngresso() {
        return valorIngresso;
    }
    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    //Setter e Getter do ticket
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public Ticket getTicket() {
        return this.ticket;
    }
}