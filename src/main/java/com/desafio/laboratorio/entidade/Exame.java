package com.desafio.laboratorio.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exame")
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idExame")
	private Long idExame;
	private String nome;

	@Enumerated(EnumType.STRING)
	private TipoExame tipo;

	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToMany
	@JoinTable(name = "laboratorio_exame", joinColumns = {
			@JoinColumn(name = "idExame", referencedColumnName = "idExame") }, inverseJoinColumns = {
					@JoinColumn(name = "idLaboratorio", referencedColumnName = "idLaboratorio") })
	@JsonBackReference
	private List<Laboratorio> listaLaboratorios = new ArrayList<>();

	public Exame(){}

	public Exame(String nome, Status status, TipoExame tipoExame){
		this.nome = nome;
		this.status = status;
		this.tipo = tipoExame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoExame getTipo() {
		return tipo;
	}

	public void setTipo(TipoExame tipo) {
		this.tipo = tipo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getIdExame() {
		return idExame;
	}

	public List<Laboratorio> getListaLaboratorios() {
		return listaLaboratorios;
	}

	public void setListaLaboratorios(List<Laboratorio> listaLaboratorios) {
		this.listaLaboratorios = listaLaboratorios;
	}

	@Override
	public String toString() {
		return "Exame [idExame=" + idExame + ", nome=" + nome + ", tipo=" + tipo + ", status=" + status + "]";
	}

}
