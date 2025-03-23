package com.example.cinema.RedeCinemasApi.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Transforma a classe em uma entidade, para ser usada no banco de dados h2
@Entity
public class Ticket {

    //Cria uma id unica pro ticket
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Quantidade de pessoas que vão comprar o ingresso, em um único ticket
    private int quantidadePessoas;

    //Cria uma relação entre a classe Ticket e Cliente, através de uma lista de clientes
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Cliente> clientes;

    //Data e Hora da compra do ticket
    private LocalDateTime dataHoraCompra = LocalDateTime.now().withNano(0);

    //Como cada ticket pode ter varios valores de ingressos, essa variavel serve para receber a soma de todas os ingressos
    private double valorTotalTicket;

    //Inicia a lista
    public Ticket() {
        this.clientes = new ArrayList<>();
    }

    //Adiciona clientes na lista
    public void adicionarClientes(List<Cliente> clientes) {
        this.clientes = new ArrayList<>(clientes);
        calcularValorTotalTicket();
    }

    //Conta para somar os valores de ingressos de cada cliente em um ticket
    private void calcularValorTotalTicket() {
        valorTotalTicket = 0;
        for (Cliente cliente : clientes) {
            valorTotalTicket += cliente.getValorIngresso();
        }
    }

    //Getters e Setters

    //Getter e Setter para o id do ticket
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //Getter e Setter para a quantidade de clientes em um ticket
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    //Getter e Setter da lista de clientes, o Setter verifica se a quantidade de arrays da lista de clientes é diferente da quantidade de pessoas no ticket, se for ele não aceita a lista
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

    //Getter da data e da hora, não inseri um Setter por já ter definido a hora da compra antes, e não ter necessidade de alteração
    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    //Getter e Setter do valor total do ticket
    public double getValorTotalTicket() {
        return valorTotalTicket;
    }
    public void setValorTotalTicket(double valorTotalTicket) {
        this.valorTotalTicket = valorTotalTicket;
    }
}