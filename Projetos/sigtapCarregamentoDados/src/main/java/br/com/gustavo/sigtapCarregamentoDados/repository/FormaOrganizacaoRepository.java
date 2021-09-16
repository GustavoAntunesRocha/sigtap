package br.com.gustavo.sigtapCarregamentoDados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapCarregamentoDados.model.FormaOrganizacao;

public interface FormaOrganizacaoRepository extends JpaRepository<FormaOrganizacao, Integer>{

	FormaOrganizacao findByCodigo(int codigo);
}
