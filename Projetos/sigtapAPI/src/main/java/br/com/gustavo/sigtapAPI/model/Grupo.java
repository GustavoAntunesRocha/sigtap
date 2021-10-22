package br.com.gustavo.sigtapAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grupo {

	@Id
	private int codigo;
	
	private String nome;
	
	private String dataCompetencia;
	
	public Grupo() {}

	public Grupo(int codigo, String nome, String dataCompetencia) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCompetencia = dataCompetencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setId(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCompetencia() {
		return dataCompetencia;
	}

	public void setDataCompetencia(String dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}
}
