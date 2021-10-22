package br.com.gustavo.sigtapAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Procedimento {

	@Id
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "co_grupo")
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "co_subGrupo")
	private SubGrupo subGrupo;

	@ManyToOne
	@JoinColumn(name = "co_formaOrganizacao")
	private FormaOrganizacao formaOrganizacao;

	private String nome;

	private String complexidade;

	private String sexo;

	private int qtdMaxima;

	private int qtdDiasPermanencia;

	private int qtdPontos;

	private int idadeMinima;

	private int idadeMaxima;

	private int valorServicoHospitalar;

	private int valorServicoAmbulatorial;

	private int valorServicoProfissional;

	private String dataCompetencia;

	public Procedimento() {
	}

	public Procedimento(int codigo, Grupo grupo, SubGrupo subGrupo, FormaOrganizacao formaOrganizacao, String nome,
			String complexidade, String sexo, int qtdMaxima, int qtdDiasPermanencia, int qtdPontos, int idadeMinima,
			int idadeMaxima, int valorServicoHospitalar, int valorServicoAmbulatorial, int valorServicoProfissional,
			String dataCompetencia) {
		super();
		this.codigo = codigo;
		this.grupo = grupo;
		this.subGrupo = subGrupo;
		this.formaOrganizacao = formaOrganizacao;
		this.nome = nome;
		this.complexidade = complexidade;
		this.sexo = sexo;
		this.qtdMaxima = qtdMaxima;
		this.qtdDiasPermanencia = qtdDiasPermanencia;
		this.qtdPontos = qtdPontos;
		this.idadeMinima = idadeMinima;
		this.idadeMaxima = idadeMaxima;
		this.valorServicoHospitalar = valorServicoHospitalar;
		this.valorServicoAmbulatorial = valorServicoAmbulatorial;
		this.valorServicoProfissional = valorServicoProfissional;
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

	public FormaOrganizacao getFormaOrganizacao() {
		return formaOrganizacao;
	}

	public void setFormaOrganizacao(FormaOrganizacao formaOrganizacao) {
		this.formaOrganizacao = formaOrganizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}

	public int getQtdDiasPermanencia() {
		return qtdDiasPermanencia;
	}

	public void setQtdDiasPermanencia(int qtdDiasPermanencia) {
		this.qtdDiasPermanencia = qtdDiasPermanencia;
	}

	public int getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(int qtdPontos) {
		this.qtdPontos = qtdPontos;
	}

	public int getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public int getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(int idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}

	public int getValorServicoHospitalar() {
		return valorServicoHospitalar;
	}

	public void setValorServicoHospitalar(int valorServicoHospitalar) {
		this.valorServicoHospitalar = valorServicoHospitalar;
	}

	public int getValorServicoAmbulatorial() {
		return valorServicoAmbulatorial;
	}

	public void setValorServicoAmbulatorial(int valorServicoAmbulatorial) {
		this.valorServicoAmbulatorial = valorServicoAmbulatorial;
	}

	public int getValorServicoProfissional() {
		return valorServicoProfissional;
	}

	public void setValorServicoProfissional(int valorServicoProfissional) {
		this.valorServicoProfissional = valorServicoProfissional;
	}

	public String getDataCompetencia() {
		return dataCompetencia;
	}

	public void setDataCompetencia(String dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}
}
