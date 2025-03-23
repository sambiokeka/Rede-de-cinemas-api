package com.example.cinema.RedeCinemasApi.modelo;

public class Cliente {
    private String nomeCliente;
    private int idadeCliente;
    private double valor;

    // Getter e setter
    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getIdadeCliente() {
        return idadeCliente;
    }
    public void setIdadeCliente(int idadeCliente) {
        this.idadeCliente = idadeCliente;
        calcularValor();
    }

    public double getValor() {
        return valor;
    }
    public void calcularValor() {
        double precoBase = 80.0;
        if (idadeCliente <= 11) {
            this.valor = precoBase * 0.5;
        } else if (idadeCliente <= 17) {
            this.valor = precoBase * 0.6;
        } else if (idadeCliente <= 59) {
            this.valor = precoBase * 0.7;
        } else {
            this.valor = precoBase * 0.3;
        }
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}