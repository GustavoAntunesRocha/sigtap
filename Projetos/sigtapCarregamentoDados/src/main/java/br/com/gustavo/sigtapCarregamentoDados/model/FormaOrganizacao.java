package br.com.gustavo.sigtapCarregamentoDados.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FormaOrganizacao {

	@Id
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "co_grupo")
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "co_subGrupo")
	private SubGrupo subGrupo;

	private String nome;

	private String dataCompetencia;

	public FormaOrganizacao() {
	}

	public FormaOrganizacao(int codigo, Grupo grupo, SubGrupo subGrupo, String nome, String dataCompetencia) {
		super();
		this.codigo = codigo;
		this.grupo = grupo;
		this.subGrupo = subGrupo;
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

	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
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
