package br.com.gustavo.sigtapAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.sigtapAPI.model.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer>{

	List<Procedimento> findByNomeContainingIgnoreCase(String nome);
	
	List<Procedimento> findByFormaOrganizacaoCodigo(int codigo);
	
	List<Procedimento> findByGrupoCodigo(int codigo);
	
	List<Procedimento> findBySubGrupoCodigo(int codigo);
}
