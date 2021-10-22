package br.com.gustavo.sigtapAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubGrupo {

	@Id
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "co_grupo")
	private Grupo grupo;
	
	private String nome;
	
	private String dataCompetencia;
	
	public SubGrupo () {}

	public SubGrupo(int codigo, Grupo grupo, String nome, String dataCompetencia) {
		super();
		this.codigo = codigo;
		this.grupo = grupo;
		this.nome = nome;
		this.dataCompetencia = dataCompetencia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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
