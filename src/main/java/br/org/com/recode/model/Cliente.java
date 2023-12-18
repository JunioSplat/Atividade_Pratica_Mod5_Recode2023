package br.org.com.recode.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enderecoCliente;
    private String nomeCliente;
    private String emailCliente;
    private String cepCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pacote> pacotes;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservaViagem> reservasViagem;


    public Cliente() {
    }

    public Cliente(Long id, String enderecoCliente, String nomeCliente, String emailCliente, String cepCliente) {
        this.id = id;
        this.enderecoCliente = enderecoCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.cepCliente = cepCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

    public List<ReservaViagem> getReservasViagem() {
        return reservasViagem;
    }

    public void setReservasViagem(List<ReservaViagem> reservasViagem) {
        this.reservasViagem = reservasViagem;
    }
}
