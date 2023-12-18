package br.org.com.recode.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservaViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataIda;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Pacote pacote;

	public ReservaViagem() {
	}

	public ReservaViagem(Long id, LocalDate dataIda, Cliente cliente, Pacote pacote) {
		this.id = id;
		this.dataIda = dataIda;
		this.cliente = cliente;
		this.pacote = pacote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	
}
