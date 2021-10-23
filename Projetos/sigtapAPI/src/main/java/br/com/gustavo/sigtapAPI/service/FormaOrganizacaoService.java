package br.com.gustavo.sigtapAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.sigtapAPI.model.FormaOrganizacao;
import br.com.gustavo.sigtapAPI.repository.FormaOrganizacaoRepository;

@Service
public class FormaOrganizacaoService {

	@Autowired
	private FormaOrganizacaoRepository formaOrganizacaoRepository;
	
	public List<FormaOrganizacao> buscaTodos(){
		return formaOrganizacaoRepository.findAll();
	}
	
	public List<FormaOrganizacao> buscaPorSubGrupo(int codigoSubGrupo){
		return formaOrganizacaoRepository.findBySubGrupoCodigo(codigoSubGrupo);
	}
	
	public FormaOrganizacao buscaPorCodigo(int codigo) {
		return formaOrganizacaoRepository.findByCodigo(codigo);
	}
	
	public List<FormaOrganizacao> buscaPorNome(String nome){
		return formaOrganizacaoRepository.findByNomeContainingIgnoreCase(nome);
	}
}
