package br.org.com.recode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pacote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valor;
	private int diarias;
	private String destino;
    
	

    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    
	public Pacote() {
	}

	public Pacote(Long id, Double valor, int diarias, String destino) {
		this.id = id;
		this.valor = valor;
		this.diarias = diarias;
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
