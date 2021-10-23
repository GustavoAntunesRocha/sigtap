package br.com.gustavo.sigtapAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapAPI.model.FormaOrganizacao;

public interface FormaOrganizacaoRepository extends JpaRepository<FormaOrganizacao, Integer>{

	FormaOrganizacao findByCodigo(int codigo);
	
	List<FormaOrganizacao> findBySubGrupoCodigo(int codigo);
	
	List<FormaOrganizacao> findByNomeContainingIgnoreCase(String nome);
}
