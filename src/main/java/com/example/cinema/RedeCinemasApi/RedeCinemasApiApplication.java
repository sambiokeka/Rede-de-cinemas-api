package com.example.cinema.RedeCinemasApi;

import com.example.cinema.RedeCinemasApi.modelo.Cliente;
import com.example.cinema.RedeCinemasApi.modelo.Ticket;
import com.example.cinema.RedeCinemasApi.repositorio.TicketRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RedeCinemasApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RedeCinemasApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RedeCinemasApiApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(TicketRepositorio ticketRepositorio) {
		return (args) -> {
			// Criação de clientes
			Cliente cliente1 = new Cliente("João Henrique Queiroz Gil", 18, "123.456.789-01");
			Cliente cliente2 = new Cliente("Maria Clara Lucides", 17, "234.567.890-12");
			Cliente cliente3 = new Cliente("Carlos Henrique Lorenzini", 30, "345.678.901-23");
			Cliente cliente4 = new Cliente("Ana Clara Pan", 22, "456.789.012-34");
			Cliente cliente5 = new Cliente("Fernanda Yuumi", 62, "567.890.123-45");
			Cliente cliente6 = new Cliente("Erick Jooji Bertassoli Yamashita", 18, "678.901.234-56");
			Cliente cliente7 = new Cliente("André Pereira da Consseição", 10, "789.012.345-67");
			Cliente cliente8 = new Cliente("Vitória Luiza Gomides Ferreira", 28, "890.123.456-78");
			Cliente cliente9 = new Cliente("Pedro Carvalho da Silva", 22, "901.234.567-89");
			Cliente cliente10 = new Cliente("Marcos Carvalho Barbosa", 16, "123.890.123-12");
			Cliente cliente11 = new Cliente("Pedro Henrique Lôbo", 94, "234.567.012-34");

			// Cria os tickets, informa a quantidade de clientes do ticket, e associa os clientes ao ticket
			Ticket ticket1 = new Ticket();
			ticket1.setQuantidadePessoas(3);
			ticket1.adicionarClientes(Arrays.asList(cliente1, cliente2, cliente3));
			ticket1.getClientes().forEach(cliente -> cliente.setTicket(ticket1));

			// Cria os tickets, informa a quantidade de clientes do ticket, e associa os clientes ao ticket
			Ticket ticket2 = new Ticket();
			ticket2.setQuantidadePessoas(4);
			ticket2.adicionarClientes(Arrays.asList(cliente4, cliente5, cliente7, cliente9));
			ticket2.getClientes().forEach(cliente -> cliente.setTicket(ticket2));

			// Cria os tickets, informa a quantidade de clientes do ticket, e associa os clientes ao ticket
			Ticket ticket3 = new Ticket();
			ticket3.setQuantidadePessoas(2);
			ticket3.adicionarClientes(Arrays.asList(cliente6, cliente8));
			ticket3.getClientes().forEach(cliente -> cliente.setTicket(ticket3));

			// Cria os tickets, informa a quantidade de clientes do ticket, e associa os clientes ao ticket
			Ticket ticket4 = new Ticket();
			ticket4.setQuantidadePessoas(1);
			ticket4.adicionarClientes(Arrays.asList(cliente10));
			ticket4.getClientes().forEach(cliente -> cliente.setTicket(ticket4));

			// Cria os tickets, informa a quantidade de clientes do ticket, e associa os clientes ao ticket
			Ticket ticket5 = new Ticket();
			ticket5.setQuantidadePessoas(1);
			ticket5.adicionarClientes(Arrays.asList(cliente11));
			ticket5.getClientes().forEach(cliente -> cliente.setTicket(ticket5));

			// Salva os tickets no repositório
			ticketRepositorio.save(ticket1);
			ticketRepositorio.save(ticket2);
			ticketRepositorio.save(ticket3);
			ticketRepositorio.save(ticket4);
			ticketRepositorio.save(ticket5);
		};
	}
}